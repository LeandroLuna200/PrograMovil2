package ar.edu.unlam.mobile.scaffold.data.joke.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JokeRepository@Inject constructor(private val api: ChuckNorrisAPI) : JokeNetworkRepository {
    override suspend fun getRandomJoke(): Flow<JokeAPIModel> {
        return flow {
            emit(api.getJokes()[0])
        }
    }
    }



