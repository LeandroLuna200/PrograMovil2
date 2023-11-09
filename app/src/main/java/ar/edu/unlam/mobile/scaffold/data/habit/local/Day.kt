package ar.edu.unlam.mobile.scaffold.data.habit.local

data class Day(
    val id: Long = 0,
    val name: Week,//lunes
     )

enum class Week{
    DOMINGO,
    LUNES,
    MARTES,
    MIERCOLES,
    JUEVES,
    VIERNES,
    SABADO,
}



