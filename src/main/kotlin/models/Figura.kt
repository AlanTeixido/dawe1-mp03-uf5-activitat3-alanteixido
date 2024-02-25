package models

class Figura(numCostats: Int, vararg costats: Int) {
    private val numCostats: Int
    private val costats: IntArray

    init {
        require(numCostats >= 3 && numCostats == costats.size) {
            "El número de costats debe ser al menos 3 y debe coincidir con el número de longitudes proporcionadas"
        }
        this.numCostats = numCostats
        this.costats = costats
    }

    fun perimetre(): Int {
        return costats.sum()
    }
}
