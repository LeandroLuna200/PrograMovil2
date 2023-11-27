package ar.edu.unlam.mobile.scaffold.data.habit.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ar.edu.unlam.mobile.scaffold.data.habit.local.converters.DataConverter
import ar.edu.unlam.mobile.scaffold.data.habit.local.models.Day
import ar.edu.unlam.mobile.scaffold.data.habit.local.models.StateLocalModel
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Activity
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityEnd
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityStart
import ar.edu.unlam.mobile.scaffold.domain.habit.models.TypeCategory
import java.time.LocalDateTime

@Entity(tableName = "activity_table")
data class ActivityEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "name") val activityName: String,
    @ColumnInfo(name = "category") val category: TypeCategory,
    @TypeConverters(DataConverter::class) var days: List<Day>,
    @ColumnInfo(name = "goal") val goal: String,
    @ColumnInfo(name = "state") val currentState: StateLocalModel,
) {
    fun toActivityDomain(): Activity {
        val listDay = days.map {
            it.id
        }
        return Activity(
            id = id,
            name = activityName,
            category = category,
            days = listDay,
            dailyGoal = goal,
            state = currentState.id,
        )
    }
}

@Entity(
    tableName = "activityStart_tb",
    foreignKeys = [
        ForeignKey(
            entity = ActivityEntity::class,
            parentColumns = ["id"],
            childColumns = ["activityId"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
)
data class ActivityStartEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @TypeConverters(DataConverter::class) var date: LocalDateTime,
    @ColumnInfo(name = "activityId", index = true) val activityId: Long,
) {
    fun toActivityStartDomain(): ActivityStart {
        return ActivityStart(
            id,
            date,
            activityId,
        )
    }
}

@Entity(
    tableName = "activityEnd_tb",
    foreignKeys = [
        ForeignKey(
            entity = ActivityStartEntity::class,
            parentColumns = ["id"],
            childColumns = ["startId"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
)
data class ActivityEndEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @TypeConverters(DataConverter::class) var date: LocalDateTime,
    @ColumnInfo(name = "startId", index = true) val startId: Long,
    @ColumnInfo(name = "minutes") val minutes: LocalDateTime,
) {
    fun toActivityEndDomain(): ActivityEnd {
        return ActivityEnd(id, date, startId, minutes)
    }
}
