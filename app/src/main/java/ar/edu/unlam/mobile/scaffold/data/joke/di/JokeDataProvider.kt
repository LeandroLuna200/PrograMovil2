package ar.edu.unlam.mobile.scaffold.data.joke.di

import ar.edu.unlam.mobile.scaffold.data.joke.network.ChuckNorrisAPI
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object JokeDataProvider {
    @Provides
    @Singleton
    fun provideChuckNorrisAPI(gson: Gson): ChuckNorrisAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.chucknorris.io")
            .build()
            .create(ChuckNorrisAPI::class.java)
    }
}
