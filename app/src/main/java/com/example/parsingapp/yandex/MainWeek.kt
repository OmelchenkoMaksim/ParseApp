package com.example.parsingapp.yandex

enum class ElementKotlin(val label: String, val number: Int) {
    H("Hydrogen", 3),
    HE("Helium", 2),
    NE("Neon", 10);
}

/*

Давайте решим довольно простую задачку. Реализуйте enum class “WeekUp”, который будет в себе хранить 7 дней недели
{MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}.
Класс должен иметь конструктор с полем localizedName: String,
в котором на русском будет описано название дня недели («Понедельник», «Вторник» и т. д.).
Класс WeekUp должен содержать метод isWeekUpend(): String, который будет в зависимости от дня
недели возвращать строку «будний» для дней с понедельника по пятницу и «выходной» для остальных дней.
После чего реализуйте метод main, в котором нужно вывести текст для каждого из
дней недели по порядку с понедельника до воскресенья: «[день] — [isWeekUpend()] день».

*/
enum class WeekUp(private val localizedName: String, number: Int) {
    MONDAY("ponedelnik", 1),
    TUESDAY("vtornik", 2),
    WEDNESDAY("sreda", 3),
    THURSDAY("chetverg", 4),
    FRIDAY("piatnitsa", 5),
    SATURDAY("subbota", 6),
    SUNDAY("voskresenie", 7)
    ;

    fun isWeekend() =
        when (this) {
            WeekUp.MONDAY -> "будний"
            WeekUp.TUESDAY -> "будний"
            WeekUp.WEDNESDAY -> "будний"
            WeekUp.THURSDAY -> "будний"
            WeekUp.FRIDAY -> "будний"
            WeekUp.SATURDAY -> "выходной"
            WeekUp.SUNDAY -> "выходной"
        }

    override fun toString() = localizedName
}

sealed class WeekUpMeUp(private val localizedName: String) {
    class MONDAY : WeekUpMeUp("monday") {
        val a = 10

    }

    class TUESDAY : WeekUpMeUp("")
    class WEDNESDAY : WeekUpMeUp("")
    class THURSDAY : WeekUpMeUp("")
    class FRIDAY : WeekUpMeUp("")
    class SATURDAY : WeekUpMeUp("")
    class SUNDAY : WeekUpMeUp("")

    override fun toString(): String {
        return localizedName
    }
}

fun main() {

    val arr: Array<Boolean> = Array(5) { index ->
        index % 2 == 0
    }
    println(arr.contentToString())

    println(WeekUp.FRIDAY.toString())
}
