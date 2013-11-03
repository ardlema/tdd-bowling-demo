package org.paradigma.tddbowlingdemo

import org.scalatest.FunSuite

class JuegoTests extends FunSuite {

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
}

class Juego {
  var puntuacion = 0

  def getPuntuacion() = puntuacion

  def añadir(lanzamiento: Int) {
    puntuacion += lanzamiento
  }
}
