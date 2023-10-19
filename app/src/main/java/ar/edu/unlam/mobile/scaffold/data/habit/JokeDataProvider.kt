package ar.edu.unlam.mobile.scaffold.data.habit

import ar.edu.unlam.mobile.scaffold.data.habit.network.ChuckNorrisAPI
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JokeDataProvider {
    private fun provideChuckNorrisAPI() : ChuckNorrisAPI  {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create( Gson() ))
            .baseUrl("https://api.chucknorris.io/")
            .build()
        return retrofit.create(ChuckNorrisAPI::class.java)

        }
    }