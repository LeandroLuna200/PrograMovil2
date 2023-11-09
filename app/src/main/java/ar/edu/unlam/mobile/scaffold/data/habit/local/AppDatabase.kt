package ar.edu.unlam.mobile.scaffold.data.habit.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

private const val DB_NAME = "habit_database"

@Database(
    entities = [
        (HabitLocalModel::class),
//        (ActivityLocalModel::class),
//        (ActivityStartLocalModel::class),
//        (ActivityEndLocalModel::class),
    ],
    version = 2
)
@TypeConverters(DataConverter::class, DayListConverter::class, StateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun locationDao(): HabitDao

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
