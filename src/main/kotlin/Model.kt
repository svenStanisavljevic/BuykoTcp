import java.time.LocalDateTime

data class NewsEntry(
    val date: LocalDateTime,
    val content: String,
    val username: String,
)

data class UpdatesEntry(
    val date: LocalDateTime,
    val content: String,
    val version: String,
)