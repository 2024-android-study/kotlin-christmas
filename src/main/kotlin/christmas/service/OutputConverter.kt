package christmas.service

object OutputConverter {
    fun convertToTitleFormat(title: String): String {
        return ("<" + title + ">")
    }
}