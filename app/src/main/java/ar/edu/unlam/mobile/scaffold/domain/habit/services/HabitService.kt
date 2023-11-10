package ar.edu.unlam.mobile.scaffold.domain.habit.services

import ar.edu.unlam.mobile.scaffold.data.habit.repository.HabitDefaultRepository
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.domain.mapper.HabitMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HabitService @Inject constructor(val repository: HabitDefaultRepository) :
    HabitGetter {

    override suspend fun insertHabit(habit: Habit) {
        this.repository.insertHabit(HabitMapper().toHabitDB(habit))
    }

    override suspend fun deleteHabitById(habitId: Long) {
        this.repository.deleteHabitById(habitId)
    }

    override suspend fun updateHabitState(habit: Habit) {
        this.repository.updateHabitState(habit)
    }

    override suspend fun getHabit(): Flow<List<Habit>> {
//        val dias = mutableListOf<String>("D", "L", "S")
//        val prueba = mutableListOf<Habit>(
//            Habit(1, "levantarme temprano", TypeCategory.SIMPLE, dias, 0),
//            Habit(2, "levantarme temprano", TypeCategory.SIMPLE, dias, 0),
//            Habit(9, "estudiar 2hrs", TypeCategory.DEDICATED, dias, 8),
//        )
//        val prueba2 = mutableListOf<HabitLocalModel>(
//            HabitLocalModel( "levantarme temprano", TypeCategory.SIMPLE, dias, 0),
//            HabitLocalModel( "levantarme temprano", TypeCategory.SIMPLE, dias, 0),
//            HabitLocalModel( "estudiar 2hrs", TypeCategory.DEDICATED, dias, 8),
//        )

//        val pruebaBDD = this.repository.getHabits().map { habitEntities ->
//            habitEntities.map { it.name }
//        }
//        val pruebaBDD = this.repository.getHabits().map { habitEntities ->
//            habitEntities.map { it.name }
//        }
//        Log.i(
//            "BASE DE DATOS",
//            pruebaBDD.map { it }.toString(),
//        )
//        this.repository.insertHabit(prueba[2].toHabitDB())
//        Log.i(
//            "BASE DE DATOS",
//            this.repository.getHabits().collect {
//                it[0].id
//            }.toString(),
//        )
//        return flow {
//            emit(
//                prueba.map { it },
//            )
//        }
        return this.repository.getHabits()
//        return emit(Habit(1,"levantarme temprano", TypeCategory.SIMPLE, dias, 0))
//        emit(Habit(2,"levantarme temprano", TypeCategory.SIMPLE, dias, 0))
//        emit(Habit(3, "estudiar 2hrs", TypeCategory.DEDICATED, dias, 8))
    }

//    override suspend fun insertActivity(activity: Activity){
////        this.repository.insertActivity(activity.toDomain())
//    }

//    override suspend fun deleteActivityById(id:Long){
////        this.repository.deleteActivityById(id)
//    }

//    override suspend fun getActivity(): Flow<List<Activity>> {
//                val dias = mutableListOf<String>("D", "L", "S")
//        val prueba = mutableListOf<Activity>(
//            Activity(1, "", TypeCategory.ACTIVITY, dias,2),
//            Activity(2, "levantarme temprano", TypeCategory.RUNTIME, dias, 0),
//            Activity(9, "estudiar 2hrs", TypeCategory.ACTIVITY, dias, 8),
//        )
//        val prueba2 = mutableListOf<ActivityLocalModel>(
//            ActivityLocalModel( 1,"levantarme temprano", TypeCategory.RUNTIME, dias, 0),
//            ActivityLocalModel( 2,"levantarme temprano", TypeCategory.RUNTIME, dias, 0),
//            ActivityLocalModel( 3,"estudiar 2hrs", TypeCategory.ACTIVITY, dias, 8),
//        )
//
//        val testBDD = this.repository.getHabits().map { habitEntities ->
//            habitEntities.map { it.name }
//        }
//        val pruebaBDD = this.repository.getHabits().map { habitEntities ->
//            habitEntities.map { it.name }
//        }
//        Log.i(
//            "BASE DE DATOS",
//            pruebaBDD.map { it }.toString(),
//        )
//        this.repository.insertActivity(prueba[2].toDomain())
//        Log.i(
//            "BASE DE DATOS",
//            this.repository.getHabits().collect {
//                it[0].id
//            }.toString(),
//        )
//        return flow {
//            emit(
//                prueba.map { it },
//            )
//        }
//        return this.repository.getActivities()
//    }
}
