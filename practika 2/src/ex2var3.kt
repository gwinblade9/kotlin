fun main() {
    println("Введите три вещественных числа:")
    print("a = ")
    val a = readLine()?.toDoubleOrNull() ?: 0.0
    print("b = ")
    val b = readLine()?.toDoubleOrNull() ?: 0.0
    print("c = ")
    val c = readLine()?.toDoubleOrNull() ?: 0.0

    val canBeTriangle = when {
        a <= 0 || b <= 0 || c <= 0 -> false
        a + b > c && a + c > b && b + c > a -> true
        else -> false
    }

    if (canBeTriangle) {
        println("Числа $a, $b, $c могут быть сторонами треугольника")
    } else {
        println("Числа $a, $b, $c НЕ могут быть сторонами треугольника")
    }
}