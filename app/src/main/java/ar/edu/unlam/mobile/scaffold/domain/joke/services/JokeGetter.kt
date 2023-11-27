package ar.edu.unlam.mobile.scaffold.domain.joke.services

import ar.edu.unlam.mobile.scaffold.domain.joke.models.Joke
import kotlinx.coroutines.flow.Flow

interface JokeGetter {
    suspend fun getJoke(): Flow<Joke>
}
