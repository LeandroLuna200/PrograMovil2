package ar.edu.unlam.mobile.scaffold.data.joke.di

import ar.edu.unlam.mobile.scaffold.data.joke.network.JokeHTTPRepository
import ar.edu.unlam.mobile.scaffold.data.joke.network.JokeNetworkRepository
import ar.edu.unlam.mobile.scaffold.data.joke.repository.JokeDefaultRepository
import ar.edu.unlam.mobile.scaffold.data.joke.repository.JokeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class JokeDataModule {
    @Binds
    abstract fun bindJokeRepository(jokeRepositoryImpl: JokeDefaultRepository): JokeRepository

    @Binds
    abstract fun bindJokeNetworkRepo(jokeHTTPClient: JokeHTTPRepository): JokeNetworkRepository
}
