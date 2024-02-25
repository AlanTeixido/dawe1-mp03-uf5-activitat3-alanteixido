package models
import java.util.*

class Calculadora {
    fun calcular(operacion: Char, operand1: Int, operand2: Int): Int {
        return when (operacion) {
            '+' -> operand1 + operand2
            '-' -> operand1 - operand2
            '*' -> operand1 * operand2
            '/' -> {
                if (operand2 != 0) {
                    operand1 / operand2
                } else {
                    throw ArithmeticException("No se puede dividir por cero")
                }
            }
            else -> throw IllegalArgumentException("Operación no válida")
        }
    }
}