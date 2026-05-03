fun main() {
    println("Введите три целых числа:")
    print("a = ")
    val a = readLine()?.toIntOrNull() ?: 0
    print("b = ")
    val b = readLine()?.toIntOrNull() ?: 0
    print("c = ")
    val c = readLine()?.toIntOrNull() ?: 0

    val max = when {
        a >= b && a >= c -> a
        b >= a && b >= c -> b
        else -> c
    }

    println("Наибольшее число: $max")
}