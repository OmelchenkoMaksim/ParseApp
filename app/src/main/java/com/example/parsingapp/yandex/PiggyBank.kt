package com.example.parsingapp.yandex

object PiggyBank {

    private val listMoney = mutableListOf<Money>() // список монеток/купюр
    private var isSmashed: Boolean = false // свойство, определяющее, разбита ли копилка

    /**
     * putMoney(money: Money), с помощью этого метода можно положить новую монетку/купюру
     * в копилку и вывести сообщение «Добавлено в копилку $money». Если на момент
     * вызова метода копилка разбита, то нужно показать сообщение «Вы разбили копилку,
     * вы больше ничего положить туда не можете» и завершить выполнение метода.
     */
    fun putMoney(money: Money) =
        if (isSmashed) { // проверьте, не разбита ли копилка
            println("Вы разбили копилку, вы больше ничего положить туда не можете")
        } else {
            listMoney.add(money)
            println("Добавлено в копилку $money") // добавьте монетку в копилку
        }

    /**
     * shake(): Money? иногда копилку можно потрясти и оттуда точно выпадет монетка
     * (если есть, купюра выпасть не может). Выпавшая монетка должна быть удалена из копилки.
     * Если в копилке нет монеток, то вернуть null. Если на момент вызова метода копилка разбита,
     * то показать сообщение «Вы разбили копилку, больше оттуда ничего не вытрясти» и вернуть из метода null.
     */
    fun shake(): Money? {
        if (isSmashed) {  // проверьте, не разбита ли копилка
            println("Вы разбили копилку, больше оттуда ничего не вытрясти")
        } else listMoney.forEach {
            if (it.isCoin) {
                listMoney.remove(it) // вытрясти монетку из копилки (если в копилке нет монетки, вернуть null). Помните, купюры вытрясти нельзя.
                return it
            }
        }
        return null
    }

    /**
     * smash(): ArrayList<Money>  выводит сообщение «Копилка разбита, вы достали оттуда: $moneys».
     * Также устанавливает индикатор (флаг), что копилка разбита — true и возвращает список всех монет/купюр пользователю.
     */
    fun smash(): List<Money> {
        println("Копилка разбита, вы достали оттуда: $listMoney")
        isSmashed = true // установить флаг, что копилка разбита true, и вернуть все монетки, которые были в копилке
        return listMoney
    }
}

// создайте класс Money, который будет отражать сущность монетки/купюры с двумя полями: amount и isCoin
enum class Money(val amount: Float, val isCoin: Boolean) {

    // вы должны ограничить создание класса таким образом, чтобы можно было
    // создать только ограниченный набор номиналов (см. задание)
    // монетки номиналом: 10 копеек (0.1f), 50 копеек (0.5f) и 1 рубль (1f);
    coins_10(amount = 0.1f, isCoin = true),
    coins_50(amount = 0.5f, isCoin = true),
    coins_100(amount = 1.0f, isCoin = true),

    // купюры номиналом: 50, 100, 500 и 1000 рублей.
    bill_50(amount = 50.0f, isCoin = false),
    bill_100(amount = 100.0f, isCoin = false),
    bill_500(amount = 500.0f, isCoin = false),
    bill_1000(amount = 1000.0f, isCoin = false);

    // переопределите метод toString() так, чтобы он возвращал строку типа "10 коп." или "1 руб.",
    // если это монетка, и "100 руб.", если это купюра
    override fun toString(): String =
        if (isCoin && amount != 1.0f) {
            "${(amount * 100)} коп."
        } else {
            "${amount.toInt()} руб." // тут надо нули отсечь
        }
}


object PiggyBankStudent {

    private val listMoneyStudent = ArrayList<MoneyStudent>() // список монеток/купюр
    private var isSmash: Boolean = false // свойство, определяющее, разбита ли копилка

    /**
     * putMoney(money: Money), с помощью этого метода можно положить новую монетку/купюру
     * в копилку и вывести сообщение «Добавлено в копилку $money». Если на момент
     * вызова метода копилка разбита, то нужно показать сообщение «Вы разбили копилку,
     * вы больше ничего положить туда не можете» и завершить выполнение метода.
     */
    fun putMoney(moneyStudent: MoneyStudent) {
        if (!isSmash) { // проверьте, не разбита ли копилка
            listMoneyStudent.add(moneyStudent)
            println("Добавлено в копилку $moneyStudent") // добавьте монетку в копилку
        } else {
            println("Вы разбили копилку, вы больше ничего положить туда не можете")
            return
        }
    }

    /**
     * shake(): Money? иногда копилку можно потрясти и оттуда точно выпадет монетка
     * (если есть, купюра выпасть не может). Выпавшая монетка должна быть удалена из копилки.
     * Если в копилке нет монеток, то вернуть null. Если на момент вызова метода копилка разбита,
     * то показать сообщение «Вы разбили копилку, больше оттуда ничего не вытрясти» и вернуть из метода null.
     */
    fun shake(): MoneyStudent? {
        if (!isSmash) {  // проверьте, не разбита ли копилка
            return if (listMoneyStudent.find { it.isCoin } != null) {
                val iterator = listMoneyStudent.iterator()
                iterator.forEach {
                    if (it.isCoin) {
                        iterator.remove() // вытрясти монетку из копилки (если в копилке нет монетки, вернуть null). Помните, купюры вытрясти нельзя.
                        return it
                    }
                }
                null
            } else {
                null
            }
        } else {
            println("Вы разбили копилку, больше оттуда ничего не вытрясти")
            return null
        }
    }

    /**
     * smash(): ArrayList<Money>  выводит сообщение «Копилка разбита, вы достали оттуда: $moneys».
     * Также устанавливает индикатор (флаг), что копилка разбита — true и возвращает список всех монет/купюр пользователю.
     */
    fun smash(): ArrayList<MoneyStudent> {
        println("Копилка разбита, вы достали оттуда: $listMoneyStudent")
        isSmash = true // установить флаг, что копилка разбита true, и вернуть все монетки, которые были в копилке
        return listMoneyStudent
    }
}

// создайте класс Money, который будет отражать сущность монетки/купюры с двумя полями: amount и isCoin
class MoneyStudent private constructor(val amount: Float, val isCoin: Boolean) {

    // вы должны ограничить создание класса таким образом, чтобы можно было
    // создать только ограниченный набор номиналов (см. задание)
    companion object {
        // монетки номиналом: 10 копеек (0.1f), 50 копеек (0.5f) и 1 рубль (1f);
        val coins_10 = MoneyStudent(amount = 0.1f, true)
        val coins_50 = MoneyStudent(amount = 0.5f, true)
        val coins_100 = MoneyStudent(amount = 1.0f, true)

        // купюры номиналом: 50, 100, 500 и 1000 рублей.
        val bill_50 = MoneyStudent(amount = 50.0f, false)
        val bill_100 = MoneyStudent(amount = 100.0f, false)
        val bill_500 = MoneyStudent(amount = 500.0f, false)
        val bill_1000 = MoneyStudent(amount = 1000.0f, false)
    }

    // переопределите метод toString() так, чтобы он возвращал строку типа "10 коп." или "1 руб.",
    // если это монетка, и "100 руб.", если это купюра
    override fun toString(): String {
        return if (isCoin && amount != 1.0f) {
            "${(amount * 100).toInt()} коп."
        } else {
            "${amount.toInt()} руб."
        }
    }
}