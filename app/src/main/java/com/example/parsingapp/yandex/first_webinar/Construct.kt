package com.example.parsingapp.yandex.first_webinar


abstract class People(open var name: String, open var age: Int) {
}

interface Greetings {
    fun sayHello()
}

class Engineer constructor(name: String, age: Int) : People(name, age), Greetings {

    constructor() : this(name = "empty01", age = 33)
    constructor(name: String) : this(name, age = 11)
    constructor(age: Int) : this(name = "empty02", age)

    override var name: String = name
        get() = field
        set(value) {
            // Здесь можно добавить проверки или преобразования значения
            field = value
        }

    override var age: Int = age
        get() = field
        set(value) {
            // Здесь можно добавить проверки или преобразования значения
            field = value
        }

    var job: String = "def job"
        get() = this.javaClass.simpleName
        private set(value) {
            // Закрытый сеттер, чтобы предотвратить изменение значения снаружи класса
            field = value
        }

    var salary = 1000
        get() = field
        set(value) {
            // Здесь можно добавить проверки или преобразования значения
            field = value
        }

    var dogName = "def dogName"
        get() {
            return field + "YES !!!"
        }
        set(value) {
            println("old = $field new = $value")
            field = value
        }

    init {
        job = this.javaClass.simpleName
    }

    override fun sayHello() =
        println("I am $name, $age years old \nwork as $job and earn $salary my dog name is $dogName")


}

fun main() {
    val person = Engineer()

    person.sayHello()
    println(person.dogName)
    println("---------------------")

    person.dogName = "Valera"
}
