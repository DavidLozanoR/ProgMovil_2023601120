fun ordenamientoBurbuja(arreglo: IntArray) {
    val tamaño = arreglo.size

    for (i in 0 until tamaño - 1) {
        for (j in 0 until tamaño - i - 1) {
            // Si el número actual es mayor que el siguiente, intercambiarlos
            if (arreglo[j] > arreglo[j + 1]) {
                val temporal = arreglo[j]
                arreglo[j] = arreglo[j + 1]
                arreglo[j + 1] = temporal
            }
        }
    }
}

fun main() {
    // Definimos un arreglo de números desordenados
    val numeros = intArrayOf(5, 3, 8, 4, 2)

    // Mostramos el arreglo antes de ordenar
    println("Arreglo original: ${numeros.joinToString()}")

    // Aplicamos el algoritmo de ordenamiento burbuja
    ordenamientoBurbuja(numeros)

    // Mostramos el arreglo ordenado
    println("Arreglo ordenado: ${numeros.joinToString()}")
}
