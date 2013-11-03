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
}

class Juego {
  var puntuacion = 0

  def getPuntuacion() = puntuacion

  def añadir(lanzamiento: Int) {
    puntuacion += lanzamiento
  }
}
