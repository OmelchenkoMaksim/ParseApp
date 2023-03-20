package com.example.parsingapp.yandex

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.system.measureTimeMillis

// 1
// зачем использовать дженерик? почему бы не использовать Any - потому что не надо кастить постоянно
// что за функция - синхронайзд
// лямбда что то вроде анонимного класса - если инлайн то мы не создаем лишние классы
@OptIn(ExperimentalContracts::class)
public inline fun <R> secretFunction(lock: Any, block: () -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    //  monitorEnter(lock)
    try {
        return block()
    } finally {
        //    monitorExit(lock)
    }
}

// 2
// починить эту функцию и сделать расширением для активити
//fun <T:java.io.Serializable?>getSerializable(name: String){
//    return intent.getSerializableExtra(name) as T
//}

// основной ответ
//inline fun <reified T:java.io.Serializable?> Activity.getSerializable(name: String):T{
//    return intent.getSerializableExtra(name) as T
//}


/* 3

sealed class SealedMe : java.io.Serializable{
    object ObjectMe1:SealedMe()
    object ObjectMe2:SealedMe()
}
// отработает ли блок when корректно после десерилизации?
when(SealedMe){
    is SealedMe.ObjectMe1->{}
    is SealedMe.ObjectMe2->{}
}

*/


/* 4
// что за чем вызывается и что будет если вызвать финиш на разных этапах
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onRestart() {
        super.onRestart()
        finish()
    }

    override fun onResume() {
        super.onResume()
        Log.e("my log", "i'm log")
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }
}
*/

/*
// 5 / сам плохо понял
// задача про последовательность
// если мы имеем коллекцию на миллион элементов и надо вызвать еще дополнительно
// кроме .filter вызвать .first или еще что
// по умолчанию работает как Iterable, но можно сделать .asSequence()
fun main() {
        val x = listOf(1, 2, 3).filter {
            print("$it ")
            it >= 2
        }
        println("before sum")
        println(x.sum())

}
*/

/*
6
производительноть Стринга и Билдера
замер скорости работы блока
fun main() {
    val time = measureTimeMillis {
//        val am: StringBuilder = StringBuilder()
        var am: String = ""
        for (i in 1 until 10000) {
            am = "$am ${i * (Math.random())}"
//            am.append( " ${i * (Math.random())}")
        }
        println("a is $am")
    }
    println("my time is: $time ms")
}
*/

/*
7 получение доступа к приват полям
class Victim {

    private val privateNumber = 42

    private val privateString = "I am The Private"

    fun printMe() {
        println("printMe $privateNumber and $privateString")
    }
}

fun main() {

    val victim = Victim()

    val privateField = Victim::class.java.getDeclaredField("privateNumber")

    println("------------------")
    victim.printMe()

    privateField.isAccessible = true
    println("the number is - ${privateField.get(victim)}")

    privateField.setInt(victim, 100)

    victim.printMe()

    val victimTheSecond = Victim()
    println("------------------")
    val privateString = victimTheSecond.javaClass.getDeclaredField("privateString")
    privateString.isAccessible = true
    victimTheSecond.printMe()
    privateString.set(victimTheSecond, "I was hacked!!!")
    println("---------------------")
    victimTheSecond.printMe()


}
*/













