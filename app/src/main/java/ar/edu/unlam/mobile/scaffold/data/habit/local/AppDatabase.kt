package ar.edu.unlam.mobile.scaffold.data.habit.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ar.edu.unlam.mobile.scaffold.data.habit.local.converters.DataConverter
import ar.edu.unlam.mobile.scaffold.data.habit.local.converters.DayListConverter
import ar.edu.unlam.mobile.scaffold.data.habit.local.converters.LocalDateTimeConverter
import ar.edu.unlam.mobile.scaffold.data.habit.local.converters.StateConverter

private const val DB_NAME = "habit_database"

@Database(
    entities = [
        (HabitEntity::class),
        (ActivityEntity::class),
        (ActivityStartEntity::class),
        (ActivityEndEntity::class),
    ],
    version = 3,
)
@TypeConverters(
    DataConverter::class,
    DayListConverter::class,
    StateConverter::class,
    LocalDateTimeConverter::class,
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun habitDao(): HabitDao
    abstract fun activityDao(): ActivityDao

    companion object {
        fun create(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DB_NAME,
            ).addMigrations().build()
        }
    }
}
