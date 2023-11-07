package ar.edu.unlam.mobile.scaffold.domain.habit.models

import ar.edu.unlam.mobile.scaffold.data.habit.local.HabitLocalModel

sealed class Habito {
    abstract val id: Long
    abstract val name: String
    abstract val category: TypeCategory
}

data class Habit(
    override val id: Long,
    override val name: String,
    override val category: TypeCategory,
    val days: List<String>,
    val dailyGoal: Long,
) : Habito() {
    fun toHabitDB(): HabitLocalModel {
        return HabitLocalModel(
            id = 0,
            habitName = name,
            category = category,
            days = days,
            dailyGoal = dailyGoal,
        )
    }
}

data class Event(
    override val id: Long,
    override val name: String,
    override val category: TypeCategory,
    val date: String,
    val hour: Long,
) : Habito()
