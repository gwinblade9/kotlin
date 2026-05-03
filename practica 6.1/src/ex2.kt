fun main() {
    println("\nЗадача 2: Объединение массивов\n")

    val array1 = intArrayOf(5, 3, 8, 1, 2, 7, 4, 9, 6, 10, 3, 5, 2, 8, 1)
    val array2 = intArrayOf(15, 12, 11, 14, 13, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)

    println("Массив 1: ${array1.joinToString(", ")}")
    println("Массив 2: ${array2.joinToString(", ")}")

    // Способ 1: С использованием встроенных функций
    val mergedArray1 = mergeAndSortWithBuiltIn(array1, array2)
    println("\nСпособ 1 с встроенными функциями")
    println(mergedArray1.joinToString(", "))

    // Способ 2: Без использования встроенных функций
    val mergedArray2 = mergeAndSortManual(array1, array2)
    println("\nСпособ 2 ручная реализация")
    println(mergedArray2.joinToString(", "))
}

fun mergeAndSortWithBuiltIn(arr1: IntArray, arr2: IntArray): IntArray {
    return (arr1 + arr2)
        .distinct()
        .sorted()
        .toIntArray()
}

fun mergeAndSortManual(arr1: IntArray, arr2: IntArray): IntArray {
    // Объединяем массивы
    val merged = IntArray(arr1.size + arr2.size)
    for (i in arr1.indices) {
        merged[i] = arr1[i]
    }
    for (i in arr2.indices) {
        merged[arr1.size + i] = arr2[i]
    }

    // Удаляем дубликаты
    val unique = removeDuplicates(merged)

    // Сортируем
    bubbleSort(unique)

    return unique
}

fun removeDuplicates(arr: IntArray): IntArray {
    var result = IntArray(0)
    for (element in arr) {
        if (!contains(result, element)) {
            result = result + element
        }
    }
    return result
}

fun contains(arr: IntArray, value: Int): Boolean {
    for (element in arr) {
        if (element == value) return true
    }
    return false
}

fun bubbleSort(arr: IntArray) {
    for (i in arr.indices) {
        for (j in 0 until arr.size - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}

// Оператор для добавления элемента в массив
operator fun IntArray.plus(element: Int): IntArray {
    val newArray = IntArray(this.size + 1)
    for (i in this.indices) {
        newArray[i] = this[i]
    }
    newArray[this.size] = element
    return newArray
}