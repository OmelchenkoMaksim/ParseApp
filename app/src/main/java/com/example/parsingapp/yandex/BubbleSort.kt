package com.example.parsingapp.yandex


fun main() {
    val array = intArrayOf(5, 2, 4, 6, 7, -4, -9, 22, 11, 0, -8)
    println(array.contentToString())
    array.bubbleSort()
    println("------------------")
    println(array.contentToString())
}

fun IntArray.bubbleSort() {
    var needToSort = true // флаг, говорящий надо ли сортировать массив
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

fun IntArray.changeIt(indexPrevious: Int, indexCurrent: Int) {
    val cache = this[indexPrevious]
    this[indexPrevious] = this[indexCurrent]
    this[indexCurrent] = cache
}

/*


// Для начала инициализируем исходный массив целых чисел с помощью метода intArrayOf().
// Преобразование массива в список делаем исключительно для того, чтобы метод println() корректно отобразил содержимое массива.
fun main() {
    val array = intArrayOf(5, 2, 6, -7, 7, 9, 6, 4, 11, 0, 1, 8, 4)
    println(array.toList())
    array.bubbleSort()
    println(array.toList())
}

// Сам метод bubbleSort() сделаем как метод расширения класса IntArray:
fun IntArray.bubbleSort() {
*/
/*
Заводим специальный флажок needToSort, который является признаком того, что сортировка не проходила.
Затем запускаем цикл while, который на каждой итерации будет проверять состояние этого флажка.
То есть цикл выполняется до тех пор, пока массив полностью не отсортирован. и needToSort = станет фолс *//*

    var needToSort = true
    while (needToSort) {
        */
/*
        Перед началом вложенного цикла устанавливаем наш флаг в значение true.
        Затем проходимся по всем элементам, начиная со второго и до конца.
        На каждой итерации вложенного цикла берём текущий и предыдущий элемент и сравниваем их между собой.
        Если предыдущий больше текущего, то меняем их местами с помощью вспомогательного метода swap().
        После обмена устанавливаем флаг sorted в false, чтобы внешний цикл затем пошёл ещё на одну итерацию.*//*

        needToSort = false
        // массивы и списки начинаются с нуля (но мы берем от 1, а дальше сделаем)
        for (i in 1 until this.size) {
            val previous = this[i - 1]
            val current = this[i]
            if (previous > current) {
                this.swap(i - 1, i)
                needToSort = true
            }
        }
    }
}

// Реализация вспомогательного метода swap() довольно проста. Он также выполнен как метод расширения класса IntArray:
fun IntArray.swap(index1: Int, index2: Int) {
    val buffer = this[index1]
    this[index1] = this[index2]
    this[index2] = buffer
    val min = this[index1]
    min
    val max = this[index2]
    max
}

sealed class Anc{
    open class AB:Anc()
}



*/
