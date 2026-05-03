fun main() {
    print("Введите число от 1 до 100: ")
    val n = readLine()?.toIntOrNull() ?: 0

    if (n in 1..100) {
        val word = when (n) {
            1 -> "год"
            in 2..4 -> "года"
            in 5..20 -> "лет"
            else -> {
                val lastDigit = n % 10
                when (lastDigit) {
                    1 -> "год"
                    in 2..4 -> "года"
                    else -> "лет"
                }
            }
        }
        println("$n $word")
    } else {
        println("Ошибка: число должно быть от 1 до 100")
    }
}