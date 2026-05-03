fun main() {
    val result = mutableListOf(
        Pair(first = "Meat", second = mutableListOf("Beef", "Chicken")),
        Pair(first = "Fruits", second = mutableListOf("Apple", "Banana", "Orange")),
        Pair(first = "Vegetables", second = mutableListOf("Carrot", "Broccoli"))
    )

    var exit = false
    while (!exit) {
        println("\nМеню:")
        println("1. Добавить новую категорию со списком товаров")
        println("2. Добавить товар в определённую категорию")
        println("3. Вывести все товары из определённой категории")
        println("4. Поиск товаров по названию")
        println("5. Показать все категории")
        println("0. Выход")
        print("Выберите действие: ")

        when (readLine()?.toIntOrNull()) {
            1 -> addCategory(result)
            2 -> addProductToCategory(result)
            3 -> showProductsInCategory(result)
            4 -> searchProducts(result)
            5 -> showAllCategories(result)
            0 -> {
                println("До свидания!")
                exit = true
            }
            else -> println("Неверный ввод")
        }
    }
}

// 1 Добавление новой категории со списком товаров
fun addCategory(result: MutableList<Pair<String, MutableList<String>>>) {
    print("Введите название новой категории: ")
    val category = readLine() ?: return
    print("Введите товары через запятую: ")
    val products = readLine()?.split(",")?.map { it.trim() }?.toMutableList() ?: mutableListOf()

    result.add(Pair(category, products))
    println("Категория '$category' добавлена с товарами: $products")
}

// 2 Добавление товара в определённую категорию
fun addProductToCategory(result: MutableList<Pair<String, MutableList<String>>>) {
    println("Существующие категории:")
    for (i in result.indices) {
        println("${i + 1}. ${result[i].first}")
    }

    print("Выберите номер категории: ")
    val index = (readLine()?.toIntOrNull() ?: 0) - 1

    if (index in result.indices) {
        print("Введите название товара: ")
        val product = readLine() ?: return
        result[index].second.add(product)
        println("Товар '$product' добавлен в категорию '${result[index].first}'")
    } else {
        println("Неверный номер категории")
    }
}

// 3 Вывод всех товаров из определённой категории
fun showProductsInCategory(result: MutableList<Pair<String, MutableList<String>>>) {
    println("Существующие категории:")
    for (i in result.indices) {
        println("${i + 1}. ${result[i].first}")
    }

    print("Выберите номер категории: ")
    val index = (readLine()?.toIntOrNull() ?: 0) - 1

    if (index in result.indices) {
        val category = result[index].first
        val products = result[index].second
        println("Товары в категории '$category': ${products.joinToString(", ")}")
    } else {
        println("Неверный номер категории")
    }
}

// Поиск товаров по названию (регистр не учитывается)
fun searchProducts(result: MutableList<Pair<String, MutableList<String>>>) {
    print("Введите подстроку для поиска: ")
    val searchText = readLine()?.lowercase() ?: return

    val foundProducts = mutableListOf<Pair<String, String>>()

    for (category in result) {
        val categoryName = category.first
        for (product in category.second) {
            if (product.lowercase().contains(searchText)) {
                foundProducts.add(Pair(categoryName, product))
            }
        }
    }

    if (foundProducts.isNotEmpty()) {
        println("Найденные товары, содержащие '$searchText':")
        for (item in foundProducts) {
            println("  ${item.first}: ${item.second}")
        }
    } else {
        println("Товары, содержащие '$searchText', не найдены")
    }
}

// Дополнительная функция показать все категории и товары
fun showAllCategories(result: MutableList<Pair<String, MutableList<String>>>) {
    println("\nВсе категории и товары:")
    for (category in result) {
        println("${category.first}: ${category.second.joinToString(", ")}")
    }
}