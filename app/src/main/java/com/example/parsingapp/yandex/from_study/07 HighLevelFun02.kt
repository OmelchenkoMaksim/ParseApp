package com.example.study_project.yandex


fun main() {
    val action1 = selectAction()
//    println(action1(8, 5))

    val action2 = selectAction()
//    println(action2(8, 5))

    val action3 = selectAction()
//    println(action3(8, 5))
}

fun selectAction(){

}

fun empty(a: Int = 0, b: Int = 0): Int {
    return 0
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun subtract(a: Int, b: Int): Int {
    return a - b
}

fun multiply(a: Int, b: Int): Int {
    return a * b
}

fun multiply2(a: Int): Int {
    return a * a
}

/*

interface Action {
    fun invoke(a: Int = 0, b: Int = 0): Int
}

fun main() {
    val action1 = selectAction(1)
    println(action1.invoke(8, 5))

    val action2 = selectAction(2)
    println(action2.invoke(8, 5))

    val action3 = selectAction(3)
    println(action3.invoke(8))

    val action4 = selectAction(4)
    println(action4.invoke())
}

fun selectAction(key: Int): Action =
    when (key) {
        1 -> object: Action { override fun invoke(a: Int, b: Int): Int = a + b }
        2 -> object: Action { override fun invoke(a: Int, b: Int): Int = a - b }
        3 -> object: Action { override fun invoke(a: Int, b: Int): Int = a * a } // Использует только первый аргумент
        else -> object: Action { override fun invoke(a: Int, b: Int): Int = 0 } // Игнорирует все аргументы
    }

*/

