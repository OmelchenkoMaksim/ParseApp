package com.example.parsingapp.yandex

fun main() {
    println( Week.MONDAY.toString())

    val whoAmI = null
    print(whoAmI)
}

enum class Week(val nameOfTheDay: String, val number: Int) {


    MONDAY("Понедельник", 1),
    TUESDAY("Вторник", 2),
    WEDNESDAY("Среда", 3),
    THURSDAY("Четверг", 4) ,
    FRIDAY("Пятница", 5),
    SATURDAY("Суббота", 6),
    SUNDAY("Воскресенье", 7)

    ;

    private val ima: String = "44"
    fun isWeekend() = when (this) {
        MONDAY -> "будний"
        TUESDAY -> "будний"
        WEDNESDAY -> "будний"
        THURSDAY -> "будний"
        FRIDAY -> "будний"
        SATURDAY -> "выходной"
        SUNDAY -> "выходной"
    }

    override fun toString(): String =
        "${this.name} / ${this.nameOfTheDay} $ima + ${THURSDAY.ima} ${this.number} + ord: ${this.ordinal} + ${isWeekend()}"

}

sealed class WeekMe(val number: Int) {
    object MONDAY : WeekMe(1)
    object TUESDAY : WeekMe(2) {
        val a = 10

        object Arary
    }

    object WEDNESDAY : WeekMe(3)
    object THURSDAY : WeekMe(4)
    object FRIDAY : WeekMe(5)
    object SATURDAY : WeekMe(6)
    object SUNDAY : WeekMe(7)
}