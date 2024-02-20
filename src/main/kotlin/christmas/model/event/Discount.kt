package christmas.model.event

import christmas.config.menu.Desert
import christmas.config.menu.MainDish
import christmas.config.menu.Menu

class Discount : Event() {

    fun applyChristmasDDay(date: Int): Int {
        val defaultAmount = 1000
        return if (date == 1) {
            defaultAmount
        } else {
            defaultAmount + ((100) * date - 1)
        }
    }

    fun applyWeekday(menu: Menu, count: Int): Int {
        return when (menu) {
            is Desert -> 2023 * count
            else -> 0
        }
    }

    fun applyWeekend(menu: Menu, count: Int): Int {
        return when (menu) {
            is MainDish -> 2023 * count
            else -> 0
        }
    }

    fun applySpecial(): Int {
        return 1000
    }
}