package com.example.parsingapp.yandex

abstract class Doc(
    val title: String,
    val author: String,
    var words: Long = 0L,
) {
    abstract fun summary(): String
}

interface MyFunInt {
    fun returnInt(): Int
}

fun main() {

    val article = object : Doc(title = "A nice article", author = "Kai", words = 420) {
        override fun summary() = "Title: <$title> ($words words) By $author"
    }

    val intReturner = object : MyFunInt {
        override fun returnInt(): Int = 10
    }

    println(article.javaClass)
    println(intReturner.javaClass)
}