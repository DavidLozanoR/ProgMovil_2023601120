import java.util.Scanner

fun factorial(n: Int): Long {
    return if (n == 0 || n == 1) 1 else n * factorial(n - 1)
}

fun main() {
    val scanner = Scanner(System.`in`)

    print("Ingresa un número entero: ")
    val num = scanner.nextInt()

    if (num >= 0) {
        println("El factorial de $num es: ${factorial(num)}")
    } else {
        println("Por favor, ingresa un número entero válido (mayor o igual a 0).")
    }
}

