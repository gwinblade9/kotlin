fun main() {
    println("\nЗадание 4. Факториал через рекурсию")

    print("Введите число для вычисления факториала: ")
    val n = readLine()?.toIntOrNull() ?: 0

    if (n < 0) {
        println("Факториал определен только для неотрицательных чисел")
    } else {
        val result = factorial(n)
        println("$n! = $result")
    }

    // Демонстрация для чисел от 0 до 10
    println("\nТаблица факториалов:")
    for (i in 0..10) {
        println("$i! = ${factorial(i)}")
    }
}

// Рекурсивная функция для вычисления факториала
fun factorial(n: Int): Int {
    return if (n <= 1) {
        1
    } else {
        n * factorial(n - 1)
    }
}

// Альтернативный вариант с хвостовой рекурсией (более эффективный)
tailrec fun factorialTailRec(n: Int, accumulator: Int = 1): Int {
    return if (n <= 1) {
        accumulator
    } else {
        factorialTailRec(n - 1, n * accumulator)
    }
}