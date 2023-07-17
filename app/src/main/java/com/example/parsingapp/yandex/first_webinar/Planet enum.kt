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
    },
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27, 7.1492e7),
    SATURN(5.688e+26, 6.0268e7),
    URANUS(8.686e+25, 2.5559e7),
    NEPTUNE(1.024e+26, 2.4746e7)

    ;

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
