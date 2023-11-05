package ar.edu.unlam.mobile.scaffold.data.habit.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.Type

class DataConverter : Serializable {
    @TypeConverter // note this annotation
    fun fromDaysValuesList(daysValues: List<String?>?): String? {
        if (daysValues == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<String?>?>() {}.type
        return gson.toJson(daysValues, type)
    }

    @TypeConverter // note this annotation
    fun toDaysValuesStringList(daysValuesString: String?): List<String>? {
        if (daysValuesString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson<List<String>>(daysValuesString, type)
    }
}
