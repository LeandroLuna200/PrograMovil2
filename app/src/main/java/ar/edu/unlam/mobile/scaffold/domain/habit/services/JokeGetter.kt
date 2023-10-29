package ar.edu.unlam.mobile.scaffold.domain.habit.services

import ar.edu.unlam.mobile.scaffold.domain.habit.models.Joke
import kotlinx.coroutines.flow.Flow

interface JokeGetter {
    suspend fun getJoke(): Flow<Joke>
}
