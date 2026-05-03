fun main() {
    val products = mutableMapOf(
        "Apple" to 50.0,
        "Banana" to 30.0,
        "Milk" to 80.0,
        "Meat" to 250.0,
        "Bread" to 40.0,
        "Mango" to 120.0
    )

    var exit = false
    while (!exit) {
        println("\n--- Меню ---")
        println("1. Вывести все товары и их цены")
        println("2. Добавить новый товар")
        println("3. Рассчитать сумму всех товаров")
        println("4. Увеличить цены товаров на 10% (название начинается с М)")
        println("0. Выход")
        print("Выберите действие: ")

        when (readLine()?.toIntOrNull()) {
            1 -> showAllProducts(products)
            2 -> addProduct(products)
            3 -> calculateTotalSum(products)
            4 -> increasePricesForM(products)
            0 -> {
                println("До свидания!")
                exit = true
            }
            else -> println("Неверный ввод")
        }
    }
}

// 1 Вывод всех товаров и их цен
fun showAllProducts(products: MutableMap<String, Double>) {
    println("\nСписок товаров и цен:")
    for ((name, price) in products) {
        println("$name: ${price} руб.")
    }
}

// 2 Добавление нового товара
fun addProduct(products: MutableMap<String, Double>) {
    print("Введите название товара: ")
    val name = readLine() ?: return
    print("Введите цену товара: ")
    val price = readLine()?.toDoubleOrNull()

    if (price != null && price > 0) {
        products[name] = price
        println("Товар '$name' добавлен с ценой ${price} руб.")
    } else {
        println("Некорректная цена")
    }
}

// 3 Расчет суммы товаров
fun calculateTotalSum(products: MutableMap<String, Double>) {
    var total = 0.0
    for (price in products.values) {
        total += price
    }
    println("Общая сумма всех товаров: ${total} руб.")
}

// 4 Увеличение цен товаров на 10%, название которых начинается с буквы M (русской или английской)
fun increasePricesForM(products: MutableMap<String, Double>) {
    var count = 0
    for ((name, price) in products) {
        if (name.uppercase().startsWith("M")) {
            val newPrice = price * 1.1
            products[name] = newPrice
            println("Цена товара '$name' увеличена с ${price} до ${newPrice} руб.")
            count++
        }
    }
    if (count == 0) {
        println("Товары на букву M не найдены")
    }
}