package com.example.study_project.yandex

// чудеса рефлексии
class Victim {

    private val privateNumber = 42

    private val privateString = "I am The Private"

    fun printMe() {
        println("printMe $privateNumber and $privateString")
    }
}

fun main() {

    val victim = Victim()

    val privateField = Victim::class.java.getDeclaredField("privateNumber")

    println("----------------------")
    victim.printMe()

    privateField.isAccessible = true

    println("The number is ${privateField.get(victim)}")

    privateField.setInt(victim, 100)

    victim.printMe()

    val victimTwo = Victim()
    println("----------------")
    victimTwo.printMe()

    val privateString = victimTwo.javaClass.getDeclaredField("privateString")
    privateString.isAccessible = true

    privateString.set(victimTwo, "I was hacked")

    victimTwo.printMe()

}