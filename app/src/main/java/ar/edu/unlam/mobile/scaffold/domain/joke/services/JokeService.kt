package ar.edu.unlam.mobile.scaffold.domain.joke.services

import ar.edu.unlam.mobile.scaffold.data.joke.repository.JokeRepository
import ar.edu.unlam.mobile.scaffold.domain.joke.models.Joke
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class JokeService @Inject constructor(val repository: JokeRepository) : JokeGetter {
    override suspend fun getJoke(): Flow<Joke> {
        return this.repository.getJoke()
    }
}
