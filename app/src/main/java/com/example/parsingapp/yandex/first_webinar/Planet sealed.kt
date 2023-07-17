package com.example.parsingapp.yandex.first_webinar

/*
С sealed class, каждый подкласс инициализируется при первом обращении к нему.
Например, при первом вызове PlanetSealed.MERCURY, этот объект будет инициализирован и сохранен в памяти.
 */
sealed class PlanetSealed(val mass: Double, val radius: Double) {

    object MERCURY : PlanetSealed(3.303e+23, 2.4397e6)
    object VENUS : PlanetSealed(4.869e+24, 6.0518e6) {
        val a = 10
    }

    object EARTH : PlanetSealed(5.976e+24, 6.37814e6)
    object MARS : PlanetSealed(6.421e+23, 3.3972e6)
    object JUPITER : PlanetSealed(1.9e+27, 7.1492e7)
    object SATURN : PlanetSealed(5.688e+26, 6.0268e7)
    object URANUS : PlanetSealed(8.686e+25, 2.5559e7)
    object NEPTUNE : PlanetSealed(1.024e+26, 2.4746e7)

    private val universalGravitationalConstant = 6.67430e-11

    fun surfaceGravity(): Double =
        universalGravitationalConstant * mass / (radius * radius)


    fun surfaceWeight(otherPlanetMass: Double): Double =
        otherPlanetMass * surfaceGravity()

    /*
     в toString() и в цикле вывода используется this::class.simpleName вместо
     this.ordinal+1 и this.name, поскольку в sealed классах свойств ordinal и name нет.
    */
    override fun toString(): String =
        "Planet ${this::class.simpleName} with gravity ${surfaceGravity()}"

}

fun main() {
    val myWeightOnEarth = 75.0 // in kg
    val mass = myWeightOnEarth / PlanetSealed.EARTH.surfaceGravity()

    val planets = listOf(
        PlanetSealed.MERCURY,
        PlanetSealed.VENUS,
        PlanetSealed.EARTH,
        PlanetSealed.MARS,
        PlanetSealed.JUPITER,
        PlanetSealed.SATURN,
        PlanetSealed.URANUS,
        PlanetSealed.NEPTUNE
    )

    PlanetSealed.VENUS.a

    for (planet in planets) {
        println("My weight on ${planet::class.simpleName} is ${planet.surfaceWeight(mass)} kilos!")
    }
    println("-----------")
    println(PlanetSealed.EARTH)
}
