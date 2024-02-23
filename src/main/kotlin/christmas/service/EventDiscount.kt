package christmas.service

import christmas.config.EventRule
import christmas.config.MenuType
import christmas.config.OrderedMenu
import christmas.constant.DiscountConstant
import java.time.LocalDate

class EventDiscount(val day: Int) {
    // 크리스마스 할인
    fun christmasDdayDiscount(): Int {
        if (day <= 25) {
            return (DiscountConstant.CHRISTMAS_START_AMOUNT.value + EventRule.EVENT_CHRISTMAS_DDAY.value * (day - 1))
        }
        return 0
    }

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
        val discountValue = if (isWeekend) EventRule.EVENT_WEEKEND.value else EventRule.EVENT_WEEKDAY.value
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

    // 특별 할인
    fun specialDiscount(): Int {
        if (calendarStarList.contains(day)) {
            return (EventRule.EVENT_SPECIAL.value)
        }
        return 0
    }

    companion object {
        val calendarStarList = listOf(3, 10, 17, 24, 25, 31)
    }
}