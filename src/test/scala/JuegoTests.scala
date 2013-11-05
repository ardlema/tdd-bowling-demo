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

    val juegoConDosJugadasYUnStrike = new Juego

    juegoConDosJugadasYUnStrike.añadir(puntuacionPrimerLanzamiento)
    juegoConDosJugadasYUnStrike.añadir(puntuacionSegundoLanzamiento)
    juegoConDosJugadasYUnStrike.añadir(puntuacionTercerLanzamiento)


    assert(juegoConDosJugadasYUnStrike.getPuntuacionParaJugada(1)
      == puntuacionTotalPrimeraJugada,
      s"El marcador del pleno no es $puntuacionTotalPrimeraJugada")

    assert(juegoConDosJugadasYUnStrike.getPuntuacion()
      == puntuacionTotal,
      s"El marcador total no es $puntuacionTotal")

    assert(juegoConDosJugadasYUnStrike.getJugadaActual() == 3,
      s"La jugada actual no es 3")
  }

  test("juego perfecto") {
    val puntuacionJuegoPerfecto = 300
    val juegoPerfecto = new Juego

    for (i <- 1 to 12)
    {
      juegoPerfecto.añadir(10)
    }

    assert(juegoPerfecto.getPuntuacion()
      == puntuacionJuegoPerfecto,
      s"El marcador total no es $puntuacionJuegoPerfecto")

    assert(juegoPerfecto.getJugadaActual() == 11,
      s"La jugada actual no es 10")
  }

  test("final del array") {
    val puntuacionJuegoConStrikeEnLaUltimaJugada = 20
    val juegoConStrikeEnLaUltimaJugada = new Juego

    for (i <- 0 to 8)
    {
      juegoConStrikeEnLaUltimaJugada.añadir(0)
      juegoConStrikeEnLaUltimaJugada.añadir(0)
    }
    juegoConStrikeEnLaUltimaJugada.añadir(2)
    juegoConStrikeEnLaUltimaJugada.añadir(8) //10th jugada
    juegoConStrikeEnLaUltimaJugada.añadir(10) //Strike en la ultima posición


    assert(juegoConStrikeEnLaUltimaJugada.getPuntuacion()
      == puntuacionJuegoConStrikeEnLaUltimaJugada,
      s"El marcador total no es $puntuacionJuegoConStrikeEnLaUltimaJugada")
  }

  test("partida de ejemplo")
  {
    val puntuacionPartidaDeEjemplo = 133
    val partidaDeEjemplo = new Juego
    partidaDeEjemplo.añadir(1)
    partidaDeEjemplo.añadir(4)
    partidaDeEjemplo.añadir(4)
    partidaDeEjemplo.añadir(5)
    partidaDeEjemplo.añadir(6)
    partidaDeEjemplo.añadir(4)
    partidaDeEjemplo.añadir(5)
    partidaDeEjemplo.añadir(5)
    partidaDeEjemplo.añadir(10)
    partidaDeEjemplo.añadir(0)
    partidaDeEjemplo.añadir(1)
    partidaDeEjemplo.añadir(7)
    partidaDeEjemplo.añadir(3)
    partidaDeEjemplo.añadir(6)
    partidaDeEjemplo.añadir(4)
    partidaDeEjemplo.añadir(10)
    partidaDeEjemplo.añadir(2)
    partidaDeEjemplo.añadir(8)
    partidaDeEjemplo.añadir(6)

    assert(partidaDeEjemplo.getPuntuacion()
      == puntuacionPartidaDeEjemplo,
      s"El marcador total no es $puntuacionPartidaDeEjemplo")
  }

  test("11 strikes y un 9") {
    val puntuacion11StrikesYUn9 = 299
    val partidaCon11StrikesYUn9 = new Juego
    for (i <- 0 to 10)
      partidaCon11StrikesYUn9.añadir(10)

    partidaCon11StrikesYUn9.añadir(9)

    assert(partidaCon11StrikesYUn9.getPuntuacion()
      == puntuacion11StrikesYUn9,
      s"El marcador total no es $puntuacion11StrikesYUn9")
  }

  test("semipleno en la jugada 10") {
    val puntuacionSemiplenoJugada10 = 270
    val partidaConSemiplenoJugada10 = new Juego
    for (i <- 0 to 8)
      partidaConSemiplenoJugada10.añadir(10)

    partidaConSemiplenoJugada10.añadir(9)
    partidaConSemiplenoJugada10.añadir(1)
    partidaConSemiplenoJugada10.añadir(1)

    assert(partidaConSemiplenoJugada10.getPuntuacion()
      == puntuacionSemiplenoJugada10,
      s"El marcador total no es $puntuacionSemiplenoJugada10")
  }
}

class Juego {
  var puntuacion = 0
  var lanzamientos = new Array[Int](21)
  var lanzamientoActual = 0
  var jugadaActual = 1
  var primerLanzamientoenJugada = true
  var primerLanzamiento = 0
  var segundoLanzamiento = 0
  var bolo = 0

  def getPuntuacion() = {
    getPuntuacionParaJugada(getJugadaActual()-1)
  }

  def getPuntuacionParaJugada(jugada: Int) = {
    var puntuacion = 0
    var contadorJugadas = 0
    bolo = 0

    while(contadorJugadas < jugada)
    {
      primerLanzamiento = lanzamientos(bolo)
      contadorJugadas += 1
      //strike
      if (strike) {
        bolo = bolo+1
        puntuacion += 10 + nextTwoBalls
      }
      else {
        puntuacion += calcularSegundoLanzamiento
      }
    }

    puntuacion
  }

  def strike = lanzamientos(bolo) == 10

  def nextTwoBalls = lanzamientos(bolo) + lanzamientos(bolo+1)


  def calcularSegundoLanzamiento = {
    var marcador = 0
    val puntuacionSegundoLanzamiento = lanzamientos(bolo+1)
    val puntuacionJugada = primerLanzamiento + puntuacionSegundoLanzamiento


    if (spare) {
      bolo += 2
      marcador += puntuacionJugada + nextBall
    }
    else {
      bolo +=2
      marcador += puntuacionJugada
    }

    marcador
  }

  def spare = (lanzamientos(bolo)+lanzamientos(bolo+1))==10

  def nextBall = lanzamientos(bolo)

  def añadir(lanzamiento: Int) {
    puntuacion += lanzamiento
    lanzamientos(lanzamientoActual) = lanzamiento
    lanzamientoActual += 1
    ajustarJugadaActual(lanzamiento)

  }

  def getJugadaActual() = jugadaActual

  def ajustarJugadaActual(lanzamiento: Int)
  {
    if (primerLanzamientoenJugada)
    {
      if (lanzamiento == 10) //strike
         jugadaActual += 1
      else
        primerLanzamientoenJugada = false
    }
    else
    {
      primerLanzamientoenJugada = true
      jugadaActual += 1
    }
    jugadaActual = math.min(11, jugadaActual)
  }
}
