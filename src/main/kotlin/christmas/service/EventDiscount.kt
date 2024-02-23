package christmas.service

import christmas.config.EventType
import christmas.config.MenuType
import christmas.config.OrderedMenu
import java.time.LocalDate

class EventDiscount(val day: Int) {

    // 평일 할인
    fun weekdayDessertDiscount(menus: List<OrderedMenu>): Int {
        if (!checkIsWeekend(day)) {
            return weekDiscount(menus, false)
        }
        return 0
    }

    // 주말 할인
    fun weekendMainDiscount(menus: List<OrderedMenu>): Int {
        if (checkIsWeekend(day)) {
            return weekDiscount(menus, true)
        }
        return 0
    }

    fun weekDiscount(menus: List<OrderedMenu>, isWeekend: Boolean): Int {
        var discount = 0
        val discountValue = if (isWeekend) EventType.Event_WEEKEND.value else EventType.Event_WEEKDAY.value
        val menuType = if (isWeekend) MenuType.MAIN else MenuType.APPETIZER

        for (menu in menus) {
            if (menu.menu.type == menuType) {
                discount += discountValue
            }
        }
        return discount
    }

    private fun checkIsWeekend(day: Int): Boolean {
        val date = LocalDate.of(2023, 12, day);
        println(date);  // 2023-12-25
        val dayOfWeek = date.getDayOfWeek()
        val dayOfWeekNumber = dayOfWeek.getValue()
        return when (dayOfWeekNumber) {
            6, 7 -> true // 주말
            else -> false // 주중
        }
    }
}