package com.example.parsingapp.yandex

enum class Week(val number: Int) {
    MONDAY(number = 1),
    TUESDAY(number = 2),
    WEDNESDAY(number = 3),
    THURSDAY(number = 4),
    FRIDAY(number = 5),
    SATURDAY(number = 6),
    SUNDAY(number = 7)

    ;

    override fun toString(): String {
        return "${this.name} + ${this.number}"
    }
}

sealed class WeekMe(val number: Int) {
    class MONDAY : WeekMe(1)
    object TUESDAY : WeekMe(2) {
        val a = 10
        object Arary
    }

    class WEDNESDAY : WeekMe(3)
    class THURSDAY : WeekMe(4)
    class FRIDAY : WeekMe(5)
    class SATURDAY : WeekMe(6)
    class SUNDAY : WeekMe(7)
}