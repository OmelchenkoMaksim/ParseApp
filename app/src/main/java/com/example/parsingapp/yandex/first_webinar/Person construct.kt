package com.example.parsingapp.yandex.first_webinar

/*
Конструктор - это специальная функция, которая вызывается при создании нового объекта.
Ее задача - инициализировать новый экземпляр класса.
Kotlin предоставляет два типа конструкторов: первичные и вторичные.
Мы можем использовать их для разных сценариев инициализации.

Геттеры и Сеттеры: Следующим шагом было бы объяснение понятий геттеров и сеттеров.
Геттеры и сеттеры - это функции, которые позволяют нам контролировать доступ к свойствам объекта.
Геттер используется для получения значения свойства, а сеттер - для его установки.
Они позволяют нам добавить дополнительные проверки или логику обработки при чтении или записи свойств.

Практические примеры: Я бы предложил студентам примеры кода, которые бы показывали,
как использовать эти понятия в реальной ситуации. Это поможет им понять, как эти понятия применяются на практике.

Практика: Затем было бы полезно предложить студентам практические задания,
чтобы они могли применить свои новые знания. Например, задание может быть таким:
"Создайте класс Car с различными свойствами (например, make, model, year)
и добавьте конструкторы для различных сценариев. Затем добавьте геттеры и сеттеры
для каждого свойства с проверками или специфической логикой".

Обсуждение и разбор заданий: После выполнения заданий,
мы бы обсудили их, разобрали общие ошибки, и ответили на возникшие вопросы.
*/
/**
 * В этом примере мы создали класс Student на основе абстрактного класса Person и интерфейса Farewell.
 * Мы добавили несколько конструкторов, инициализацию свойств при создании экземпляра класса,
 * геттеры и сеттеры с проверкой условий для свойств name, age и grade.
 * Мы также определили private set для свойства faculty,
 * чтобы предотвратить изменение его значения извне класса.
 */
abstract class Person(open var name: String, open var age: Int) {
}

interface Farewell { // Прощание
    fun sayGoodbye()
}

class Student constructor(name: String, age: Int) : Person(name, age), Farewell {
    constructor() : this(name = "Unknown", age = 0)
    constructor(name: String) : this(name, age = 18)
    constructor(age: Int) : this(name = "Unknown", age)

    override var name: String = name
        get() = field.capitalize()
        set(value) {
            field = value.trim() // Удалим лишние пробелы, если они есть
        }

    override var age: Int = age
        get() = field
        set(value) {
            if (value < 0) {
                throw IllegalArgumentException("Age cannot be negative")
            }
            field = value
        }

    var faculty: String = "def faculty"
        get() = field
        private set(value) {
            field = value
        }

    var grade = 0
        get() = field
        set(value) {
            if (value < 1 || value > 5) {
                throw IllegalArgumentException("Grade must be between 1 and 5")
            }
            field = value
        }

    override fun sayGoodbye() =
        println("My name is $name, I am $age years old, studying at the $faculty faculty, and my grade is $grade")

}

fun main() {
    val student = Student()

    student.sayGoodbye()

    println("-------Updating student details---------")

    student.name = " John Doe "
    student.age = 20
    student.grade = 5

    student.sayGoodbye()
}
