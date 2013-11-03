package org.paradigma.tddbowlingdemo

import org.scalatest.FunSuite

class MarcadorTests extends FunSuite {

  test("puntuación del marcador sin lanzamientos") {
    val marcadorInicial = 0
    val marcadorSinLanzamiento = new Marcador

    assert(marcadorSinLanzamiento.getPuntuacion() == marcadorInicial, s"El marcador inicial no es $marcadorInicial")
  }
}

class Marcador {
  def getPuntuacion() = 0
}





