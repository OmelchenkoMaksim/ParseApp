package com.example.parsingapp.yandex

/*





import kotlin.random.Random

class Card(val numbers: Map<Int, MutableSet<Int>>)

class Person(val name: String) {

    val card: Card = createCard()

    private fun createCard(): Card {
        val numbers: Set<Int> = generateNumbers()

        val iterator: Iterator<Int> = numbers.iterator()
        var currentLine = 1

        val cardNumbers: MutableMap<Int, MutableSet<Int>> = mutableMapOf(
            1 to mutableSetOf(),
            2 to mutableSetOf(),
            3 to mutableSetOf()
        )

        while (iterator.hasNext()) {
            val number = iterator.next()
            cardNumbers[currentLine]?.add(number)

            if (currentLine < 3) {
                currentLine++
            } else {
                currentLine = 1
            }
        }

        return Card(cardNumbers)
    }

    private fun generateNumbers(): Set<Int> {
        val numbers: MutableSet<Int> = mutableSetOf()

        while (numbers.size < NUMBERS_COUNT) {
            numbers.add(Random.nextInt(MIN_NUMBER, MAX_NUMBER))
        }

        return numbers
    }

    private companion object {

        private const val NUMBERS_COUNT = 15
        private const val MAX_NUMBER = 100
        private const val MIN_NUMBER = 1
    }
}

class Lotto {
    // список добавленных игроков Person
    private val persons: MutableList<Person> = mutableListOf()

    // набор уже выброшенных чисел Int. Одно и то же число не должно выбрасываться дважды и храниться в наборе.
    val thrownNumbers: MutableSet<Int> = mutableSetOf()

    */
/**
    добавляет нового персонажа в игру.
     *//*

    fun addPerson(person: Person) {
        persons.add(person)
    }

    */
/**
    запускает игру. Игра проверяет, чтобы количество персонажей было больше одного.
    Если добавлено менее двух персонажей — выводить сообщение «Перед началом игры необходимо добавить хотя бы двух игроков».
    Если количество игроков больше одного, бросать случайное число из тех, которых ещё нет в наборе выброшенных чисел.
    Удалять этот элемент из карточек всех добавленных игроков. После каждого удаления проверять — есть ли победитель.
    Победителем считается игрок или игроки, у которых в одном из рядов не осталось ни одного числа.*//*

    fun start() {
        if (persons.size < 2) {
            println("Перед началом игры необходимо добавить хотя бы двух игроков")
        } else {
            do {
                val number = throwNumber()

                for (person in persons) {
                    // Set можно использовать для проверки того, выбрасывалось ли данное число ранее.
                    val cardNumbers = person.card.numbers
                    */
/* Чтобы проверить все элементы Map, можно использовать свойство keys,
                    которое возвращает список всех ключей в Map. После чего можно по каждому ключу достать его значения в цикле.*//*

                    for (key in cardNumbers.keys) {
                        cardNumbers[key]?.remove(number)
                    }
                }
            } while (!hasWinners())
        }
    }

    */
/*
    Для выбрасывания новых значений используйте метод Random.nextInt().
    Каждый раз, когда генерируется очередное число, необходимо выводить сообщение: "Выброшенное число: $number".*//*

    private fun throwNumber(): Int {
        val number = Random.nextInt(1, 100)
        */
/* Метод contains() у класса Set позволяет проверить, есть ли данный элемент в сете или нет.
        Это может быть полезно при проверке выброшенных значений.*//*

        return if (thrownNumbers.contains(number)) {
            throwNumber()
        } else {
            println("Выброшенное число: $number")
            thrownNumbers.add(number)
            number
        }
    }

    private fun hasWinners(): Boolean {
        // При проверке победителей можно создавать список тех, у кого один из рядов не имеет больше чисел.
        val winners: MutableList<Person> = mutableListOf()

        for (person in persons) {
            val cardNumbers = person.card.numbers
            for (key in cardNumbers.keys) {
                if (cardNumbers[key]?.isEmpty() == true) {
                    winners.add(person)
                }
            }
        }

        return if (winners.isEmpty()) {
            false
        } else {
            for (winner in winners) {
                println("Победитель: ${winner.name}!!!")
            }
            true
        }
    }
}
        */