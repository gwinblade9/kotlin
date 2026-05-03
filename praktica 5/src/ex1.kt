fun main() {
    println("Задание 1. Четырехзначные счастливые номера")
    println("Счастливые номера (сумма первых двух цифр = сумме последних двух):")
    println()

    var count = 0
    for (number in 1000..9999) {
        if (isLuckyNumber(number)) {
            print("$number ")
            count++
            if (count % 15 == 0) println() // перенос строки для удобства
        }
    }

    println("\n\nВсего найдено: $count счастливых номеров")
}

// Функция для расчета суммы цифр двузначного числа
fun sumOfTwoDigits(num: Int): Int {
    val tens = num / 10
    val units = num % 10
    return tens + units
}

// Функция для проверки, является ли номер счастливым
fun isLuckyNumber(number: Int): Boolean {
    val firstTwo = number / 100      // первые две цифры
    val lastTwo = number % 100        // последние две цифры

    val sumFirst = sumOfTwoDigits(firstTwo)
    val sumLast = sumOfTwoDigits(lastTwo)

    return sumFirst == sumLast
}