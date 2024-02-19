package christmas.extension

fun String.toOrderNameList(): List<String> {
    return this.split(",").map { it.split("-")[0] }
}
fun String.toOrderMap(): Map<String, Int> {
    val result = mutableMapOf<String, Int>()
    this.split(",").forEach {
        val (menuName, num) = it.split("-")
        result[menuName] = num.toInt()
    }
    return result
}
fun String.isNumber(): Boolean {
    return this.all { it.isDigit() }
}