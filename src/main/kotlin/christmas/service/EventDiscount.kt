package christmas.service

import christmas.config.MenuType
import christmas.config.OrderedMenu
import christmas.constant.DiscountConstant
import java.time.LocalDate

class EventDiscount(val day: Int) {
    // 평일 할인
    fun weekdayDessertDiscount(menus: List<OrderedMenu>): Int {
        if (!checkIsWeekend(day)) {
            var discount = 0
            for (menu in menus) {
                if (menu.menu.type == MenuType.APPETIZER) {
                    discount += DiscountConstant.DISCOUNT_WEEKDAY.value
                }
            }
            return discount
        }
        return 0
    }

    // 주말 할인
    fun weekendMainDiscount(menus: List<OrderedMenu>): Int {
        if (checkIsWeekend(day)) {
            var discount = 0
            for (menu in menus) {
                if (menu.menu.type == MenuType.MAIN) {
                    discount += DiscountConstant.DISCOUNT_WEEKEND.value
                }
            }
            return discount
        }
        return 0
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