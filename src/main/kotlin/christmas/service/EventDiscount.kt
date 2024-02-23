package christmas.service

import christmas.config.*
import christmas.constant.EventConstant
import java.time.LocalDate

class EventDiscount(val day: Int, val menus: List<OrderedMenu>) {

    fun calculateDiscount(totalAmount: Int): List<Benefit> {
        val benefitList = mutableListOf<Benefit>()
        if (totalAmount >= EventConstant.EVENT_CRITERIA_AMOUNT.value) {
            val calList = listOf(christmasDdayDiscount(), weekdayDessertDiscount(), weekendMainDiscount(), specialDiscount())
            val typeList = listOf(DiscountRule.DISCOUNT_CHRISTMAS_DDAY, DiscountRule.DISCOUNT_WEEKDAY, DiscountRule.DISCOUNT_WEEKEND, DiscountRule.DISCOUNT_SPECIAL)
            calList.forEachIndexed { index, amount ->
                if (amount != 0) benefitList.add(Benefit(typeList[index], calList[index]))
            }
        }
        return benefitList
    }

    // 크리스마스 할인
    fun christmasDdayDiscount(): Int {
        if (day <= 25) {
            return (EventConstant.CHRISTMAS_START_AMOUNT.value + DiscountRule.DISCOUNT_CHRISTMAS_DDAY.value * (day - 1))
        }
        return 0
    }

    // 평일 할인
    fun weekdayDessertDiscount(): Int {
        if (!checkIsWeekend(day)) {
            return weekDiscount(false)
        }
        return 0
    }

    // 주말 할인
    fun weekendMainDiscount(): Int {
        if (checkIsWeekend(day)) {
            return weekDiscount(true)
        }
        return 0
    }

    fun weekDiscount(isWeekend: Boolean): Int {
        var discount = 0
        val discountValue = if (isWeekend) DiscountRule.DISCOUNT_WEEKEND.value else DiscountRule.DISCOUNT_WEEKDAY.value
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
            return (DiscountRule.DISCOUNT_SPECIAL.value)
        }
        return 0
    }

    companion object {
        val calendarStarList = listOf(3, 10, 17, 24, 25, 31)
    }
}