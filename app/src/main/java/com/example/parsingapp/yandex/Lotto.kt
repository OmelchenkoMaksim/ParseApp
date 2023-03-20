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









*/












/*




import kotlin.random.Random

class Lotto {

    // определите поле, в котром будут храниться добавленные игроки `Person`
    val gamers = mutableListOf<Person>()

    // поле thrownNumbers должно хранить в себе набор выброшенных чисел.
//    val thrownNumbers:  // определите подходящую структуру данных

    // addPerson() — добавляет нового персонажа в игру.

    fun addPerson(person: Person) {
        // добавить игрока в список игроков
    }

    */
/*
    start() — запускает игру. Игра проверяет, чтобы количество персонажей было больше одного.
    Если добавлено менее двух персонажей — выводить сообщение «Перед началом игры необходимо добавить хотя бы двух игроков».
    Если количество игроков больше одного, бросать случайное число из тех, которых ещё нет в наборе выброшенных чисел.
    Удалять этот элемент из карточек всех добавленных игроков. После каждого удаления проверять — есть ли победитель.
    Победителем считается игрок или игроки, у которых в одном из рядов не осталось ни одного числа.*//*

    fun start() {
        // вывести сообщение "Перед началом игры необходимо добавить хотя бы двух игроков" и завершить работу, если количество добавленных игроков меньше 2
        println("Перед началом игры необходимо добавить хотя бы двух игроков")
        if (gamers.size < 2) {
            return
        }
        // достать номер. Номер может быть в диапазоне от 1 до 99 включительно
        val currentNumber = Random.nextInt(1, 99)

        // после каждого выброшенного числа удалять это число из карточек всех игроков, если такое число имеется
        gamers.forEach {
            if (it.card.numbers.containsKey(currentNumber)){
                it.card.numbers
            }
        }
        // выбрасывать новые числа до тех пор, пока не определится победитель
        // побеждает тот, у кого в одном из рядов нет больше чисел. Победителей может быть более одного
        // после того как появляется победитель, для каждого победителя вывести текст "Победитель: [имя_победителя]!!!"
    }

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
}
*/
/*
Давайте теперь реализуем класс Lotto,
который будет доставать случайные числа и определять победителя.
В классе Lotto должно быть 2 поля:
список добавленных игроков Person,
набор уже выброшенных чисел Int.
Одно и то же число не должно выбрасываться дважды и храниться в наборе.
Класс Lotto должен содержать 2 метода:
addPerson() — добавляет нового персонажа в игру.
start() — запускает игру. Игра проверяет, чтобы количество персонажей было больше одного.
Если добавлено менее двух персонажей — выводить сообщение «Перед началом игры необходимо добавить хотя бы двух игроков».
Если количество игроков больше одного, бросать случайное число из тех,
которых ещё нет в наборе выброшенных чисел. Удалять этот элемент из карточек
всех добавленных игроков. После каждого удаления проверять — есть ли победитель.
Победителем считается игрок или игроки, у которых в одном из рядов не осталось ни одного числа.
Для выбрасывания новых значений используйте метод Random.nextInt().
*//*



*/
