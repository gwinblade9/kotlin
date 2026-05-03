fun main() {
    println("\nЗадача 6: Уникальные и пересекающиеся элементы\n")

    val list1 = listOf(85, 90, 78, 92, 85)
    val list2 = listOf(88, 90, 95, 78, 85)

    println("Список 1: $list1")
    println("Список 2: $list2")

    val (unique, intersection) = findUniqueAndIntersection(list1, list2)

    println("\nУникальные оценки: $unique")
    println("Пересечение оценок: $intersection")

    // Дополнительный тест
    println("\nДополнительный тест")
    val test1 = listOf(1, 2, 3, 4, 5, 5)
    val test2 = listOf(4, 5, 6, 7, 8, 8)
    println("Список 1: $test1")
    println("Список 2: $test2")

    val (testUnique, testIntersection) = findUniqueAndIntersection(test1, test2)
    println("Уникальные: $testUnique")
    println("Пересечение: $testIntersection")
}

fun findUniqueAndIntersection(list1: List<Int>, list2: List<Int>): Pair<Set<Int>, Set<Int>> {
    val set1 = list1.toSet()
    val set2 = list2.toSet()

    val intersection = set1.intersect(set2)

    // Уникальные элементы = (объединение) минус (пересечение)
    val unique = set1.union(set2).subtract(intersection)

    return Pair(unique, intersection)
}