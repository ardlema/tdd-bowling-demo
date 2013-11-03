package org.paradigma.tddbowlingdemo

import org.scalatest.{BeforeAndAfterEach, FunSuite}

class JuegoTests
  extends FunSuite
  with BeforeAndAfterEach {

  val puntuacionSemipleno = 13

  test("añadir un lanzamiento") {
    val puntuacionLanzamiento = 5
    val juegoConUnLanzamiento = new Juego
    juegoConUnLanzamiento.añadir(puntuacionLanzamiento)

    assert(juegoConUnLanzamiento.getPuntuacion() == puntuacionLanzamiento,
      s"El marcador inicial no es $puntuacionLanzamiento")
  }

  test("añadir dos lanzamientos sin tirar todos los bolos") {
    val puntuacionPrimerLanzamiento = 5
    val puntuacionSegundoLanzamiento = 4
    val puntuacionTotal = puntuacionPrimerLanzamiento + puntuacionSegundoLanzamiento
    val juegoConDosLanzamientos = new Juego
    juegoConDosLanzamientos.añadir(puntuacionPrimerLanzamiento)
    juegoConDosLanzamientos.añadir(puntuacionSegundoLanzamiento)

    assert(juegoConDosLanzamientos.getPuntuacion() == puntuacionTotal,
      s"El marcador despues de los lanzamientos no es $puntuacionTotal")
  }

  test("añadir cuatro lanzamientos sin tirar todos los bolos en ninguno de ellos") {
    val puntuacionPrimerLanzamiento = 5
    val puntuacionSegundoLanzamiento = 4
    val puntuacionTercerLanzamiento = 2
    val puntuacionCuartoLanzamiento = 6
    val puntuacionTotalPrimeraJugada = puntuacionPrimerLanzamiento + puntuacionSegundoLanzamiento
    val puntuacionTotalSegundaJugada = puntuacionTercerLanzamiento + puntuacionCuartoLanzamiento
    val puntuacionTotal = puntuacionTotalPrimeraJugada + puntuacionTotalSegundaJugada

    val juegoConCuatroLanzamientos = new Juego

    juegoConCuatroLanzamientos.añadir(puntuacionPrimerLanzamiento)
    juegoConCuatroLanzamientos.añadir(puntuacionSegundoLanzamiento)
    juegoConCuatroLanzamientos.añadir(puntuacionTercerLanzamiento)
    juegoConCuatroLanzamientos.añadir(puntuacionCuartoLanzamiento)

    assert(juegoConCuatroLanzamientos.getPuntuacion() == puntuacionTotal,
      s"El marcador total despues de los lanzamientos no es $puntuacionTotal")

    assert(juegoConCuatroLanzamientos.getPuntuacionParaJugada(1) == puntuacionTotalPrimeraJugada,
      s"El marcador para la primera jugada no es $puntuacionTotalPrimeraJugada")

    assert(juegoConCuatroLanzamientos.getPuntuacionParaJugada(2) == puntuacionTotal,
      s"El marcador para la segunda jugada no es $puntuacionTotal")
  }

  test("añadir un semipleno") {
    val puntuacionPrimerLanzamiento = 5
    val puntuacionSegundoLanzamiento = 5
    val puntuacionTercerLanzamiento = 3
    val puntuacionCuartoLanzamiento = 2
    val puntuacionTotalPrimeraJugada = puntuacionPrimerLanzamiento + puntuacionSegundoLanzamiento
    val puntuacionTotalSegundaJugada = puntuacionTercerLanzamiento + puntuacionCuartoLanzamiento
    val puntuacionTotal = puntuacionTotalPrimeraJugada + puntuacionTotalSegundaJugada

    val juegoConCuatroLanzamientos = new Juego

    juegoConCuatroLanzamientos.añadir(puntuacionPrimerLanzamiento)
    juegoConCuatroLanzamientos.añadir(puntuacionSegundoLanzamiento)
    juegoConCuatroLanzamientos.añadir(puntuacionTercerLanzamiento)
    juegoConCuatroLanzamientos.añadir(puntuacionCuartoLanzamiento)

    assert(juegoConCuatroLanzamientos.getPuntuacionParaJugada(1) == puntuacionSemipleno,
      s"El marcador del semipleno no es $puntuacionSemipleno")

    assert(juegoConCuatroLanzamientos.getPuntuacion() == puntuacionTotal,
      s"El marcador total despues de los lanzamientos no es $puntuacionTotal")
  }
}

class Juego {
  var puntuacion = 0
  var lanzamientos = new Array[Int](21)
  var lanzamientoActual = 1

  def getPuntuacion() = puntuacion

  def getPuntuacionParaJugada(jugada: Int) = {
    var lanzamiento  = 0
    var puntuacion = 0
    var contadorJugadas = 0

    while(contadorJugadas < jugada)
    {
      contadorJugadas += 1
      puntuacion += lanzamientos(lanzamiento+1) + lanzamientos(lanzamiento+2)
      lanzamiento += 2
    }

    puntuacion
  }

  def añadir(lanzamiento: Int) {
    puntuacion += lanzamiento
    lanzamientos(lanzamientoActual) = lanzamiento
    lanzamientoActual += 1
  }
}
