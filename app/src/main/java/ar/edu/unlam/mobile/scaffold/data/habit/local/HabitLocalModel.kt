package ar.edu.unlam.mobile.scaffold.data.habit.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.domain.habit.models.TypeCategory

// runtime (habit simple)
@Entity(tableName = "habit_table")
data class HabitLocalModel(

    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "name") val habitName: String,
    @ColumnInfo(name = "category") val category: TypeCategory,
    @TypeConverters(DataConverter::class) var days: List<Day>,
    @ColumnInfo(name = "hour") val hour: Long,
    @ColumnInfo(name = "state") val currentState: StateLocalModel,

) {
//    fun getDaysList(): List<Day> {
//        return days
//    }

    fun toHabitDomain(): Habit {
        val listDay = days.map {
            it.id
        }
        return Habit(
            id = id,
            name = habitName,
            category = category,
            days = listDay,
            hour = hour,
            state = currentState.id,
        )
    }

    fun toHabitDB(habit: Habit): HabitLocalModel {
        val listDay = habit.days.map {
            Day(it, Week.values()[it.toInt()])
        }
        val state = StateLocalModel(habit.state, StateRoutine.values()[habit.state.toInt()])
        return HabitLocalModel(
            id = habit.id,
            habitName = habit.name,
            category = habit.category,
            days = listDay,
            hour = habit.hour,
            currentState = state,
        )
    }
}

@Entity(tableName = "activity_table")
data class ActivityLocalModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "name") val activityName: String,
    @ColumnInfo(name = "category") val category: TypeCategory,
    @TypeConverters(DataConverter::class) var days: List<String>,
    @ColumnInfo(name = "goal") val goal: Int,
    // @ColumnInfo(name = "state") val currentState: String
) {
//    fun getDays(): List<String> {
//        return days
//    }
}

@Entity(tableName = "activityStart_tb")
data class ActivityStartLocalModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    // @TypeConverters(DataConverter::class)var date: Date,
    // @ColumnInfo(name = "activity") val activity: ActivityLocalModel,
)

@Entity(tableName = "activityEnd_tb")
data class ActivityEndLocalModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    // @TypeConverters(DataConverter::class) var date: Date,
    // @ColumnInfo(name = "activity") val activityStart: ActivityStartLocalModel,
    @ColumnInfo(name = "minutes") val minutes: Int,
)
