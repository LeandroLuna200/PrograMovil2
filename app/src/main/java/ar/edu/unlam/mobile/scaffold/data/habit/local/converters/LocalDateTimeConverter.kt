package ar.edu.unlam.mobile.scaffold.data.habit.local.converters

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.ZoneOffset

class LocalDateTimeConverter {

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toLong(dateTime: LocalDateTime?): Long? {
        return dateTime?.toEpochSecond(ZoneOffset.UTC)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toLocalDateTime(timestamp: Long?): LocalDateTime? {
        return timestamp?.let { LocalDateTime.ofEpochSecond(it, 0, ZoneOffset.UTC) }
    }
}
