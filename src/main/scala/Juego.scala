package org.paradigma.tddbowlingdemo

class Juego {
  var puntuacion = 0
  var jugadaActual = 1
  var primerLanzamientoenJugada = true
  val marcador = new Marcador()

  def getPuntuacion() = {
    getPuntuacionParaJugada(jugadaActual)
  }

  def añadir(lanzamiento: Int) = {
    marcador.añadirLanzamiento(lanzamiento)
    ajustarJugadaActual(lanzamiento)
  }

  def ajustarJugadaActual(lanzamiento: Int)
  {
    if (primerLanzamientoenJugada)
    {
      if (ajustarJugadaParaStrike(lanzamiento)==false)
        primerLanzamientoenJugada = false
    }
    else
    {
      primerLanzamientoenJugada = true
      avanzarJugada()
    }
  }

  def avanzarJugada() = {
    jugadaActual = math.min(10, jugadaActual + 1);
  }

  def ajustarJugadaParaStrike(lanzamiento: Int) =
  {
    if (lanzamiento == 10)
    {
      avanzarJugada()
      true
    } else {
      false
    }
  }

  def getPuntuacionParaJugada(jugada: Int) = marcador.puntuacionParaJugada(jugada)
}
