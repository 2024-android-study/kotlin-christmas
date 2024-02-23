package christmas

import christmas.config.BenefitBreakdown
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
        val presentBenefit = calculatePresentBenefit(eventPresent)
        val totalBenefit = calculateTotalBenefits(discountBenefit, presentBenefit)
        // 출력
        outputView.printBenefitPreview(day)
        outputView.printMenu(orderedMenus)
        outputView.printTotalAmount(totalAmount)
        outputView.printPresentMenu(eventPresent)
        outputView.printBenefitList(discountBenefit, presentBenefit)
        outputView.printTotalBenefit(totalBenefit)
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

    private fun calculateTotalBenefits(discounts: List<BenefitBreakdown>, presentBenefit: Int): Int {
        var totalBenefits = presentBenefit
        for (i in discounts) {
            totalBenefits += i.discount
        }
        return totalBenefits
    }
}