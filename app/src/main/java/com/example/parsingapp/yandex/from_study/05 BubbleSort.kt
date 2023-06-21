package com.example.study_project.yandex

// самая простая методика сортировки - пузырьком, в виде функции расширения
fun main() {
    val array = intArrayOf(5, 2, -3, 7, 8, 2, -1, -9, 11, -9, 0, 1, -1, 13, 15, -6, 4)
    println(array.contentToString())
    array.bubbleSort()
    println("---------------------")
    println(array.contentToString())
}

private fun IntArray.bubbleSort() {

    var needToSort = true

    while (needToSort) {
        needToSort = false
        for (i in 1 until size) {
            val previous = this[i - 1]
            val current = this[i]

            if (previous > current) {
                this.changeIt(
                    indexPrevious = i - 1,
                    indexCurrent = i
                )
                needToSort = true
            }
        }
    }
}

private fun IntArray.changeIt(indexPrevious: Int, indexCurrent: Int) {
    val cache = this[indexPrevious]
    this[indexPrevious] = this[indexCurrent]
    this[indexCurrent] = cache
}
