package ar.edu.unlam.mobile.scaffold.data.habit.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DayListConverter {
    @TypeConverter
    fun fromDayList(dayList: List<Day>): String {
        val gson = Gson()
        return gson.toJson(dayList)
    }

    @TypeConverter
    fun toDayList(dayListString: String): List<Day> {
        val gson = Gson()
        val listType =
            object : TypeToken<List<Day>>() {}.type
        return gson.fromJson(
            dayListString,
            listType
        )
    }
}
