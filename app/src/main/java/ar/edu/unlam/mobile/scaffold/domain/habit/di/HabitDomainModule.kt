package ar.edu.unlam.mobile.scaffold.domain.habit.di

import ar.edu.unlam.mobile.scaffold.domain.habit.services.HabitGetter
import ar.edu.unlam.mobile.scaffold.domain.habit.services.HabitService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HabitDomainModule {
    @Binds
    abstract fun bindHabitUseCase(habitUseCaseImpl: HabitService): HabitGetter
}
