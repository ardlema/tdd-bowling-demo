package org.paradigma.tddbowlingdemo

class Marcador {
  var marcadorBola = 0
  var marcadorLanzamientos = new Array[Int](21)
  var marcadorLanzamientoActual = 0

  def añadirLanzamiento(puntuacion: Int)
  {
    marcadorLanzamientos(marcadorLanzamientoActual) = puntuacion
    marcadorLanzamientoActual += 1
  }


  def puntuacionParaJugada(jugada: Int) = {
    marcadorBola = 0
    var puntuacion = 0
    var contadorJugadas = 0

    while(contadorJugadas < jugada)
    {
      contadorJugadas += 1
      //strike
      if (strike) {
        puntuacion += 10 + siguientesDosBolas
      }
      else if (spare) {
        puntuacion += 10 + puntuacionSiguienteBola
      }
      else {
        puntuacion += dosBolasEnLaJugada
      }
    }

    puntuacion
  }

  def strike = {
    if (marcadorLanzamientos(marcadorBola) == 10) {
      marcadorBola = marcadorBola + 1
      true
    } else {
      false
    }
  }

  def spare = {
    if (marcadorLanzamientos(marcadorBola)+marcadorLanzamientos(marcadorBola+1)==10) {
      marcadorBola = marcadorBola + 2
      true
    } else {
      false
    }
  }

  def siguientesDosBolas = marcadorLanzamientos(marcadorBola) + marcadorLanzamientos(marcadorBola+1)

  def dosBolasEnLaJugada = {
    val puntuacionDosBolas = siguientesDosBolas
    marcadorBola = marcadorBola + 2
    puntuacionDosBolas
  }

  def puntuacionSiguienteBola = marcadorLanzamientos(marcadorBola)
}

