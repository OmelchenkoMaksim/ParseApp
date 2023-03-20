package com.example.parsingapp.yandex

data class DogMe
    constructor(val poroda: String = "Овчарка") {
    var name = "Рекс"
}

val setOfDog = hashSetOf(
    DogMe(poroda = "Дворняга").apply {
        this.name = "Вася"
//        println(this.hashCode())
    },
    DogMe().apply {
        name = "Коля"
//        println(this.hashCode())
    },
    DogMe("Дворняга").apply {
        name = "35235"
//        println(this.hashCode())
    },
    DogMe().apply {
        name = "Дима"
//        println(this.hashCode())
    }
)

fun main() {
println("----------------")
    setOfDog.forEach { dog ->
        println("${dog.name} ${dog.poroda}")
    }

}
