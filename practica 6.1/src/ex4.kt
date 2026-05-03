import kotlin.random.Random

fun main() {
    println("\nЗадача 4: Максимальная разница\n")

    // Создаем массив из 100 случайных чисел от -100 до 100
    val array = IntArray(100) { Random.nextInt(-100, 101) }

    println("Первые 20 элементов массива: ${array.take(20).joinToString(", ")}...")

    // Способ 1: С использованием встроенных функций
    val result1 = maxDifferenceWithBuiltIn(array)
    println("\nСпособ 1 с встроенными функциями")
    println("Максимальная разница: ${result1.first} (индексы: ${result1.second} -> ${result1.third})")

    // Способ 2: Без использования встроенных функций
    val result2 = maxDifferenceManual(array)
    println("\nСпособ 2 ручная реализация")
    println("Максимальная разница: ${result2.first} (индексы: ${result2.second} -> ${result2.third})")

    // Проверка на примере
    println("\nПроверка на примере")
    val testArray = intArrayOf(7, 1, 5, 3, 6, 4)
    println("Массив: ${testArray.joinToString(", ")}")
    val testResult = maxDifferenceManual(testArray)
    println("Максимальная разница: ${testResult.first}")
}

// Способ 1: с использованием встроенных функций
fun maxDifferenceWithBuiltIn(array: IntArray): Triple<Int, Int, Int> {
    var minElement = array[0]
    var minIndex = 0
    var maxDiff = 0
    var maxDiffIndex1 = 0
    var maxDiffIndex2 = 0

    for (i in 1 until array.size) {
        val diff = array[i] - minElement
        if (diff > maxDiff) {
            maxDiff = diff
            maxDiffIndex1 = minIndex
            maxDiffIndex2 = i
        }
        if (array[i] < minElement) {
            minElement = array[i]
            minIndex = i
        }
    }

    return Triple(maxDiff, maxDiffIndex1, maxDiffIndex2)
}

// Способ 2: ручная реализация
fun maxDifferenceManual(array: IntArray): Triple<Int, Int, Int> {
    if (array.size < 2) return Triple(0, -1, -1)

    var maxDiff = array[1] - array[0]
    var minElement = array[0]
    var minIndex = 0
    var resultStart = 0
    var resultEnd = 1

    for (i in 1 until array.size) {
        val currentDiff = array[i] - minElement
        if (currentDiff > maxDiff) {
            maxDiff = currentDiff
            resultStart = minIndex
            resultEnd = i
        }
        if (array[i] < minElement) {
            minElement = array[i]
            minIndex = i
        }
    }

    return Triple(maxDiff, resultStart, resultEnd)
}