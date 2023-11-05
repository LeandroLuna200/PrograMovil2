package ar.edu.unlam.mobile.scaffold.data.habit.di

import android.content.Context
import ar.edu.unlam.mobile.scaffold.data.habit.local.AppDatabase
import ar.edu.unlam.mobile.scaffold.data.habit.local.HabitDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.create(context)

    @Provides
    fun provideDao(database: AppDatabase): HabitDao {
        return database.locationDao()
    }
}
