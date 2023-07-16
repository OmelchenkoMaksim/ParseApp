package com.example.parsingapp.yandex.third_webinar

fun main() {

    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenNumbers = numbers.customFilter { it % 2 == 0 }
    println(evenNumbers) // Выводит: [2, 4, 6, 8, 10]

    println("-------------")

    val words = listOf("apple", "banana", "cherry", "date", "elderberry")
    val longWords = words.customFilter { it.length > 5 }
    println(longWords) // Выводит: ["banana", "cherry", "elderberry"]


    println("-------------")

    val people = listOf(
        Person("Alice", 30),
        Person("Bob", 25),
        Person("Charlie", 35),
        Person("Dave", 40)
    )

    val adults = people.customFilter { it.age >= 30 }
    println(adults) // Выводит: [Person(name=Alice, age=30), Person(name=Charlie, age=35), Person(name=Dave, age=40)]



}


fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (item in this) {
        if (predicate(item)) {
            result.add(item)
        }
    }
    return result
}

val numbers = listOf(1, 2, 3, 4, 5, 6)


data class Person(val name: String, val age: Int)
