package ar.edu.unlam.mobile.scaffold.data.joke.repository

import ar.edu.unlam.mobile.scaffold.data.joke.network.JokeNetworkRepository
import ar.edu.unlam.mobile.scaffold.domain.joke.models.Joke
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class JokeDefaultRepository @Inject constructor(val networkRepository: JokeNetworkRepository) :
    JokeRepository {
    override suspend fun getJoke(): Flow<Joke> {
        return this.networkRepository.getRandomJoke().map { it.toJoke() }
    }
}
