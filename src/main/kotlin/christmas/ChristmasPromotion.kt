package christmas

import christmas.config.OrderedMenu
import christmas.config.PresentRule
import christmas.service.EventDiscount
import christmas.service.EventPresent
import christmas.view.InputView
import christmas.view.OutputView

class ChristmasPromotion {

    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        // 입력
        val day = inputView.readVisitDate()
        val orderedMenus = inputView.readOrder()
        // 계산
        val totalAmount = calculateTotalAmount(orderedMenus)
        val eventPresent = EventPresent(totalAmount).champagnePresent()
        val discountBenefit = EventDiscount(day, orderedMenus).calculateDiscount(totalAmount)
        // 출력
        outputView.printBenefitPreview(day)
        outputView.printMenu(orderedMenus)
        outputView.printTotalAmount(totalAmount)
        outputView.printPresentMenu(eventPresent)
        outputView.printBenefitList(discountBenefit, calculatePresentBenefit(eventPresent))
    }

    private fun calculateTotalAmount(orderedMenus: List<OrderedMenu>): Int {
        var totalAmount = 0
        for (order in orderedMenus) {
            totalAmount += order.menu.price * order.num
        }
        return totalAmount
    }

    private fun calculatePresentBenefit(presentNum: Int): Int {
        return presentNum * PresentRule.EVENT_CHAMPAGNE_PRESENT.item.price
    }
}