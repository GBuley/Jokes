package grant.com.jokemaker.repo.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://v2.jokeapi.dev/"
    private val client = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }.let { OkHttpClient.Builder().addInterceptor(it).build() }

    val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create()).client(client).build()

    val jokeService by lazy { retrofit.create(JokeService::class.java)}
}