package com.example.parsingapp.yandex.first_webinar

/*
Когда вы определяете enum, все его значения инициализируются при первом обращении к enum.
Например, при первом вызове PlanetEnum.MERCURY или PlanetEnum.values(),
все значения PlanetEnum будут инициализированы и сохранены в памяти.
 */
enum class PlanetEnum(val mass: Double, val radius: Double) {

    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6) {

        override val abc = 10
        override fun myFun() {
            println("$mass + $radius!!")
        }

        override fun toString(): String {
            return super.toString() + " My Super CODE "
        }

    },
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27, 7.1492e7),
    SATURN(5.688e+26, 6.0268e7),
    URANUS(8.686e+25, 2.5559e7),
    NEPTUNE(1.024e+26, 2.4746e7)

    ;
    /*
    В данном случае, abc, myFun, surfaceGravity, surfaceWeight, и toString являются частью
    определения enum, но не контрактом или интерфейсом. Они включаются во все инстансы enum.

    С точки зрения OOP, они похожи на члены класса. Например, все инстансы
    PlanetEnum имеют доступ к surfaceGravity, surfaceWeight, и toString.

    С другой стороны, abc и myFun объявлены как open, что позволяет их переопределить
    в инстансах enum (как это сделано в VENUS). Это дает дополнительную гибкость,
    позволяя различным инстансам иметь различное поведение для этих функций.

    В данном случае, VENUS переопределяет abc, myFun, и toString, но другие инстансы
    PlanetEnum используют версии, определенные в основном теле PlanetEnum.
    */

    private val universalGravitationalConstant = 6.67430e-11

    open val abc: Int? = null
    open fun myFun() = Unit
    fun surfaceGravity(): Double =
        universalGravitationalConstant * mass / (radius * radius)


    fun surfaceWeight(otherPlanetMass: Double): Double =
        otherPlanetMass * surfaceGravity()


    override fun toString(): String =
        "Planet ${this.ordinal + 1} is ${this.name} with gravity ${surfaceGravity()}"

}

fun main() {
    val myWeightOnEarth = 75.0 // in kg
    val mass = myWeightOnEarth / PlanetEnum.EARTH.surfaceGravity()

    for (planet in PlanetEnum.values()) {
        println("My weight on ${planet.name} is ${planet.surfaceWeight(mass)} kilos!")
    }
    println(PlanetEnum.VENUS.abc)
    PlanetEnum.VENUS.myFun()
    println("-----------")
    println(PlanetEnum.EARTH.abc)
}
