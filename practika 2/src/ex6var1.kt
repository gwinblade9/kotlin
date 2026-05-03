fun main() {
    println("Введите координаты двух полей шахматной доски (1-8):")

    print("a = ")
    val a = readLine()?.toIntOrNull() ?: 0
    print("b = ")
    val b = readLine()?.toIntOrNull() ?: 0
    print("c = ")
    val c = readLine()?.toIntOrNull() ?: 0
    print("d = ")
    val d = readLine()?.toIntOrNull() ?: 0

    if (a in 1..8 && b in 1..8 && c in 1..8 && d in 1..8) {
        // Определяем цвет полей
        // На шахматной доске сумма координат определяет цвет:
        // четная сумма - одно цвет, нечетная - другой
        val color1 = if ((a + b) % 2 == 0) "черный" else "белый"
        val color2 = if ((c + d) % 2 == 0) "черный" else "белый"

        println("Поле ($a, $b) - $color1")
        println("Поле ($c, $d) - $color2")

        if (color1 == color2) {
            println("Поля одного цвета")
        } else {
            println("Поля разного цвета")
        }
    } else {
        println("Ошибка: координаты должны быть от 1 до 8")
    }
}