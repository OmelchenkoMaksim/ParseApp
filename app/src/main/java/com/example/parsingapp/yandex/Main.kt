package com.example.parsingapp.yandex

enum class ElementKotlin(val label: String, val number: Int) {
    H("Hydrogen", 3),
    HE("Helium", 2),
    NE("Neon", 10);
}

/*

Давайте решим довольно простую задачку. Реализуйте enum class “Week”, который будет в себе хранить 7 дней недели
{MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}.
Класс должен иметь конструктор с полем localizedName: String,
в котором на русском будет описано название дня недели («Понедельник», «Вторник» и т. д.).
Класс Week должен содержать метод isWeekend(): String, который будет в зависимости от дня
недели возвращать строку «будний» для дней с понедельника по пятницу и «выходной» для остальных дней.
После чего реализуйте метод main, в котором нужно вывести текст для каждого из
дней недели по порядку с понедельника до воскресенья: «[день] — [isWeekend()] день».

*/
enum class Week(private val localizedName: String, number: Int) {
    MONDAY("ponedelnik", 1),
    TUESDAY("vtornik", 2),
    WEDNESDAY("sreda", 3),
    THURSDAY("chetverg", 4),
    FRIDAY("piatnitsa", 5),
    SATURDAY("subbota", 6),
    SUNDAY("voskresenie", 7);

    override fun toString() = localizedName
}

sealed class WeekMe(private val localizedName: String) {
    class MONDAY : WeekMe("monday") {
        val a = 10

    }

    class TUESDAY : WeekMe("")
    class WEDNESDAY : WeekMe("")
    class THURSDAY : WeekMe("")
    class FRIDAY : WeekMe("")
    class SATURDAY : WeekMe("")
    class SUNDAY : WeekMe("")

    override fun toString(): String {
        return localizedName
    }
}

fun main() {

    val arr: Array<Boolean> = Array(5) { index ->
        index % 2 == 0
    }
    println(arr.contentToString())
}
