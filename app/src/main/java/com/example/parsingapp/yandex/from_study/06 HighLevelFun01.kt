package com.example.study_project.yandex


/**
 * combine имеет функциональный тип (R, T) -> R, поэтому он принимает функцию, которая принимает
 * два аргумента типа R и T и возвращает значение типа R.
 * Он вызывается внутри цикла for и присваивает accumulator возвращаемое значение.
 */
fun <T, R> Collection<T>.сборщик(
    яНачальныйЭлемент: R,
    combine: (acc: R, nextElement: T) -> R
): R {
    var яАккумулируюВСебяВсеЗначения: R = яНачальныйЭлемент
    for (element: T in this) {
        яАккумулируюВСебяВсеЗначения = combine(яАккумулируюВСебяВсеЗначения, element)
    }
    return яАккумулируюВСебяВсеЗначения
}

/* Чтобы вызвать сборщик, вы должны передать ему экземпляр функционального типа в качестве аргумента
и лямбда-выражение. Лямбда-выражения часто используются в качестве параметра функции высшего порядка.*/
fun main() {
    val items = listOf(1, 2, 3, 7, -2)

    // Лямбда - это блок кода, заключенный в фигурные скобки.
    /*  items.сборщик(7) { acc: Int, i: Int ->  // Если у лямбды есть параметры, то они указываются перед знаком '->'
          print("acc = $acc, i = $i, ")
          val result = acc + i
          println("result = $result")
          // Последнее выражение в лямбде считается возвращаемым значением:
          result
      }*/

    // Типы параметров в лямбде необязательны, если они могут быть выведены:
//    val joinedToString = items.сборщик("Elements:") { первыйПараметр, второйПараметр -> "$первыйПараметр $второйПараметр" }
//    println("joinedToString = $joinedToString")

    // Ссылки на функции также могут использоваться для вызовов функций высшего порядка:
//    val product = items.сборщик(4, Int::times)
//    println("product = $product")


    val productMy = items.сборщик(яНачальныйЭлемент = 4, combine = Int::myMultiple)
    println("productMyMultiply = $productMy")

}

fun Int.myMultiple(other: Int): Int {
    val myValue = this
    val res = myValue * other + 1
    println("res in extension = $res")
    return res
}

fun Double.myMultipleD(other: Double): Double {
    val myValue = this
    val res = myValue * other + 1
    println("res in extension = $res")
    return res
}