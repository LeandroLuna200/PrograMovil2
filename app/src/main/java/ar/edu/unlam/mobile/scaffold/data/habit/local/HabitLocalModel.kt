package ar.edu.unlam.mobile.scaffold.data.habit.local

import android.app.Activity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.domain.habit.models.TypeCategory
import java.util.Date

@Entity(tableName = "type_tb")
data class TypeLocalModel(
    @PrimaryKey(autoGenerate = true) val id: Long =0,
    @ColumnInfo(name = "name")val name: String,
)
@Entity(tableName = "day_tb")
data class DayLocalModel(
    @PrimaryKey(autoGenerate = true) val id: Long =0,
    @ColumnInfo(name = "initial")val name: Char, //L
    @ColumnInfo(name = "name") val description:String,//lunes
)
//runtime (habit simple)
@Entity(tableName = "habit_table")
data class HabitLocalModel(

    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "name") val habitName: String,
    @ColumnInfo(name = "category") val category: TypeCategory,
    @TypeConverters(DataConverter::class) var days: List<String>,
    @ColumnInfo(name = "dailyGoal") val dailyGoal: Long, //hora?

) {
    fun getDaysList(): List<String> {
        return days
    }

    fun toHabitDomain(): Habit {
        return Habit(
            id = id,
            name = habitName,
            category = category,
            days = days,
            dailyGoal = dailyGoal,
        )
    }
}

@Entity(tableName = "activity_table")
data class ActivityLocalModel(
    @PrimaryKey(autoGenerate = true)val id: Long = 0,
    @ColumnInfo(name = "name") val activityName:String,
    @TypeConverters(DataConverter::class) var days: List<DayLocalModel>,
    @ColumnInfo(name = "goal") val goal: Int,
)

@Entity(tableName = "activityStart_tb")
data class ActivityStartLocalModel(
    @PrimaryKey(autoGenerate = true)val id: Long = 0,
    @ColumnInfo(name = "date") val date: Date,
    @ColumnInfo(name = "activity") val activity: ActivityLocalModel,
)

@Entity(tableName = "activityEnd_tb")
data class ActivityEndLocalModel(
    @PrimaryKey(autoGenerate = true)val id: Long = 0,
    @ColumnInfo(name = "date") val date: Date,
    @ColumnInfo(name = "activity") val activityStart: ActivityStartLocalModel,
    @ColumnInfo(name = "minutes") val minutes: Int,
)