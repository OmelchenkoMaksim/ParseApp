package com.example.parsingapp.yandex.first_webinar

/**
 * В этом примере, UiEvent - это sealed class, который может быть одним из
 * четырёх подклассов: Click, Swipe, LongPress, и DoubleClick.
 * Это очень полезно для обработки различных типов событий пользовательского
 * интерфейса в вашем коде. Благодаря использованию sealed class, мы можем
 * быть уверены, что обработали все возможные типы событий пользовательского интерфейса.
 */
sealed class UiEvent {
    open class Click(open var position: Int) : UiEvent()
    data class Swipe(val direction: String) : UiEvent()
    object LongPress : UiEvent()
    object DoubleClick : UiEvent()
}

/*
Объекты, объявленные с помощью object или companion object, являются синглтонами в Kotlin.
Это означает, что они создаются при первом обращении к ним и остаются в памяти до тех пор,
пока работает JVM. Именно поэтому они очень полезны для хранения состояния, которое должно быть доступно во всем приложении.

получается я могу создать 100 object и еще 100 companion object,
но воспользуюсь только 5 из них, то в памяти будут только 5?

Если вы создали 100 объектов, но обратились только к 5 из них,
то в памяти будут только эти 5 объектов. Остальные 95 не будут созданы и не займут память, пока к ним не обратятся.

Это отличие от, например, статических полей в Java, которые инициализируются при загрузке класса,
независимо от того, использовались они или нет.
*/
fun handleUiEvent(event: UiEvent) {
    when (event) {
        is UiEvent.Click -> println("Click at position ${event.position}")
        is UiEvent.Swipe -> println("Swipe in ${event.direction} direction")
        UiEvent.LongPress -> println("Long press event")
        UiEvent.DoubleClick -> println("Double click event")
    }
}

fun main() {
    handleUiEvent(UiEvent.Click(5))
    handleUiEvent(UiEvent.Swipe("left"))
    handleUiEvent(UiEvent.LongPress)
    handleUiEvent(UiEvent.DoubleClick)

    println("-----------------------")
// не компилится т.к. нет состояния у отдельного члена, которое можно установить извне
//    UiEventEnum.Click.apply { position = 5 }.handle()
//    UiEventEnum.Swipe.apply { direction = "left" }.handle()
    UiEventEnum.LongPress.handle()
    UiEventEnum.DoubleClick.handle()
}
/*
этот енам - попытка повторить функционал класса UiEvent
но у него это не получается)
*/
enum class UiEventEnum {
    Click {
        override fun handle() = println("Click at position ${position}")
        var position: Int = 0
    },
    Swipe {
        override fun handle() = println("Swipe in ${direction} direction")
        var direction: String = ""
    },
    LongPress {
        override fun handle() = println("Long press event")
    },
    DoubleClick {
        override fun handle() = println("Double click event")
    };

    abstract fun handle()
}
