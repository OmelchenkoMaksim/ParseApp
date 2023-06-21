package com.example.study_project.yandex

// задачка на понимание работы дата классов
data class DogPerson(
    val poroda: String = "Дворняга",
) {
    var name: String = "Шарик"
}


val dogSet = hashSetOf(
    DogPerson(),
    DogPerson().apply {
        name = "Валера"
    },
    DogPerson().apply {
        name = "Валера"
    },
    DogPerson().apply {
        name = "Rex"
    },
    DogPerson(poroda = "Овчарка").apply {
        name = "Молли"
    }

)


fun main() {

    println(dogSet.size)
    dogSet.forEach {
        println(it.name)
    }
}