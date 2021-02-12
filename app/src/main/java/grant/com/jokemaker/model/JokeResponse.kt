package grant.com.jokemaker.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JokeResponse (
    val jokes : List<Joke>
 )