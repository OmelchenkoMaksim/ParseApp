package com.example.parsingapp.yandex.third_webinar

// Оператор :: незаменим в ситуациях, когда требуется передать функцию как параметр, не вызывая ее.
object LinkToFun1 {
    fun isOdd(x: Int) = x % 2 != 0

    val numbers = listOf(1, 2, 3, 4)

    // Ссылка на функцию:
    // Этот оператор используется для создания ссылки на
    // функцию верхнего уровня или функцию-члена.
    fun printItOdd() {
        println(numbers.filter(::isOdd)) // Выводит "[1, 3]"
    }


    // Ссылка на функцию-члена:
// Оператор :: можно использовать для создания ссылки
// на функцию-члена. В этом случае он будет применяться к объекту перед вызовом функции.
    val stringFunc = String::length
    fun printItLength() {
        println(stringFunc("Hello, World!")) // Выводит "13"
    }

    //    Ссылка на свойство:
//    Оператор :: можно использовать для создания ссылки на свойство.
//    При вызове функции полученное значение будет использоваться как значение свойства.
    data class Person(val name: String, val age: Int)

    val ageProperty = Person::age
    val person = Person("Alice", 25)
    fun printItAge() {
        println(ageProperty(person)) // Выводит "25"
    }

}



