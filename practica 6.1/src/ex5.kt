fun main() {
    val array = intArrayOf(3, 7, 2, 7, 3, 1, 2, 7, 1, 3, 5, 5, 7, 3, 2, 1, 5, 7, 3, 2)

    println("Исходный массив: ${array.joinToString(", ")}")

    // Подсчет частоты
    val frequency = mutableMapOf<Int, Int>()
    for (num in array) {
        var count = 0
        for (n in array) {
            if (n == num) count++
        }
        frequency[num] = count
    }

    // Сортировка
    val result = array.toMutableList()
    for (i in result.indices) {
        for (j in i + 1 until result.size) {
            val freqI = frequency[result[i]] ?: 0
            val freqJ = frequency[result[j]] ?: 0

            if (freqI < freqJ || (freqI == freqJ && result[i] > result[j])) {
                val temp = result[i]
                result[i] = result[j]
                result[j] = temp
            }
        }
    }

    println("Отсортированный массив: ${result.joinToString(", ")}")
}