import java.io.*
import java.time.LocalDateTime
import java.time.ZoneOffset

class Data {
    fun fetchNews(): List<NewsEntry> {
        return mutableListOf(
            NewsEntry(LocalDateTime.now(), "Server maintenance expected on 4th of July around 10 PM", "adminA"),
            NewsEntry(LocalDateTime.now(), "Promotional coupons for all electronics buyers!!!", "adminB"),
            NewsEntry(LocalDateTime.now(), "New feature release: Real-time chat functionality", "adminC"),
            NewsEntry(LocalDateTime.now(), "Upcoming webinar: Introduction to Machine Learning", "adminD"),
            NewsEntry(LocalDateTime.now(), "Important security update: Please reset your passwords", "adminE"),
            NewsEntry(LocalDateTime.now(), "Holiday sale: Get 50% off on all products", "adminF"),
            NewsEntry(LocalDateTime.now(), "Service disruption notification: Scheduled maintenance on 15th July", "adminG"),
            NewsEntry(LocalDateTime.now(), "New blog post: Tips and tricks for efficient coding", "adminH"),
            NewsEntry(LocalDateTime.now(), "Announcing our partnership with XYZ company", "adminI"),
            NewsEntry(LocalDateTime.now(), "Product launch event: Join us on 20th July", "adminJ"),
            NewsEntry(LocalDateTime.now(), "Important update for mobile app users: Version 2.0.1 now available", "adminK"),
            NewsEntry(LocalDateTime.now(), "Weekly newsletter: Stay updated with the latest news and updates", "adminL"),
            NewsEntry(LocalDateTime.now(), "Customer feedback survey: Share your valuable inputs and win exciting prizes", "adminM"),
            NewsEntry(LocalDateTime.now(), "New support center: Access our comprehensive knowledge base", "adminN"),
            NewsEntry(LocalDateTime.now(), "Limited-time offer: Buy one, get one free", "adminO"),
            NewsEntry(LocalDateTime.now(), "System maintenance completed: All services restored", "adminP"),
            NewsEntry(LocalDateTime.now(), "Introducing our new mobile app: Download now and experience the enhanced features", "adminQ"),
            NewsEntry(LocalDateTime.now(), "Important notice for all customers: Updated terms and conditions", "adminR"),
            NewsEntry(LocalDateTime.now(), "Webinar recording available: Learn the best practices for effective project management", "adminS"),
            NewsEntry(LocalDateTime.now(), "New video tutorial: Master the art of graphic design with our step-by-step guide", "adminT"),
            NewsEntry(LocalDateTime.now(), "Job openings: Join our team of talented professionals", "adminU"),
            NewsEntry(LocalDateTime.now(), "Limited stock alert: Grab your favorite products before they sell out", "adminV"),
            NewsEntry(LocalDateTime.now(), "Server maintenance expected on 4th of July around 10 PM", "adminA"),
            NewsEntry(LocalDateTime.now(), "New feature announcement coming soon!", "adminB"),
            NewsEntry(LocalDateTime.now(), "Upcoming webinar on the latest industry trends", "adminC"),
            NewsEntry(LocalDateTime.now(), "Important security update for all users", "adminD"),
            NewsEntry(LocalDateTime.now(), "System downtime scheduled for maintenance", "adminE"),
            NewsEntry(LocalDateTime.now(), "Introducing our new customer support portal", "adminF"),
            NewsEntry(LocalDateTime.now(), "Holiday office closure notice", "adminG"),
            NewsEntry(LocalDateTime.now(), "New version release notes now available", "adminH"),
            NewsEntry(LocalDateTime.now(), "Reminder: User training session tomorrow", "adminI"),
            NewsEntry(LocalDateTime.now(), "Emergency maintenance in progress", "adminJ")
        )
    }

