package ar.edu.unlam.mobile.scaffold.data.habit.network

import retrofit2.http.GET

interface ChuckNorrisAPI {
    @GET("jokes/random?category={category}")
    suspend fun getJokes(): List<JokeAPIModel>
}