package ar.edu.unlam.mobile.scaffold.data.habit.local.converters

import androidx.room.TypeConverter
import ar.edu.unlam.mobile.scaffold.data.habit.local.models.StateLocalModel
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
