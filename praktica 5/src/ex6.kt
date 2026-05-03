fun main() {
    println("\n=== Задание 6. Проверка на совпадение шаблона ===")

    // Тестовые примеры
    val tests = listOf(
        Triple("abc", "a?c", true),
        Triple("abc", "a*c", true),
        Triple("abc", "a*d", false),
        Triple("hello", "h*lo", true),
        Triple("hello", "h*", true),
        Triple("hello", "*o", true),
        Triple("", "*", true),
        Triple("", "?", false),
        Triple("abc", "*", true),
        Triple("abc", "???", true),
        Triple("abc", "????", false)
    )

    println("Результаты тестов:")
    for ((text, pattern, expected) in tests) {
        val result = matchesPattern(text, pattern)
        val status = if (result == expected) "✓" else "✗"
        println("$status \"$text\" vs \"$pattern\" -> $result (expected: $expected)")
    }

    // Интерактивный режим
    println("\n--- Интерактивный режим ---")
    print("Введите текст: ")
    val text = readLine() ?: ""
    print("Введите шаблон (? - один символ, * - любое количество символов): ")
    val pattern = readLine() ?: ""

    if (matchesPattern(text, pattern)) {
        println("Текст соответствует шаблону!")
    } else {
        println("Текст НЕ соответствует шаблону!")
    }
}

fun matchesPattern(text: String, pattern: String): Boolean {
    return matchesPatternRecursive(text, pattern, 0, 0)
}

private fun matchesPatternRecursive(text: String, pattern: String, tIdx: Int, pIdx: Int): Boolean {
    // Если оба индекса достигли конца
    if (pIdx == pattern.length && tIdx == text.length) {
        return true
    }

    // Если шаблон закончился, а текст нет
    if (pIdx == pattern.length) {
        return false
    }

    // Обработка символа '*'
    if (pattern[pIdx] == '*') {
        // * соответствует 0 или более символов
        var i = tIdx
        while (i <= text.length) {
            if (matchesPatternRecursive(text, pattern, i, pIdx + 1)) {
                return true
            }
            i++
        }
        return false
    }

    // Если текст закончился, но шаблон не '*' и не закончился
    if (tIdx == text.length) {
        return false
    }

    // Обработка символа '?' или точного совпадения
    if (pattern[pIdx] == '?' || pattern[pIdx] == text[tIdx]) {
        return matchesPatternRecursive(text, pattern, tIdx + 1, pIdx + 1)
    }

    return false
}

// Более эффективная версия с динамическим программированием
fun matchesPatternDP(text: String, pattern: String): Boolean {
    val dp = Array(text.length + 1) { BooleanArray(pattern.length + 1) }
    dp[0][0] = true

    // Обработка звездочек в начале шаблона
    for (j in 1..pattern.length) {
        if (pattern[j - 1] == '*') {
            dp[0][j] = dp[0][j - 1]
        }
    }

    for (i in 1..text.length) {
        for (j in 1..pattern.length) {
            when {
                pattern[j - 1] == '*' -> {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j]
                }
                pattern[j - 1] == '?' || pattern[j - 1] == text[i - 1] -> {
                    dp[i][j] = dp[i - 1][j - 1]
                }
                else -> {
                    dp[i][j] = false
                }
            }
        }
    }

    return dp[text.length][pattern.length]
}