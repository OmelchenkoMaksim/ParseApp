package com.example.parsingapp.yandex

import java.util.Scanner


var scanner = Scanner(System.`in`)

fun main() {

    var inputNum = -1
    var nextScan = scanner.nextLine()

    try {
        inputNum = nextScan.toInt()
    } catch (e: Exception) {
        nextScan = e.message
    }

    when (inputNum) {
        -1 -> {
            println("$inputNum + $nextScan")
        }
        0 -> {
            println("$inputNum + $nextScan")
        }
        1 -> {
            println("$inputNum + $nextScan")
        }
        2 -> {
            println("$inputNum + $nextScan")
        }
    }

}