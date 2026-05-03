fun main() {
    println("\nЗадание 5. Поиск анаграмм")

    val word = "listen"
    val candidates = listOf("enlist", "google", "inlets", "banana", "silent", "tinsel")

    val anagrams = findAnagrams(word, candidates)

    println("Исходное слово: $word")
    println("Список кандидатов: $candidates")
    println("Найденные анаграммы: $anagrams")

    // Дополнительный тест
    println("\nДоп тест")
    val word2 = "triangle"
    val candidates2 = listOf("integral", "alien", "related", "train", "alerting")
    val anagrams2 = findAnagrams(word2, candidates2)
    println("Слово: $word2")
    println("Анаграммы: $anagrams2")
}

fun findAnagrams(word: String, candidates: List<String>): List<String> {
    // Нормализуем слово (приводим к нижнему регистру и сортируем символы)
    val normalizedWord = normalizeString(word)

    return candidates.filter { candidate ->
        // Слово не считается анаграммой самого себя
        candidate.lowercase() != word.lowercase() &&
                normalizeString(candidate) == normalizedWord
    }
}

// Функция для нормализации строки (сортировка символов)
fun normalizeString(str: String): String {
    return str.lowercase().toCharArray().sorted().joinToString("")
}

// Альтернативная реализация через подсчет символов (эффективнее для длинных слов)
fun findAnagramsOptimized(word: String, candidates: List<String>): List<String> {
    val charCount = getCharCount(word)

    return candidates.filter { candidate ->
        candidate.lowercase() != word.lowercase() &&
                getCharCount(candidate) == charCount
    }
}

fun getCharCount(str: String): Map<Char, Int> {
    return str.lowercase().groupingBy { it }.eachCount()
}