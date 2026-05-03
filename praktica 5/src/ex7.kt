import kotlin.random.Random

fun main() {
    println("\n=== Задание 7. Камень, ножницы, бумага ===")
    gameLoop()
}

// Основная игровая рекурсивная функция
fun gameLoop(score: Int = 0, computerScore: Int = 0, rounds: Int = 0) {
    print("\nВведите СТАРТ для начала игры или СТОП для выхода: ")
    val command = readLine()?.uppercase() ?: ""

    when (command) {
        "СТАРТ" -> {
            println("\nИгра началась!")
            playRound(score, computerScore, rounds)
        }
        "СТОП" -> {
            println("\n=== ИТОГИ ИГРЫ ===")
            println("Сыграно раундов: $rounds")
            println("Ваш счет: $score")
            println("Счет компьютера: $computerScore")
            when {
                score > computerScore -> println("ПОБЕДА! Вы выиграли!")
                score < computerScore -> println("ПОРАЖЕНИЕ! Компьютер выиграл!")
                else -> println("НИЧЬЯ!")
            }
            println("Спасибо за игру!")
            return
        }
        else -> {
            println("Неверная команда. Введите СТАРТ или СТОП")
            gameLoop(score, computerScore, rounds)
        }
    }
}

// Рекурсивная функция для одного раунда
fun playRound(score: Int, computerScore: Int, rounds: Int) {
    val choices = mapOf(
        1 to "камень",
        2 to "ножницы",
        3 to "бумага"
    )

    println("\n--- Раунд ${rounds + 1} ---")
    println("Выберите элемент:")
    println("1 - Камень")
    println("2 - Ножницы")
    println("3 - Бумага")
    println("0 - Завершить игру")

    print("Ваш выбор: ")
    val input = readLine()
    val playerChoiceNum = input?.toIntOrNull()

    if (playerChoiceNum == null) {
        println("Ошибка: введите число!")
        playRound(score, computerScore, rounds)
        return
    }

    if (playerChoiceNum == 0) {
        gameLoop(score, computerScore, rounds)
        return
    }

    if (playerChoiceNum !in 1..3) {
        println("Неверный выбор! Попробуйте снова.")
        playRound(score, computerScore, rounds)
        return
    }

    val playerChoice = choices[playerChoiceNum]!!
    val computerChoiceNum = Random.nextInt(1, 4)
    val computerChoice = choices[computerChoiceNum]!!

    println("Вы выбрали: $playerChoice")
    println("Компьютер выбрал: $computerChoice")

    // Исправление: передаем Int, а не Int?
    val result = determineWinner(playerChoiceNum, computerChoiceNum)
    var newScore = score
    var newComputerScore = computerScore

    when (result) {
        "win" -> {
            println("Вы выиграли этот раунд!")
            newScore++
        }
        "lose" -> {
            println("Компьютер выиграл этот раунд!")
            newComputerScore++
        }
        else -> {
            println("Ничья!")
        }
    }

    println("Счет: Вы $newScore : $newComputerScore Компьютер")

    // Рекурсивный вызов для следующего раунда
    playRound(newScore, newComputerScore, rounds + 1)
}

fun determineWinner(player: Int, computer: Int): String {
    return when {
        player == computer -> "draw"
        (player == 1 && computer == 2) ||
                (player == 2 && computer == 3) ||
                (player == 3 && computer == 1) -> "win"
        else -> "lose"
    }
}