import kotlin.random.Random

fun main() {
    println("\nЗадание 3. Сортировка массива и бинарный поиск")

    // Запрашиваем диапазон у пользователя
    println("Введите диапазон случайных чисел:")
    print("Минимум: ")
    val min = readLine()?.toIntOrNull() ?: 0
    print("Максимум: ")
    val max = readLine()?.toIntOrNull() ?: 100

    print("Введите размер массива: ")
    val size = readLine()?.toIntOrNull() ?: 10

    print("Введите число для поиска: ")
    val searchValue = readLine()?.toIntOrNull() ?: 0

    // Процедура 1: заполнение массива
    val originalArray = fillArray(size, min, max)
    println("\nИсходный массив: ${originalArray.joinToString(", ")}")

    // Процедура 2: сортировка (с сохранением исходного)
    val sortedArray = originalArray.sorted().toIntArray()
    println("Отсортированный массив: ${sortedArray.joinToString(", ")}")

    // Процедура 3: бинарный поиск
    val (found, index) = binarySearch(sortedArray, searchValue)

    if (found) {
        println("Элемент $searchValue найден в отсортированном массиве на позиции $index")
    } else {
        println("Элемент $searchValue не найден в массиве")
    }
}

// Процедура заполнения массива
fun fillArray(size: Int, min: Int, max: Int): IntArray {
    return IntArray(size) { Random.nextInt(min, max + 1) }
}

// Процедура сортировки (пузырьком - для наглядности)
fun bubbleSort(arr: IntArray): IntArray {
    val sorted = arr.copyOf()
    for (i in sorted.indices) {
        for (j in 0 until sorted.size - i - 1) {
            if (sorted[j] > sorted[j + 1]) {
                val temp = sorted[j]
                sorted[j] = sorted[j + 1]
                sorted[j + 1] = temp
            }
        }
    }
    return sorted
}

// Процедура бинарного поиска
fun binarySearch(arr: IntArray, target: Int): Pair<Boolean, Int> {
    var left = 0
    var right = arr.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        when {
            arr[mid] == target -> return Pair(true, mid)
            arr[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }

    return Pair(false, -1)
}