package com.example.parsingapp.yandex

import java.util.*

data class DogPerson(val poroda: String = "Овчарка") {
    var name: String = "Рекс"
}

val set = hashSetOf(
    DogPerson().apply { name = "Вася" },
    DogPerson(poroda = "Дворняга"),
    DogPerson().apply { name = "Коля" }
)

fun main() {

    ArrayList<String>()
    listOf<String>()

    linkedSetOf<String>()

    LinkedList<String>()
    HashSet<String>()

    println(set)
    println("--------")

    set.forEach {
        println("${it.name} ${it.poroda}")
    }
}

