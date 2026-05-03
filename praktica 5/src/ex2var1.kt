import kotlin.math.pow

fun main() {
    val a = 0.1
    val b = 1.2
    val h = 0.1

    println("Таблица значений функции y = Σ(n=1..20) x^(n-1) / (2n+1)")
    println("x\t\ty(x)")

    var x = a
    while (x <= b + 0.0001) {
        val y = calculateY(x)
        println("$x\t\t$y")
        x += h
    }
}

tailrec fun calculateY(x: Double, n: Int = 1, sum: Double = 0.0): Double {
    if (n > 20) return sum
    val term = x.pow(n - 1) / (2 * n + 1)
    return calculateY(x, n + 1, sum + term)
}