package ar.edu.unlam.mobile.scaffold.data.joke.repository

import ar.edu.unlam.mobile.scaffold.domain.joke.models.Joke
import kotlinx.coroutines.flow.Flow

interface JokeRepository {
    suspend fun getJoke(): Flow<Joke>
}
