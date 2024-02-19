package christmas

import christmas.constant.Badge
import christmas.constant.ViewConst
import christmas.extension.toOrderMap
import christmas.view.InputView
import christmas.view.OutputView

class PromotionController {
    private val output = OutputView()
    private val input = InputView()
    private val calculator = PromotionCalculator()
    fun run() {
        val date = input.getDate()
        val orders = input.getOrder().toOrderMap()

        printBenefits(date, orders)
    }

    private fun printBenefits(date: Int, orders: Map<String, Int>) {
        with(output) {
            val beforePrice = calculator.getBeforeOrderPrice(orders)
            val benefitHistory = calculator.getBenefitHistory(date, orders, getGift(beforePrice))
            val wholeBenefit = calculator.getWholeBenefit(benefitHistory)

            printOrder(date, orders)
            printPriceBefore(beforePrice)
            printGift(getGift(beforePrice))
            printBenefitHistory(benefitHistory)
            printWholeBenefit(wholeBenefit)
            printPriceAfter(beforePrice - wholeBenefit)
            printBadge(getBadge(wholeBenefit))
        }
    }
    private fun getGift(price: Int): Map<String, Int> {
        return if(price >= GIFT_MIN) mapOf(GIFT to GIFT_NUM)
        else emptyMap()
    }

    private fun getBadge(benefit: Int): String {
        return when {
            benefit >= Badge.BADGE_FIRST.price -> Badge.BADGE_FIRST.badgeName
            benefit >= Badge.BADGE_SECOND.price -> Badge.BADGE_SECOND.badgeName
            benefit >= Badge.BADGE_THIRD.price -> Badge.BADGE_THIRD.badgeName
            else -> ViewConst.OUTPUT_NONE
        }
    }

    companion object {
        const val GIFT_MIN = 120000
        const val GIFT = "샴페인"
        const val GIFT_NUM = 1
    }
}