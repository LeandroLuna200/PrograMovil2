package ar.edu.unlam.mobile.scaffold.domain.habit.models

import java.time.LocalDateTime

sealed class Habito {
    abstract val id: Long
    abstract val name: String
    abstract val category: TypeCategory
}

data class Habit(
    override val id: Long,
    override val name: String,
    override val category: TypeCategory,
    val days: List<Long>,
    val hour: Long,
    var state: Long,
) : Habito()

data class Activity(
    override val id: Long,
    override val name: String,
    override val category: TypeCategory,
    val days: List<Long>,
    val dailyGoal: Int,
    val state: Long,
) : Habito()

data class ActivityStart(
    val id: Long,
    val date: LocalDateTime,
    val activityId: Long,
)

data class ActivityEnd(
    val id: Long,
    val date: LocalDateTime,
    val startId: Long,
    val minutes: Int
)
