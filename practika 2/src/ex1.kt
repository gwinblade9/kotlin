fun main() {
    // Простой способ - использовать литералы для Float и Double
    val floatMin: Float = 1.4E-45f      // минимальное дробное значение
    val floatMax: Float = 3.4028235E38f  // максимальное дробное значение

    val doubleMin: Double = 4.9E-324     // минимальное значение
    val doubleMax: Double = 1.7976931348623157E308  // максимальное значение

    println("Float: min=$floatMin, max=$floatMax")
    println("Double: min=$doubleMin, max=$doubleMax")
}