package com.example.parsingapp.yandex.high

fun main() {
    LinkToFun2.printOursNumbers1()
    println("-------------")
    LinkToFun2.printOursNumbers2()
    println("-------------")
    LinkToFun2.printOursNumbers3()
    println("-------------")
    LinkToFun2.printOursNumbers4()

}

object LinkToFun2 {
//    Фильтрация коллекций: Задайте студентам несколько функций для
//    проверки различных свойств чисел (например, проверки на четность,
//    простоту, делительность на определенное число и т. д.).
//    Затем пусть они используют эти функции с функцией filter на списке чисел,
//    используя оператор :: для ссылки на функцию.

    fun isOdd(x: Int): Boolean {
        val result = x % 2 != 0
        return result
    }

    fun isEven(x: Int): Boolean {
        val result = x % 2 == 0
        return result
    }

    //    Функция isPrime проверяет, является ли переданное ей целое число простым.
//    Простые числа - это числа, которые имеют ровно два различных натуральных делителя:
//    единицу и само себя. Другими словами, простые числа - это числа, которые не могут быть
//    разделены без остатка ни на какое другое число, кроме 1 и самого себя.
    fun isPrime(x: Int): Boolean {
        if (x <= 1) return false
        for (i in 2 until x) {
            if (x % i == 0) return false
        }
        return true
    }


    val isOddVal: (Int) -> Boolean = { x ->
        val result = x % 2 != 0
//        return
        result
    }
    val isEvenVal: (Int) -> Boolean = { it % 2 == 0 }
    val isPrimeVal: (Int) -> Boolean = { x ->
        if (x <= 1) false
        else (2 until x).none { i -> x % i == 0 }
    }

    val numbers = listOf(1, 21, 32, 4, -5, 16, 7, -8, 9, 190)

    fun printOursNumbers1() {
        println("Odd numbers: ${numbers.filter { number -> isOdd(number) }}")
        println("Even numbers: ${numbers.filter { number -> isEven(number) }}")
        println("Prime numbers: ${numbers.filter { number -> isPrime(number) }}")
    }

    fun printOursNumbers2() {
        println(
            "Odd numbers: ${
                numbers.filter oddCheck@{ x ->
                    val result = x % 2 != 0
                    return@oddCheck result
                }
            }"
        )
        println(
            "Even numbers: ${
                numbers.filter evenCheck@{ x ->
                    val result = x % 2 == 0
                    return@evenCheck result
                }
            }"
        )
        println(
            "Prime numbers: ${
                numbers.filter primeCheck@{ x ->
                    if (x <= 1) return@primeCheck false
                    for (i in 2 until x) {
                        if (x % i == 0) return@primeCheck false
                    }
                    return@primeCheck true
                }
            }"
        )
    }

    fun printOursNumbers3() {
        println("Odd numbers: ${numbers.filter(::isOdd)}")
        println("Even numbers: ${numbers.filter(::isEven)}")
        println("Prime numbers: ${numbers.filter(::isPrime)}")
    }

    fun printOursNumbers4() {
        println("Odd numbers: ${numbers.filter(isOddVal)}")
        println("Even numbers: ${numbers.filter(isEvenVal)}")
        println("Prime numbers: ${numbers.filter(isPrimeVal)}")
    }
}
