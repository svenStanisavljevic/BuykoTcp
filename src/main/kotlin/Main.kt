import java.io.*
import java.net.ServerSocket
import java.net.Socket
import java.nio.file.Files
import java.nio.file.Paths
import java.security.KeyFactory
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.spec.X509EncodedKeySpec
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

fun main() {

    val path = "src/main/resources/"

    val data = Data()

    val news = data.fetchNews()
    val updates = data.fetchUpdates()

    data.serializeToBin(news, "${path}news.bin")
    data.serializeToBin(updates, "${path}updates.bin")

    val deserializedNews = data.deserializeFromBin("${path}news.bin")
    val deserializedUpdates = data.deserializeFromBin("${path}updates.bin")

    deserializedNews.forEach { entry ->
        println("Deserialized News Entry: $entry")
    }

    deserializedUpdates.forEach { entry ->
        println("Deserialized Updates Entry: $entry")
    }

    val keyPair = generateKeyPair()
    val secretKey = generateAESKey()
    println("AES key: ${Base64.getEncoder().encodeToString(secretKey.encoded)}")

    Files.delete(Paths.get("${path}encrypted-language-pack.xml"))

    encryptFileAES("${path}language-pack.xml", "${path}encrypted-language-pack.xml", secretKey)
    encryptFileAES("${path}news.bin", "${path}encrypted-news.bin", secretKey)
    encryptFileAES("${path}updates.bin", "${path}encrypted-updates.bin", secretKey)

    val serverSocketKey = createSocket(12340)
    val serverSocket1 = createSocket(12345)
    val serverSocket2 = createSocket(12346)
    val serverSocket3 = createSocket(12347)


    while (true) {
        val clientSocketKey = serverSocketKey.accept()
        serveKey(clientSocketKey, secretKey)

        val clientSocket1 = serverSocket1.accept()
        serveFile(clientSocket1, "${path}encrypted-language-pack.xml")

        val clientSocket2 = serverSocket2.accept()
        serveFile(clientSocket2, "${path}encrypted-updates.bin")

        val clientSocket3 = serverSocket3.accept()
        serveFile(clientSocket3, "${path}encrypted-news.bin")
    }

}

private fun createSocket(port: Int): ServerSocket {
    val serverSocket = ServerSocket(port)
    println("Server started. Listening on port $port...")
    return serverSocket
}

private fun serveKey(clientSocket: Socket, secretKey: SecretKey) {

    println("Client connected on port 12340")

    val keyBytes = secretKey.encoded
    val dis = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
    val dos = DataOutputStream(clientSocket.getOutputStream())

    val rsaKeyEncoded = dis.readLine()
    val encryptedKeyBytes = RSAencodeAESKey(rsaKeyEncoded, keyBytes)
    println(rsaKeyEncoded)

    dos.writeInt(encryptedKeyBytes.size)
    dos.write(encryptedKeyBytes)
    dos.flush()
    dos.close()

    println("Encrypted AES Key: ${Base64.getEncoder().encodeToString(encryptedKeyBytes)}")
    clientSocket.close()
    println("Client disconnected")
}

private fun serveFile(clientSocket: Socket, filePath: String) {
    println("Client connected")

    val file = File(filePath)
    val outputStream = BufferedOutputStream(clientSocket.getOutputStream())

    val fileInputStream = FileInputStream(file)
    val buffer = ByteArray(1024)
    var bytesRead: Int

    while (fileInputStream.read(buffer).also { bytesRead = it } != -1) {
        outputStream.write(buffer, 0, bytesRead)
    }

    outputStream.flush()
    outputStream.close()
    fileInputStream.close()

    println("File $filePath sent to client.")
    clientSocket.close()
    println("Client disconnected.")
}

private fun RSAencodeAESKey(rsa: String, aes: ByteArray): ByteArray {

    val rsaBytes = Base64.getDecoder().decode(rsa)
    val keySpec = X509EncodedKeySpec(rsaBytes)
    val keyFactory = KeyFactory.getInstance("RSA")
    val publicKey = keyFactory.generatePublic(keySpec)

    val cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")
    cipher.init(Cipher.ENCRYPT_MODE, publicKey)
    return cipher.doFinal(aes)
}

private fun generateKeyPair(): KeyPair {
    val keyPairGenerator = KeyPairGenerator.getInstance("RSA")
    keyPairGenerator.initialize(2048)
    return keyPairGenerator.generateKeyPair()
}

private fun generateAESKey(): SecretKey {
    val keyGenerator = KeyGenerator.getInstance("AES")
    keyGenerator.init(256)
    return keyGenerator.generateKey()
}

private fun encryptFileAES(inputFilePath: String, outputFilePath: String, secretKey: SecretKey) {
    val inputBytes = Files.readAllBytes(Paths.get(inputFilePath))
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, secretKey)
    val encryptedBytes = cipher.doFinal(inputBytes)
    val encodedBytes = Base64.getEncoder().encodeToString(encryptedBytes)
    Files.write(Paths.get(outputFilePath), encodedBytes.toByteArray())

}