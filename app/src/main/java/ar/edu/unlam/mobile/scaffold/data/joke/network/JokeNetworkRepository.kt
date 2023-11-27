package ar.edu.unlam.mobile.scaffold.data.joke.network

import kotlinx.coroutines.flow.Flow

interface JokeNetworkRepository {
    suspend fun getRandomJoke(): Flow<JokeAPIModel>
}
