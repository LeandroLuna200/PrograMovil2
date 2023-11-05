package ar.edu.unlam.mobile.scaffold.data.habit.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

private const val DB_NAME = "habit_database"

@Database(entities = [(HabitLocalModel::class)], version = 1)
@TypeConverters(DataConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun locationDao(): HabitDao

    companion object {
        fun create(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DB_NAME,
            ).build()
        }
    }
}