    fun fetchUpdates(): List<UpdatesEntry> {
        return mutableListOf(
            UpdatesEntry(LocalDateTime.now(), "Initial version", "1.0.0"),
            UpdatesEntry(LocalDateTime.now(), "Improved performance", "1.0.1"),
            UpdatesEntry(LocalDateTime.now(), "Added core functionality", "1.0.2"),
            UpdatesEntry(LocalDateTime.now(), "Initial release", "1.1.0"),
            UpdatesEntry(LocalDateTime.now(), "Fixed critical security vulnerability", "1.1.1"),
            UpdatesEntry(LocalDateTime.now(), "Enhanced compatibility with third-party libraries", "1.1.2"),
            UpdatesEntry(LocalDateTime.now(), "Introduced advanced settings", "1.1.3"),
            UpdatesEntry(LocalDateTime.now(), "Improved stability", "1.2.0"),
            UpdatesEntry(LocalDateTime.now(), "Added new feature set", "1.2.1"),
            UpdatesEntry(LocalDateTime.now(), "Bug fixes and optimizations", "1.2.2"),
            UpdatesEntry(LocalDateTime.now(), "Fixed minor bugs", "1.3.0"),
            UpdatesEntry(LocalDateTime.now(), "Improved performance", "1.3.1"),
            UpdatesEntry(LocalDateTime.now(), "Enhanced user interface", "1.3.2"),
            UpdatesEntry(LocalDateTime.now(), "Introduced new functionality", "1.4.0"),
            UpdatesEntry(LocalDateTime.now(), "Fixed compatibility issues", "1.4.1"),
            UpdatesEntry(LocalDateTime.now(), "Improved user experience", "1.4.2"),
            UpdatesEntry(LocalDateTime.now(), "Added support for internationalization", "1.4.3"),
            UpdatesEntry(LocalDateTime.now(), "Enhanced security measures", "1.5.0"),
            UpdatesEntry(LocalDateTime.now(), "Bug fixes and UI enhancements", "1.5.1"),
            UpdatesEntry(LocalDateTime.now(), "Added new features", "1.5.2"),
            UpdatesEntry(LocalDateTime.now(), "Improved performance and stability", "1.6.0"),
            UpdatesEntry(LocalDateTime.now(), "Fixed critical bugs", "1.6.1"),
            UpdatesEntry(LocalDateTime.now(), "Added translation to Croatian, Slovenian and Serbian", "1.7.0"),
            UpdatesEntry(LocalDateTime.now(), "Fixed some bugs", "1.7.1"),
            UpdatesEntry(LocalDateTime.now(), "Improved performance and stability", "1.7.2"),
            UpdatesEntry(LocalDateTime.now(), "Added support for dark mode", "1.8.0"),
            UpdatesEntry(LocalDateTime.now(), "Bug fixes and UI enhancements", "1.8.1"),
            UpdatesEntry(LocalDateTime.now(), "Introducing new dashboard widgets", "1.9.0"),
            UpdatesEntry(LocalDateTime.now(), "Enhanced data encryption for increased security", "1.9.1"),
            UpdatesEntry(LocalDateTime.now(), "Improved user interface for better user experience", "1.9.2"),
            UpdatesEntry(LocalDateTime.now(), "Optimized database queries for faster response times", "1.10.0"),
            UpdatesEntry(LocalDateTime.now(), "Added new report generation feature", "1.10.1"),
            UpdatesEntry(LocalDateTime.now(), "Bug fixes and performance improvements", "1.10.2"),
            UpdatesEntry(LocalDateTime.now(), "Introducing new payment gateway integration", "1.11.0"),
            UpdatesEntry(LocalDateTime.now(), "Enhanced data import/export functionality", "1.11.1"),
            UpdatesEntry(LocalDateTime.now(), "Improved accessibility options for users with disabilities", "1.11.2"),
            UpdatesEntry(LocalDateTime.now(), "Optimized memory usage for better resource management", "1.12.0"),
            UpdatesEntry(LocalDateTime.now(), "Added support for multiple languages", "1.12.1"),
            UpdatesEntry(LocalDateTime.now(), "Bug fixes and stability enhancements", "1.12.2"),
            UpdatesEntry(LocalDateTime.now(), "Introducing new integration with third-party APIs", "1.13.0"),
            UpdatesEntry(LocalDateTime.now(), "Enhanced reporting capabilities with advanced filters", "1.13.1"),
            UpdatesEntry(LocalDateTime.now(), "Improved error handling and logging", "1.13.2"),
            UpdatesEntry(LocalDateTime.now(), "Optimized caching mechanism for faster data retrieval", "1.14.0"),
            UpdatesEntry(LocalDateTime.now(), "Added new customization options for user profiles", "1.14.1")
        )
    }

    fun serializeToBin(obj: Any, filePath: String) {
        val file = File(filePath)
        val fos = FileOutputStream(file)
        val dos = DataOutputStream(fos)

        when (obj) {
            is List<*> -> {
                dos.writeInt(obj.size)
                obj.forEach { item ->
                    when (item) {
                        is NewsEntry -> {
                            dos.writeByte(0) // Marker for NewsEntry
                            dos.writeLong(item.date.toEpochSecond(ZoneOffset.UTC))
                            dos.writeUTF(item.content)
                            dos.writeUTF(item.username)
                        }
                        is UpdatesEntry -> {
                            dos.writeByte(1) // Marker for UpdatesEntry
                            dos.writeLong(item.date.toEpochSecond(ZoneOffset.UTC))
                            dos.writeUTF(item.content)
                            dos.writeUTF(item.version)
                        }
                    }
                }
            }
        }

        dos.close()
        fos.close()
        println("Serialized object to $filePath")
    }

    fun deserializeFromBin(filePath: String): List<Any> {
        val file = File(filePath)
        val fis = FileInputStream(file)
        val dis = DataInputStream(fis)

        val result = mutableListOf<Any>()

        val itemCount = dis.readInt()
        repeat(itemCount) {
            val marker = dis.readByte()
            when (marker) {
                0.toByte() -> {
                    val date = LocalDateTime.ofEpochSecond(dis.readLong(), 0, ZoneOffset.UTC)
                    val content = dis.readUTF()
                    val username = dis.readUTF()
                    val entry = NewsEntry(date, content, username)
                    result.add(entry)
                }
                1.toByte() -> {
                    val date = LocalDateTime.ofEpochSecond(dis.readLong(), 0, ZoneOffset.UTC)
                    val content = dis.readUTF()
                    val version = dis.readUTF()
                    val entry = UpdatesEntry(date, content, version)
                    result.add(entry)
                }
            }
        }

        dis.close()
        fis.close()

        return result
    }

}