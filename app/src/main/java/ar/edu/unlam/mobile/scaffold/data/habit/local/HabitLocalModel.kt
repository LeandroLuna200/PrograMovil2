package ar.edu.unlam.mobile.scaffold.data.habit.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.domain.habit.models.TypeCategory

@Entity(tableName = "habit_table")
data class HabitLocalModel(

    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "name") val habitName: String,
    @ColumnInfo(name = "category") val category: TypeCategory,
    @TypeConverters(DataConverter::class) var days: List<String>,
    @ColumnInfo(name = "dailyGoal") val dailyGoal: Long,

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
