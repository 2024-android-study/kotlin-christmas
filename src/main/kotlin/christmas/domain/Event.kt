package christmas.domain

import christmas.constants.NumConstant
import christmas.constants.ViewConstant

class Event(
    private val date: Int,
    private val orderMenu: List<Order>,
    private val totalPrice: Int
) {

    private val discountHistory = mutableMapOf<Discount, Int>()
    private var present = false

    init {
        Discount.entries.forEach {
            discountHistory[it] = NumConstant.NO_DISCOUNT
        }
    }

    fun getDiscountHistory(): Map<Discount, Int> {
        return discountHistory
    }

    fun getPresent(): Boolean {
        return present
    }

    fun getBenefitPrice(): Int {
        if (present) {
            return discountHistory.values.sum() + Menu.CHAMPAGNE.price
        }

        return discountHistory.values.sum()
    }

    fun getDiscountApplyPrice(): Int {
        return totalPrice - discountHistory.values.sum()
    }

    fun applyEvent() {
        discountHistory[Discount.CHRISTMAS] = applyChristmasDiscount()
        discountHistory[Discount.WEEKDAY] = applyWeekdayDiscount()
        discountHistory[Discount.WEEKEND] = applyWeekendDiscount()
        discountHistory[Discount.SPECIAL] = applySpecialDiscount()

        present = checkPresentMenu()
    }

    // 샴페인 증정 여부
    private fun checkPresentMenu(): Boolean {
        return totalPrice >= NumConstant.PRESENT_PRICE
    }

    // 크리스마스 디데이 할인 적용
    private fun applyChristmasDiscount(): Int {
        if (date <= NumConstant.CHRISTMAS_DAY) {
            val discount = (date - 1) * NumConstant.DAILY_DISCOUNT
            return NumConstant.FIRST_DAILY_DISCOUNT + discount
        }

        return NumConstant.NO_DISCOUNT
    }

    // 평일 할인 적용
    private fun applyWeekdayDiscount(): Int {
        if (date in EventDay.WEEKDAY.dates) {
            val dessertMenuCount = orderMenu
                .filter { it.menuName in Menu.getMenu(ViewConstant.CATEGORY_DESSERT) }
                .sumOf { it.count }

            return dessertMenuCount * NumConstant.WEEK_DISCOUNT
        }

        return NumConstant.NO_DISCOUNT
    }

    // 주말 할인 적용
    private fun applyWeekendDiscount(): Int {
        if (date in EventDay.WEEKEND.dates) {
            val mainMenuCount = orderMenu
                .filter { it.menuName in Menu.getMenu(ViewConstant.CATEGORY_MAIN) }
                .sumOf { it.count }

            return mainMenuCount * NumConstant.WEEK_DISCOUNT
        }

        return NumConstant.NO_DISCOUNT
    }

    // 특별 할인 적용
    private fun applySpecialDiscount(): Int {
        if (date in EventDay.SPECIAL.dates) {
            return NumConstant.SPECIAL_DISCOUNT
        }

        return NumConstant.NO_DISCOUNT
    }
}