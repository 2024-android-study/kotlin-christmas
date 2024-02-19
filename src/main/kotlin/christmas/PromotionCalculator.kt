package christmas

import christmas.constant.Menu
import christmas.extension.getMenu

class PromotionCalculator {
    fun getBeforeOrderPrice(orders: Map<String, Int>): Int {
        return orders.entries.sumOf { (menuName, amount) ->
            menuName.getMenu().price * amount
        }
    }
    fun getBenefitHistory(date: Int, orders: Map<String, Int>, gift: Map<String, Int>): Map<String, Int> {
        // 할인 및 이벤트 계산 결과를 담을 맵
        val benefits = mutableMapOf<String, Int>()
        // 크리스마스 할인
        benefits.putAll(calculateChristDiscount(date))
        // 주말 할인 또는 평일 할인
        benefits.putAll(calculateDayDiscount(date, orders))
        // 특별 할인
        if(date % 7 == SPECIAL_DATE_REST || date % 7 == CHRIST) benefits[SPECIAL_DISCOUNT] = SPECIAL_BENEFIT
        // 증정 이벤트
        if (gift.isNotEmpty()) benefits[GIFT_DISCOUNT] = GIFT_BENEFIT

        return benefits
    }

    fun getWholeBenefit(benefits: Map<String, Int>): Int {
        return benefits.entries.sumOf { it.value }
    }


    private fun calculateChristDiscount(date: Int): Map<String, Int> {
        return if(date < CHRIST) mapOf(CHRIST_DISCOUNT to CHRIST_DEFAULT + (CHRIST - date) * CHRIST_UNIT) else emptyMap()
    }

    private fun calculateDayDiscount(date: Int, orders: Map<String, Int>): Map<String, Int> {
        val isWeekend = date % 7 == WEEKEND_DAY_FIRST || date % 7 == WEEKEND_DAY_SECOND
        val dayType = if (isWeekend) WEEKEND_DISCOUNT else WEEKDAY_DISCOUNT
        val discountCategory = if (isWeekend) MAIN else DESSERT

        val benefit = orders.entries.sumOf { (menuName, amount) ->
            menuName.getMenu().let { menu ->
                if (menu.category == discountCategory) DAY_BENEFIT * amount else 0
            }
        }

        return if (benefit > 0) mapOf(dayType to benefit) else emptyMap()
    }


    companion object {
        const val CHRIST_DISCOUNT = "크리스마스 디데이 할인"
        const val CHRIST = 25
        const val CHRIST_DEFAULT = 1000
        const val CHRIST_UNIT = 100

        const val WEEKDAY_DISCOUNT = "평일 할인"
        const val WEEKEND_DISCOUNT = "주말 할인"
        const val WEEKEND_DAY_FIRST = 1
        const val WEEKEND_DAY_SECOND = 2
        const val DAY_BENEFIT = 2023

        const val SPECIAL_DISCOUNT = "특별 할인"
        const val SPECIAL_DATE_REST = 3
        const val SPECIAL_BENEFIT = 1000

        const val GIFT_DISCOUNT = "증정 이벤트"
        const val GIFT_BENEFIT = 25000

        const val DESSERT = "디저트"
        const val MAIN = "메인"
    }
}