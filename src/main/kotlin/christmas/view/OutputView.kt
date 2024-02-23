package christmas.view

import christmas.config.Badge
import christmas.config.Benefit
import christmas.config.OrderedMenu
import christmas.config.PresentRule
import christmas.service.OutputConverter

class OutputView {
    // 혜택 미리보기
    fun printBenefitPreview(day: Int) {
        println(MSG_DATE_BENEFIT_PREVIEW.format(day))
        println()
    }
    // 주문 메뉴
    fun printMenu(orders: List<OrderedMenu>) {
        println(MSG_ORDERED_MENU)
        for (order in orders) {
            println(OUTPUT_ORDERED_MENU.format(order.menu.title, order.num))
        }
        println()
    }
    // 할인 전 총주문 금액
    fun printTotalAmount(amount: Int) {
        println(MSG_TOTAL_AMOUNT_BEFORE_DISCOUNT)
        println(OUTPUT_AMOUNT.format(OutputConverter.decimalAmount(amount)))
        println()
    }
    // 증정 메뉴
    fun printPresentMenu(num: Int) {
        println(MSG_PRESENT_MENU)
        println(findPresentOutput(num))
        println()
    }
    // 혜택 내역
    fun printBenefitList(discounts: List<Benefit>, presentsBenefit: Int) {
        println(MSG_BENEFIT_BREAKDOWN)

        if (discounts.isEmpty()) {
            println("없음")
            println()
            return
        }
        // 할인 이벤트
        for (benefit in discounts) {
            println(OUTPUT_BENEFIT.format(benefit.type.title, OutputConverter.decimalAmount(benefit.discount)))
        }
        // 증정 이벤트
        println(OUTPUT_BENEFIT.format(MSG_PRESENT_EVENT, OutputConverter.decimalAmount(presentsBenefit)))
        println()
    }
    // 총혜택 금액
    fun printTotalBenefit(value: Int) {
        println(MSG_TOTAL_BENEFIT)
        println(OUTPUT_AMOUNT.format(OutputConverter.decimalAmount(value * -1)))
        println()
    }
    // 할인 후 예상 결제 금액
    fun printAmountAfterDiscount(totalAmount: Int, discountAmount: Int) {
        println(MSG_TOTAL_AMOUNT_AFTER_DISCOUNT)
        println(OUTPUT_AMOUNT.format(OutputConverter.decimalAmount(totalAmount - discountAmount)))
        println()
    }
    // 12월 이벤트 배지
    fun printBadgeName(totalBenefit: Int) {
        println(MSG_BADGE)
        println(Badge.findBadgeByAmount(totalBenefit))
    }

    companion object {
        const val MSG_DATE_BENEFIT_PREVIEW = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"

        val MSG_ORDERED_MENU = OutputConverter.convertToTitleFormat("주문 메뉴")
        const val OUTPUT_ORDERED_MENU = "%s %d개"

        val MSG_TOTAL_AMOUNT_BEFORE_DISCOUNT = OutputConverter.convertToTitleFormat("할인 전 총주문 금액")
        const val OUTPUT_AMOUNT = "%s원"
        const val OUTPUT_EMPTY = "없음"

        val MSG_PRESENT_MENU = OutputConverter.convertToTitleFormat("증정 메뉴")
        fun findPresentOutput(num: Int): String {
            return if (num == 0) OUTPUT_EMPTY
            else OUTPUT_ORDERED_MENU.format(PresentRule.EVENT_CHAMPAGNE_PRESENT.item.title, num)
        }

        val MSG_BENEFIT_BREAKDOWN = OutputConverter.convertToTitleFormat("혜택 내역")
        val MSG_PRESENT_EVENT = "증정 이벤트"
        const val OUTPUT_BENEFIT = "%s: -%s원"

        val MSG_TOTAL_BENEFIT = OutputConverter.convertToTitleFormat("총혜택 금액")
        val MSG_TOTAL_AMOUNT_AFTER_DISCOUNT = OutputConverter.convertToTitleFormat("할인 후 예상 결제 금액")
        val MSG_BADGE = OutputConverter.convertToTitleFormat("12월 이벤트 배지")
    }
}