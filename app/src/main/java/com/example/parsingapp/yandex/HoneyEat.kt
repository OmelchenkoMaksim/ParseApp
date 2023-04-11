package com.example.parsingapp.yandex

fun main2() {


    val muta = mutableMapOf<String, () -> Unit>()
    muta["My name"] = { println("Макс") }
    muta["My surname"] = { println("Корж") }

    muta["My name"]?.invoke()
    muta["My surname"]
    muta["My name"]?.invoke()
    muta["My name"]

    val muta2 = mutableMapOf<Char, () -> Int>()

    muta2['a'] = {
        'a'.code
    }
    muta2['b'] = {
        'b'.code
    }
    muta2['c'] = {
        println("${'c'.code} Im c code")
        0
    }
    println(muta2['a']?.invoke())
    muta2['c']?.invoke()
    println(muta2['b'])
    muta2['c']
    muta2['c']
    muta2['c']
    muta2['c']

}

data class HoneyBear(
    val name: String,
    val size: Int,
    val color: String,
)

fun interface CanEat {
    fun eat(honeyBear: HoneyBear)
}

fun main() {
    val (name, size, color) = HoneyBear("Задира", 5, "Чёрный")
    val canEatLambda = CanEat { (name, size, color) ->
        println("Медоед $name имеет размер $size и цвет $color")
    }

    println("Медоед $name имеет размер $size и цвет $color")
    canEatLambda.eat(HoneyBear("Злюка", 12, "Рыжий"))
    println("Медоед $name имеет размер $size и цвет $color")
}