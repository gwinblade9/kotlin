data class Article(
    val name: String,
    val annotation: String,
    val tags: MutableSet<String>
)

fun main() {
    val articles = listOf(
        Article(
            name = "Коллекции в Kotlin",
            annotation = "Правила работы с коллекциями в Kotlin. Основные операции и методы.",
            tags = mutableSetOf("Программирование", "Kotlin", "Коллекции")
        ),
        Article(
            name = "Функции высшего порядка",
            annotation = "Использование функций высшего порядка в Kotlin для обработки данных.",
            tags = mutableSetOf("Программирование", "Kotlin", "Функции")
        ),
        Article(
            name = "Null Safety в Kotlin",
            annotation = "Безопасная работа с nullable типами в языке Kotlin.",
            tags = mutableSetOf("Программирование", "Kotlin", "Null Safety")
        ),
        Article(
            name = "Coroutines",
            annotation = "Асинхронное программирование с использованием корутин в Kotlin.",
            tags = mutableSetOf("Программирование", "Kotlin", "Асинхронность")
        )
    )

    var exit = false
    while (!exit) {
        println("\n--- Меню ---")
        println("1. Добавить новый тег в статью по названию")
        println("2. Автоматически добавить тег ко всем статьям по слову из аннотации")
        println("3. Найти все статьи по тегу")
        println("4. Показать все статьи с их тегами")
        println("0. Выход")
        print("Выберите действие: ")

        when (readLine()?.toIntOrNull()) {
            1 -> addTagToArticle(articles)
            2 -> autoAddTagByAnnotation(articles)
            3 -> findArticlesByTag(articles)
            4 -> showAllArticles(articles)
            0 -> {
                println("До свидания!")
                exit = true
            }
            else -> println("Неверный ввод")
        }
    }
}

// a Добавление нового тега в статью по названию статьи
fun addTagToArticle(articles: List<Article>) {
    println("\nСписок статей:")
    articles.forEach { println("  - ${it.name}") }

    print("\nВведите название статьи: ")
    val articleName = readLine() ?: return

    val article = articles.find { it.name.equals(articleName, ignoreCase = true) }

    if (article != null) {
        print("Введите новый тег: ")
        val newTag = readLine() ?: return
        article.tags.add(newTag)
        println("Тег '$newTag' добавлен к статье '${article.name}'")
        println("Теперь теги статьи: ${article.tags.joinToString(", ")}")
    } else {
        println("Статья с названием '$articleName' не найдена")
    }
}

// b Автоматическое добавление тега ко всем статьям, где в аннотации есть вводимое слово
fun autoAddTagByAnnotation(articles: List<Article>) {
    print("Введите слово для поиска в аннотации: ")
    val searchWord = readLine()?.lowercase() ?: return

    print("Введите тег, который нужно добавить: ")
    val newTag = readLine() ?: return

    var count = 0
    for (article in articles) {
        if (article.annotation.lowercase().contains(searchWord)) {
            article.tags.add(newTag)
            count++
            println("Добавлен тег '$newTag' к статье '${article.name}'")
        }
    }

    if (count == 0) {
        println("Статьи, содержащие слово '$searchWord' в аннотации, не найдены")
    } else {
        println("Тег '$newTag' добавлен к $count статьям")
    }
}

// c Вывод всех названий статей, где есть введенный тег
fun findArticlesByTag(articles: List<Article>) {
    print("Введите тег для поиска: ")
    val searchTag = readLine() ?: return

    val foundArticles = articles.filter { it.tags.contains(searchTag) }

    if (foundArticles.isNotEmpty()) {
        println("Статьи с тегом '$searchTag':")
        foundArticles.forEach { println("  - ${it.name}") }
    } else {
        println("Статьи с тегом '$searchTag' не найдены")
    }
}

// Дополнительная функция для просмотра всех статей
fun showAllArticles(articles: List<Article>) {
    println("\nВсе статьи:")
    for (article in articles) {
        println("  Название: ${article.name}")
        println("  Аннотация: ${article.annotation}")
        println("  Теги: ${article.tags.joinToString(", ")}")
        println()
    }
}