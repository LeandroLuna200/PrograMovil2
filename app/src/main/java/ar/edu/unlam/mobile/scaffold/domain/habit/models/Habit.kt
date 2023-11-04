package ar.edu.unlam.mobile.scaffold.domain.habit.models

data class Habit(
    val name: String,
    val category: TypeCategory,
    val dailyGoal: Long,
)
