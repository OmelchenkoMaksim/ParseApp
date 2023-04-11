package com.example.parsingapp.yandex

fun main() {
    val array = intArrayOf(5, 2, 3, -4, -8, 99, 35, 7, 3, 5, 3, 13)
    println(array.contentToString())
    array.bubbleSortShort()
    println(array.contentToString())

}

fun IntArray.bubbleSortShort() {

    var needToSort = true

    while (needToSort) {
        needToSort = false

        for (i in 1 until this.size) {
            val previous = this[i - 1]
            val current = this[i]
            if (previous > current) {
                this[i - 1] = current
                this[i] = previous
                needToSort = true
            }
        }
    }
}