
//Ввод с клавиатуры находится в этом файле, чтобы не повторятся.
import java.util.Scanner

// Один общий Scanner на всю программу.
private val scanner = Scanner(System.`in`)
fun readUserInput(): String {
    return scanner.nextLine()
}

// Просит пользователя ввести текст
fun readNotEmptyText(message: String): String {
    // Начинаем с пустой строки, чтобы цикл гарантированно выполнится хотя бы один раз
    var text = ""

    while (text.isBlank()) {
        println(message)
        text = readUserInput()
        // Сообщение об ошибке показываем только если ввод оказался пустым.
        if (text.isBlank()) {
            println("Ошибка: значение не может быть пустым. Попробуйте ещё раз.")
        }
    }
    return text.trim()
}