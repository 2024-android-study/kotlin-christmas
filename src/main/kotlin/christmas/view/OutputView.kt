package christmas.view

import christmas.config.OrderedMenu
import christmas.service.OutputConverter

class OutputView {
    fun printBenefitPreview(day: Int) {
        println(MSG_DATE_BENEFIT_PREVIEW.format(day))
        println()
    }

    fun printMenu(orders: List<OrderedMenu>) {
        println(MSG_ORDERED_MENU)
        for (order in orders) {
            println(OUTPUT_ORDERED_MENU.format(order.menu.menu, order.num))
        }
        println()
    }

    fun printTotalAmount(amount: Int) {
        println(MSG_TOTAL_AMOUNT_BEFORE_DISCOUNT)
        println(OUTPUT_TOTAL_AMOUNT_BEFORE_DISCOUNT.format(OutputConverter.decimalAmount(amount)))
        println()
    }

    companion object {
        const val MSG_DATE_BENEFIT_PREVIEW = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"

        val MSG_ORDERED_MENU = OutputConverter.convertToTitleFormat("주문 메뉴")
        const val OUTPUT_ORDERED_MENU = "%s %d개"

        val MSG_TOTAL_AMOUNT_BEFORE_DISCOUNT = OutputConverter.convertToTitleFormat("할인 전 총주문 금액")
        const val OUTPUT_TOTAL_AMOUNT_BEFORE_DISCOUNT = "%s원"
    }
}