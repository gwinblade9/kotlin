fun main() {
    print("Введите двузначное число: ")
    val n = readLine()?.toIntOrNull() ?: 0

    if (n in 10..99) {
        val tens = n / 10   // первая цифра
        val units = n % 10  // вторая цифра

        val square = n * n
        val sumOfCubes = (tens * tens * tens) + (units * units * units)
        val quadrupleSum = 4 * sumOfCubes

        println("Число: $n")
        println("Квадрат числа: $square")
        println("Учетверенная сумма кубов цифр: $quadrupleSum")

        if (square == quadrupleSum) {
            println("Ответ: положительный, квадрат равен учетверенной сумме кубов цифр")
        } else {
            println("Ответ: отрицательный, квадрат НЕ равен учетверенной сумме кубов цифр")
        }
    } else {
        println("Ошибка: введите двузначное число")
    }
}