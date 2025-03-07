import java.util.Scanner

fun cifrarROT13(texto: String): String {
    val resultado = StringBuilder() // Para construir el texto cifrado

    for (caracter in texto) {
        // Si es una letra mayúscula (A-Z)
        if (caracter in 'A'..'Z') {
            val nuevoCaracter = ((caracter - 'A' + 13) % 26 + 'A'.code).toChar()
            resultado.append(nuevoCaracter)
        }
        // Si es una letra minúscula (a-z)
        else if (caracter in 'a'..'z') {
            val nuevoCaracter = ((caracter - 'a' + 13) % 26 + 'a'.code).toChar()
            resultado.append(nuevoCaracter)
        }
        // Si no es una letra, lo deja igual (espacios, números, símbolos)
        else {
            resultado.append(caracter)
        }
    }
    return resultado.toString()
}

fun main() {
    // Crear un objeto Scanner para leer la entrada del usuario
    val scanner = Scanner(System.`in`)

    // Pedimos al usuario que ingrese un texto
    print("Ingresa un texto para encriptar con ROT13: ")
    val textoOriginal = scanner.nextLine() // Leer entrada del usuario

    // Aplicamos el cifrado ROT13
    val textoCifrado = cifrarROT13(textoOriginal)

    // Mostramos el resultado
    println("Texto encriptado con ROT13: $textoCifrado")

    // Cerrar el Scanner
    scanner.close()
}
