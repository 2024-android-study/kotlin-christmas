package christmas.view

import christmas.constants.NumConstant
import christmas.constants.ViewConstant
import christmas.domain.Discount
import christmas.domain.Menu
import christmas.domain.Order

class OutputView {

    fun printStart() {
        println(ViewConstant.START_EVENT)
    }

    fun printEventPreviewTitle(date: Int) {
        println(ViewConstant.EVENT_PREVIEW.format(date))
    }

    // 주문 메뉴 출력
    fun printMenu(orderMenu: List<Order>) {
        println(ViewConstant.ORDER_MENU_TITLE)

        orderMenu.forEach {
            println(ViewConstant.ORDER_MENU_CONTENT.format(it.menuName, it.count))
        }
    }

    // 할인 전 총주문 금액 출력
    fun printTotalPrice(price: Int) {
        println(ViewConstant.ORDER_TOTAL_PRICE_TITLE)
        println(ViewConstant.PRICE.format(price))
    }

    // 증정 메뉴 출력
    fun printPresentMenu(present: Boolean) {
        println(ViewConstant.PRESENT_TITLE)

        if (present) {
            println(ViewConstant.ORDER_MENU_CONTENT.format(Menu.CHAMPAGNE.menuName, 1))
        } else {
            println(ViewConstant.NONE)
        }
    }

    // 혜택 내역 출력
    fun printBenefit(history: Map<Discount, Int>, present: Boolean) {
        println(ViewConstant.BENEFIT_TITLE)

        if (history.isEmpty() && !present) {
            println(ViewConstant.NONE)
        }

        history.forEach { (event, benefit) ->
            println(ViewConstant.BENEFIT_CONTENT.format(event.eventName, benefit))
        }

        if (present) {
            println(ViewConstant.BENEFIT_CONTENT.format(ViewConstant.PRESENT_EVENT_TITLE, NumConstant.PRESENT_DISCOUNT))
        }
    }

    // 총혜택 금액 출력
    fun printBenefitPrice(price: Int) {
        println(ViewConstant.BENEFIT_PRICE_TITLE)
        println(ViewConstant.PRICE.format(price))
    }

    // 할인 후 예상 금액
    fun printDiscountPrice(price: Int) {
        println(ViewConstant.DISCOUNT_PRICE_TITLE)
        println(ViewConstant.PRICE.format(price))
    }

    //  12월 이벤트 배지 출력
    fun printEventBadge(badge: String) {
        println(ViewConstant.EVENT_BADGE_TITLE)
        println(badge)
    }

}