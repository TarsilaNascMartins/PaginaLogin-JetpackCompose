package br.com.fiap.helloworld

import kotlin.math.pow

fun calcularIMC(peso: Double,altura:Double): Double {
    var imc = peso / (altura/100) .pow(2)

    return imc
}