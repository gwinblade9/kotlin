data class Sale(
    val productName: String,
    val category: String,
    val quantity: Int
)

fun main() {
    val sales = arrayListOf(
        Sale("Apple", "Fruits", 10),
        Sale("Banana", "Fruits", 5),
        Sale("Carrot", "Vegetables", 8),
        Sale("Broccoli", "Vegetables", 12),
        Sale("Chicken", "Meat", 15),
        Sale("Beef", "Meat", 20),
        Sale("Orange", "Fruits", 7)
    )

    val result = calculateTotalByCategory(sales)
    println("Результат: $result")
}

fun calculateTotalByCategory(sales: ArrayList<Sale>): List<Pair<String, Int>> {
    val categoryMap = mutableMapOf<String, Int>()

    for (sale in sales) {
        categoryMap[sale.category] = categoryMap.getOrDefault(sale.category, 0) + sale.quantity
    }

    return categoryMap.map { Pair(it.key, it.value) }
}