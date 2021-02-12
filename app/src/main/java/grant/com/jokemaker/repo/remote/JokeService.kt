package grant.com.jokemaker.repo.remote

import grant.com.jokemaker.model.Joke
import grant.com.jokemaker.model.JokeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JokeService {

    @GET("joke/{type}")
    suspend fun getJokes(@Path("type")type:String, @Query("amount") number :Int) : JokeResponse
}