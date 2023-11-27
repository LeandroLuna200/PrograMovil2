package ar.edu.unlam.mobile.scaffold.data.joke.network

import retrofit2.http.GET

interface ChuckNorrisAPI {
    @GET("/jokes/random")
    suspend fun getJoke(): JokeAPIModel
}
