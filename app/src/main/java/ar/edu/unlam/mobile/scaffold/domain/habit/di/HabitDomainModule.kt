package ar.edu.unlam.mobile.scaffold.domain.habit.di

import ar.edu.unlam.mobile.scaffold.ui.screens.PlannerViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HabitDomainModule {
    @Provides
    @Singleton
    fun providePlannerViewModel(): PlannerViewModel {
        return PlannerViewModel()
    }
}
