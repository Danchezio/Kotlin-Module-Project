
// Общий класс для всех экранов с выбором пункта (архивы, заметки, экран заметки).
// Здесь находится вся логика
// Остальные только наследуются от этого класса и добавляют свои пункты.
class MenuItem(val title: String, val action: () -> Unit)

open class Menu(private val title: String) {

    // Изменяемый список пунктов.
    private val items = mutableListOf<MenuItem>()

    // Добавляет пункт в меню.
    protected fun addItem(title: String, action: () -> Unit) {
        items.add(MenuItem(title, action))
    }

    // Показывает меню и обрабатывает выбор пользователя.
    fun show() {
        var isRunning = true

        while (isRunning) {
            printMenu()

            // Читаем ввод и превращаем его в число.
            val number = readUserInput().trim().toIntOrNull()
            // Обрабатывает ошибки
            if (number == null) {
                println("Ошибка: нужно ввести цифру.")
            } else if (number < 0 || number > items.size) {
                println("Ошибка: цифры $number нет в меню. Введите один из пунктов списка.")
            } else if (number == items.size) {
                isRunning = false
            } else {
                items[number].action()
            }
        }
    }

    // Печатает заголовок и все пункты с номерами.
    private fun printMenu() {
        println()
        println("$title:")

        // Пункты нумеруются с нуля: 0
        for (i in items.indices) {
            println("$i. ${items[i].title}")
        }

        // "Выход" всегда последний
        println("${items.size}. Выход")
        println("Введите номер пункта:")
    }
}