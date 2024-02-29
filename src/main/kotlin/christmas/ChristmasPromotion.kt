package christmas

import christmas.config.Benefit
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
        val discountList = EventDiscount(day, orderedMenus).calculateDiscount(totalAmount)
        val discountBenefit = calculateDiscountBenefit(discountList)
        val presentBenefit = calculatePresentBenefit(eventPresent)
        val totalBenefit = calculateTotalBenefits(discountBenefit, presentBenefit)
        // 출력
        outputView.printBenefitPreview(day)
        outputView.printMenu(orderedMenus)
        outputView.printTotalAmount(totalAmount)
        outputView.printPresentMenu(eventPresent)
        outputView.printBenefitList(discountList, presentBenefit)
        outputView.printTotalBenefit(totalBenefit)
        outputView.printAmountAfterDiscount(totalAmount, discountBenefit)
        outputView.printBadgeName(totalBenefit)
    }

    private fun calculateTotalAmount(orderedMenus: List<OrderedMenu>): Int {
        var totalAmount = 0
        for (order in orderedMenus) {
            totalAmount += order.menu.price * order.num
        }
        return totalAmount
    }

    private fun calculateDiscountBenefit(discounts: List<Benefit>): Int {
        var benefit = 0
        for (i in discounts) {
            benefit += i.discount
        }
        return benefit
    }

    private fun calculatePresentBenefit(presentNum: Int): Int {
        return presentNum * PresentRule.EVENT_CHAMPAGNE_PRESENT.item.price
    }

    private fun calculateTotalBenefits(discountBenefit: Int, presentBenefit: Int): Int {
        return discountBenefit + presentBenefit
    }
}