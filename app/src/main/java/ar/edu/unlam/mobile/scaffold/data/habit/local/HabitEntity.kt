package ar.edu.unlam.mobile.scaffold.data.habit.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ar.edu.unlam.mobile.scaffold.data.habit.local.converters.DataConverter
import ar.edu.unlam.mobile.scaffold.data.habit.local.models.Day
import ar.edu.unlam.mobile.scaffold.data.habit.local.models.StateLocalModel
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.domain.habit.models.TypeCategory

// runtime (habit simple)
@Entity(tableName = "habit_table")
data class HabitEntity(

    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "name") val habitName: String,
    @ColumnInfo(name = "category") val category: TypeCategory,
    @TypeConverters(DataConverter::class) var days: List<Day>,
    @ColumnInfo(name = "hour") val hour: Long,
    @ColumnInfo(name = "state") val currentState: StateLocalModel,
) {
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
}
