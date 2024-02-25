package models
import java.util.*

class Divisor {
    fun divide(dividendo: Int, divisor: Int): Int {
        if (divisor == 0) {
            throw ArithmeticException("No se puede dividir por cero")
        }
        return dividendo / divisor
    }
}