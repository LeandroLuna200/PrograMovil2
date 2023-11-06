package ar.edu.unlam.mobile.scaffold.domain.habit.models

sealed class Habito {
    abstract val name: String
    abstract val category: TypeCategory
}

data class Habit(
    override val name: String,
    override val category: TypeCategory,
    val days: List<String>,
    val dailyGoal: Long,
) : Habito()

data class Event(
    override val name: String,
    override val category: TypeCategory,
    val date: String,
    val hour: Long,
) : Habito()
