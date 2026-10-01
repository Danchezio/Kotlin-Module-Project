class Archivemenu {
    class ArchiveMenu : Menu("Список архивов") {
        private val archives = mutableListOf<Archive>()

        init {
            addItem("Создать архив") { createArchive() }
        }

        // Экран "Создание архива"
        private fun createArchive() {
            // Просим название, пока пользователь не введёт непустое
            val name = readNotEmptyText("Введите название архива:")

            val archive = Archive(name)
            archives.add(archive)
            addItem(name) { NoteMenu(archive).show() }
            println("Архив \"$name\" создан.")
        }
    }
}

class Archive(val name: String) {

    // Изменяемый список заметок
    // Он нужен изменяемым, чтобы добавлять заметки по ходу работы
    val notes = mutableListOf<Note>()
}