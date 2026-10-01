class Note(val name: String, val text: String)
// Заголовок берём из названия архива и передаём в конструктор родителя Menu.
class NoteMenu(private val archive: Archive) : Menu("Список заметок архива \"${archive.name}\"") {

    init {
        addItem("Создать заметку") { createNote() }
        // Меню создаётся заново при каждом входе в архив, поэтому добавляем в него заметки, которые в архиве уже есть.
        for (note in archive.notes) {
            addItem(note.name) { NoteScreen(note).show() }
        }
    }

    private fun createNote() {
        val name = readNotEmptyText("Введите название заметки:")
        val text = readNotEmptyText("Введите текст заметки:")

        val note = Note(name, text)
        archive.notes.add(note)

        // Добавляем заметку в текущее меню, чтобы она сразу появилась в списке.
        addItem(name) { NoteScreen(note).show() }

        println("Заметка \"$name\" создана.")
    }
}
class NoteScreen(private val note: Note) : Menu("Заметка \"${note.name}\"") {

    init {

        addItem("Показать текст заметки") {
            println()
            println(note.text)
        }
    }
}