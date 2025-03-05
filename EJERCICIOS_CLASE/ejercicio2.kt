import kotlin.math.pow

fun main() {
    var L = 2.0 // Convertido a Double para evitar errores en pow()

    var areaTotal = 0.0
    var perimetro = 0.0
    var areaCuadrado = 0.0
    var areaTriangulosEsquinas = 0.0
    var areaTrianguloPrincipal = 0.0
    var areaRectangulo = 0.0

    areaCuadrado = L*L
    areaTriangulosEsquinas = (L * L * 0.5)*2.0
    areaTrianguloPrincipal =( L * (L * 1.5 )) *0.5
    areaRectangulo = (2.0 * L) * (0.75 * L)

    areaTotal = areaCuadrado + areaTriangulosEsquinas + areaTrianguloPrincipal + areaRectangulo

    println("El área total es: $areaTotal")
}
