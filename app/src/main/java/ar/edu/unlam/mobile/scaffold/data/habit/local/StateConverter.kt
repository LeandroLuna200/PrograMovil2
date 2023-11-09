package ar.edu.unlam.mobile.scaffold.data.habit.local

import androidx.room.TypeConverter
import com.google.gson.Gson

class StateConverter {
    @TypeConverter
    fun fromStateLocalModel(state: StateLocalModel): String {
        val gson = Gson()
        return gson.toJson(state)
    }

    @TypeConverter
    fun toStateLocalModel(stateJson: String): StateLocalModel {
        val gson = Gson()
        return gson.fromJson(stateJson, StateLocalModel::class.java)
    }
}