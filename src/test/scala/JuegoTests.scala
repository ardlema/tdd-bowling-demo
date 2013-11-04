package org.paradigma.tddbowlingdemo

import org.scalatest.{BeforeAndAfterEach, FunSuite}

class JuegoTests
  extends FunSuite
  with BeforeAndAfterEach {

  test("añadir dos lanzamientos sin tirar todos los bolos") {
    val puntuacionPrimerLanzamiento = 5
    val puntuacionSegundoLanzamiento = 4
    val puntuacionTotal = puntuacionPrimerLanzamiento + puntuacionSegundoLanzamiento
    val juegoConDosLanzamientos = new Juego
    juegoConDosLanzamientos.añadir(puntuacionPrimerLanzamiento)
    juegoConDosLanzamientos.añadir(puntuacionSegundoLanzamiento)

    assert(juegoConDosLanzamientos.getPuntuacion() == puntuacionTotal,
      s"El marcador despues de los lanzamientos no es $puntuacionTotal")

    assert(juegoConDosLanzamientos.getJugadaActual() == 2,
      "La jugada actual no es 2")
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

    assert(juegoConCuatroLanzamientos.getJugadaActual() == 3,
      "La jugada actual no es 3")
  }

  test("añadir un semipleno") {
    val puntuacionPrimerLanzamiento = 5
    val puntuacionSegundoLanzamiento = 5
    val puntuacionTercerLanzamiento = 3
    val puntuacionTotalPrimeraJugada = puntuacionPrimerLanzamiento + puntuacionSegundoLanzamiento
    val puntuacionSemipleno = puntuacionTotalPrimeraJugada + puntuacionTercerLanzamiento

    val juegoConCuatroLanzamientos = new Juego

    juegoConCuatroLanzamientos.añadir(puntuacionPrimerLanzamiento)
    juegoConCuatroLanzamientos.añadir(puntuacionSegundoLanzamiento)
    juegoConCuatroLanzamientos.añadir(puntuacionTercerLanzamiento)

    assert(juegoConCuatroLanzamientos.getPuntuacionParaJugada(1)
      == puntuacionSemipleno,
      s"El marcador del semipleno no es $puntuacionSemipleno")

    assert(juegoConCuatroLanzamientos.getJugadaActual() == 2,
      "La jugada actual no es 2")
  }

  test("añadir jugada despues de semipleno") {
    val puntuacionPrimerLanzamiento = 5
    val puntuacionSegundoLanzamiento = 5
    val puntuacionTercerLanzamiento = 3
    val puntuacionCuartoLanzamiento = 2
    val puntuacionTotalPrimeraJugada = puntuacionPrimerLanzamiento + puntuacionSegundoLanzamiento
    val puntuacionTotalSegundaJugada = puntuacionTercerLanzamiento + puntuacionCuartoLanzamiento
    val puntuacionSemipleno = puntuacionTotalPrimeraJugada + puntuacionTercerLanzamiento
    val puntuacionTotal = puntuacionSemipleno + puntuacionTotalSegundaJugada

    val juegoConCuatroLanzamientos = new Juego

    juegoConCuatroLanzamientos.añadir(puntuacionPrimerLanzamiento)
    juegoConCuatroLanzamientos.añadir(puntuacionSegundoLanzamiento)
    juegoConCuatroLanzamientos.añadir(puntuacionTercerLanzamiento)
    juegoConCuatroLanzamientos.añadir(puntuacionCuartoLanzamiento)

    assert(juegoConCuatroLanzamientos.getPuntuacionParaJugada(1)
      == puntuacionSemipleno,
      s"El marcador del semipleno no es $puntuacionSemipleno")

    assert(juegoConCuatroLanzamientos.getPuntuacionParaJugada(2)
      == puntuacionTotal,
      s"El marcador del semipleno no es $puntuacionTotal")

    assert(puntuacionTotal == juegoConCuatroLanzamientos.getPuntuacion(),
      s"El marcador total no es $puntuacionTotal")

    assert(juegoConCuatroLanzamientos.getJugadaActual() == 3,
      "La jugada actual no es 3")
  }

  test("añadir pleno") {
    val puntuacionPrimerLanzamiento = 10
    val puntuacionSegundoLanzamiento = 3
    val puntuacionTercerLanzamiento = 6
    val puntuacionTotalSegundaJugada = puntuacionSegundoLanzamiento + puntuacionTercerLanzamiento
    val puntuacionTotalPrimeraJugada = puntuacionPrimerLanzamiento + puntuacionTotalSegundaJugada
    val puntuacionTotal = puntuacionTotalPrimeraJugada + puntuacionTotalSegundaJugada

    val juegoConCuatroLanzamientos = new Juego

    juegoConCuatroLanzamientos.añadir(puntuacionPrimerLanzamiento)
    juegoConCuatroLanzamientos.añadir(puntuacionSegundoLanzamiento)
    juegoConCuatroLanzamientos.añadir(puntuacionTercerLanzamiento)

    assert(juegoConCuatroLanzamientos.getPuntuacionParaJugada(1)
      == puntuacionTotalPrimeraJugada,
      s"El marcador del pleno no es $puntuacionTotalPrimeraJugada")

    assert(juegoConCuatroLanzamientos.getPuntuacion()
      == puntuacionTotal,
      s"El marcador del semipleno no es $puntuacionTotal")

    assert(juegoConCuatroLanzamientos.getJugadaActual()
      == 3,
      s"La jugada actual no es 3")
  }
}

class Juego {
  var puntuacion = 0
  var lanzamientos = new Array[Int](21)
  var lanzamientoActual = 1
  var jugadaActual = 1
  var primerLanzamiento = true

  def getPuntuacion() = {
    getPuntuacionParaJugada(getJugadaActual()-1)
  }

  def getPuntuacionParaJugada(jugada: Int) = {
    var lanzamiento  = 0
    var puntuacion = 0
    var contadorJugadas = 0


    while(contadorJugadas < jugada)
    {
      contadorJugadas += 1
      val puntuacionPrimerLanzamiento = lanzamientos(lanzamiento+1)
      val puntuacionSegundLanzamiento = lanzamientos(lanzamiento+2)

      val puntuacionJugada = puntuacionPrimerLanzamiento + puntuacionSegundLanzamiento

      puntuacion += puntuacionJugada

      if (puntuacionJugada==10)
         puntuacion += lanzamientos(lanzamiento+3)

      lanzamiento += 2
    }

    puntuacion
  }

  def añadir(lanzamiento: Int) {
    puntuacion += lanzamiento
    lanzamientos(lanzamientoActual) = lanzamiento
    lanzamientoActual += 1
    ajustarJugadaActual()

  }

  def getJugadaActual() = jugadaActual

  def ajustarJugadaActual()
  {
    if (primerLanzamiento)
    {
      primerLanzamiento = false
    }
    else
    {
      primerLanzamiento = true
      jugadaActual += 1
    }
  }
}
