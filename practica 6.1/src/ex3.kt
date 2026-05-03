fun main() {
    println("\nЗадача 3: Поиск подмассива\n")

    val array = IntArray(50) { it + 1 }
    val k = 42

    println("Массив: ${array.joinToString(", ")}")
    println("Ищем подмассив с суммой = $k")

    val result = findSubarrayWithSum(array, k)

    if (result != -1) {
        println("Индекс первого вхождения подмассива = $result")

        // Выводим найденный подмассив для проверки
        var sum = 0
        var endIndex = result
        while (sum < k && endIndex < array.size) {
            sum += array[endIndex]
            endIndex++
        }
        if (sum == k) {
            println("Подмассив: ${array.slice(result until endIndex).joinToString(", ")}")
            println("Сумма = $sum")
        }
    } else {
        println("Подмассив с суммой $k не найден")
    }

    // Дополнительный тест
    println("\nДополнительный тест")
    val testArray = intArrayOf(1, 2, 3, 4, 5, 1, 2, 3)
    println("Массив: ${testArray.joinToString(", ")}")
    val testK = 6
    val testResult = findSubarrayWithSum(testArray, testK)
    println("Поиск суммы $testK: индекс = $testResult")
    if (testResult != -1) {
        var sum = 0
        var idx = testResult
        while (sum < testK && idx < testArray.size) {
            sum += testArray[idx]
            idx++
        }
        println("Найденный подмассив: ${testArray.slice(testResult until idx).joinToString(", ")}")
    }
}

// Функция поиска индекса первого вхождения подмассива с суммой k
fun findSubarrayWithSum(array: IntArray, k: Int): Int {
    for (start in array.indices) {
        var sum = 0
        for (end in start until array.size) {
            sum += array[end]
            if (sum == k) {
                return start
            }
            if (sum > k) break // Оптимизация: если сумма превысила k, дальше не ищем
        }
    }
    return -1
}