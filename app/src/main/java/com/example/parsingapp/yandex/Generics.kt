package com.example.parsingapp.yandex

sealed class MyAnimal<T>( age: Int = 1) : SimpleGenericsOne<T> {

    class MyCat(val name: String = "Max", val age: Int = 1, val isMine: Boolean = false) : MyAnimal<MyCat>() {

        override fun getOneFrom(list: Collection<MyCat>): MyCat {
            var maxAge = MyCat()
            list.forEach {
                if (maxAge.age < it.age) maxAge = it
            }
            return maxAge
        }
    }

    class MyDog(val name: String = "Rex", val age: Int = 1, val isMine: Boolean = false) : MyAnimal<MyDog>() {

        override fun getOneFrom(list: Collection<MyDog>): MyDog {
            var maxAge = MyDog()
            list.forEach {
                if (maxAge.age < it.age) maxAge = it
            }
            return maxAge
        }
    }

    class MyBird(val name: String = "Phillip", val age: Int = 1, val isMine: Boolean = false) : MyAnimal<MyBird>() {

        override fun getOneFrom(list: Collection<MyBird>): MyBird {
            var maxAge = MyBird()
            list.forEach {
                if (maxAge.age < it.age) maxAge = it
            }
            return maxAge
        }
    }

    class MyFish(val name: String = "Nemo", val age: Int = 1, val isMine: Boolean = false) : MyAnimal<MyFish>() {

        override fun getOneFrom(list: Collection<MyFish>): MyFish {
            var maxAge = MyFish()
            list.forEach {
                if (maxAge.age < it.age) maxAge = it
            }
            return maxAge
        }
    }
}
/*

fun <T> Collection<MyAnimal<T>>.getOne() {

    fun getOneFrom(list: Collection<MyAnimal<T>>): MyAnimal<T> {
        
        list.forEach {
            if (maxAge.age < it.age) maxAge = it
        }
        return maxAge
    }

}
*/

class MyPerson<T>(val id: T, val name: String)

interface SimpleGenericsOne<T> {

    fun collectToList(vararg param: T): Collection<T> = listOf(*param)

    fun getOneFrom(list: Collection<T>): T

}

fun main() {
    val myList = listOf<MyAnimal<*>>(
        MyAnimal.MyFish(age = 7),
        MyAnimal.MyBird(age = 17),
        MyAnimal.MyBird(age = 6),
        MyAnimal.MyBird(age = 9),
        MyAnimal.MyDog(age = 11),
        MyAnimal.MyCat(age = 3),
        MyAnimal.MyCat(age = 6),
        MyAnimal.MyCat(age = 7),
        MyAnimal.MyCat(age = 8),
        MyAnimal.MyCat(age = 19),
    )


}