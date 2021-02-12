package grant.com.jokemaker.repo

import grant.com.jokemaker.model.Joke
import grant.com.jokemaker.model.JokeResponse
import grant.com.jokemaker.repo.remote.RetrofitInstance

object JokeRepository {

    suspend fun getJokes(jokeType:String, amount:Int) : JokeResponse {
        return RetrofitInstance.jokeService.getJokes(jokeType, amount)
    }

}