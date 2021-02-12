package grant.com.jokemaker.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Joke(
    val error: Boolean?,
    val category: String?,
    val type: String?,
    val setup: String?,
    val delivery: String?,
    val joke: String?,
    val flags: Flags?,
    val id: Int?,
    val safe: Boolean?,
    val lang: String?
)