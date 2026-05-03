import kotlin.random.Random

fun main() {
    println("=== Задача 1: Перемешивание массива ===\n")

    // Создаем массив из 30 строк
    val originalArray = Array(30) { "Элемент_${it + 1}" }

    println("Исходный массив:")
    println(originalArray.joinToString(", "))

    // Способ 1 С использованием встроенных функций
    val shuffledArray1 = shuffleWithBuiltIn(originalArray)
    println("\nСпособ 1 (с встроенными функциями):")
    println(shuffledArray1.joinToString(", "))

    // Способ 2 Без использования встроенных функций (ручное перемешивание)
    val shuffledArray2 = originalArray.copyOf()
    manualShuffle(shuffledArray2)
    println("\nСпособ 2 (ручное перемешивание):")
    println(shuffledArray2.joinToString(", "))
}

// Способ 1: с использованием встроенных функций
fun shuffleWithBuiltIn(array: Array<String>): Array<String> {
    // Преобразуем массив в список, перемешиваем, затем обратно в массив
    return array.toList().shuffled().toTypedArray()
}

// Ручное перемешивание массива (алгоритм Фишера-Йетса)
fun manualShuffle(array: Array<String>) {
    for (i in array.indices.reversed()) {
        val randomIndex = Random.nextInt(i + 1)
        val temp = array[i]
        array[i] = array[randomIndex]
        array[randomIndex] = temp
    }
}