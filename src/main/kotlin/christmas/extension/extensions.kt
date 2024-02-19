package christmas.extension

import christmas.constant.Menu

fun String.toOrderNameList(): List<String> {
    return this.split(",").map { it.split("-")[0] }
}
fun String.toOrderMap(): Map<String, Int> {
    val result = mutableMapOf<String, Int>()
    this.split(",").forEach {
        val (menuName, amount) = it.split("-")
        result[menuName] = amount.toInt()
    }
    return result
}
fun String.isNumber(): Boolean {
    return this.all { it.isDigit() }
}

fun String.getMenu(): Menu {
    return Menu.values().first { it.menuName == this}
}