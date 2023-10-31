package ar.edu.unlam.mobile.scaffold.domain.habit.di

import ar.edu.unlam.mobile.scaffold.domain.habit.services.JokeGetter
import ar.edu.unlam.mobile.scaffold.domain.habit.services.JokeService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class JokeDomainModule {

    @Binds
    abstract fun bindJokeUseCase(jokeUseCaseImpl: JokeService): JokeGetter
}
