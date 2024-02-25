package org.example.controllers.controllers

import models.Divisor
import models.Calculadora
import models.Figura
import org.example.utilities.*

fun main() {
    val divisor = Divisor()
    val calculadora = Calculadora()

    while (true) {
        println("Selecciona una opción:")
        println("1. Divisor")
        println("2. Calculadora")
        println("3. Figura")
        println("0. Sortir")

        val opcion = readInt("Introdueix el número de l'opció:", "Entrada incorrecta")

        when (opcion) {
            1 -> {
                try {
                    val num1 = readInt("Introdueix el primer número:", "Entrada incorrecta")
                    val num2 = readInt("Introdueix el segon número:", "Entrada incorrecta")

                    val resultatDivisio = divisor.divide(num1, num2)
                    println("El resultat de la divisió és: $resultatDivisio")
                } catch (e: NumberFormatException) {
                    println("${RED_BACKGROUND_BRIGHT}ERROR: Introdueix un número vàlid$RESET")
                } catch (e: ArithmeticException) {
                    println("${RED_BACKGROUND_BRIGHT}ERROR: ${e.message}$RESET")
                }
            }
            2 -> {
                while (true) {
                    try {
                        val operacion = readChar("Introdueix l'operació (+, -, *, /), o 'Z' per sortir:", "Entrada incorrecta", 1)

                        if (operacion == 'Z') break

                        val operand1 = readInt("Introdueix el primer operand:", "Entrada incorrecta")
                        val operand2 = readInt("Introdueix el segon operand:", "Entrada incorrecta")

                        val resultat = when (operacion) {
                            '+' -> operand1 + operand2
                            '-' -> operand1 - operand2
                            '*' -> operand1 * operand2
                            '/' -> if (operand2 != 0) operand1 / operand2 else {
                                println("${RED_BACKGROUND_BRIGHT}ERROR: No pots dividir per zero.$RESET")
                                continue
                            }
                            else -> throw IllegalArgumentException("Operació no vàlida")
                        }
                        println("Resultat: $resultat")

                    } catch (e: IllegalArgumentException) {
                        println("${RED_BACKGROUND_BRIGHT}ERROR: ${e.message}$RESET")
                    } catch (e: NumberFormatException) {
                        println("${RED_BACKGROUND_BRIGHT}ERROR: Introdueix un número vàlid$RESET")
                    } catch (e: ArithmeticException) {
                        println("${RED_BACKGROUND_BRIGHT}ERROR: ${e.message}$RESET")
                    }
                }
            }
            3 -> {
                try {
                    val numCostats = readInt("Introdueix el nombre de costats de la figura:", "Entrada incorrecta")
                    val costats = IntArray(numCostats)
                    for (i in 0 until numCostats) {
                        costats[i] = readInt("Introdueix la longitud del costat ${i + 1}:", "Entrada incorrecta")
                    }

                    val figura = Figura(numCostats, *costats)
                    println("Perímetre de la figura: ${figura.perimetre()}")
                } catch (e: IllegalArgumentException) {
                    println("${RED_BACKGROUND_BRIGHT}ERROR: ${e.message}$RESET")
                }
            }
            0 -> {
                println("Fins aviat!")
                break
            }
            else -> println("${RED_BACKGROUND_BRIGHT}ERROR: Opció no vàlida$RESET")
        }
    }
}
