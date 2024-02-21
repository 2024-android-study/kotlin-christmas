package christmas.controller

import christmas.constants.NumConstant
import christmas.domain.*
import christmas.view.InputView
import christmas.view.OutputView

class ChristmasController {

    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        outputView.printStart()

        val date = inputView.readDate()
        val orderMenu = inputView.readMenu()

        val price = Price(orderMenu)
        val totalPrice = price.getTotalPrice()

        printOrderHistory(date, orderMenu, totalPrice)
        previewBenefit(date, orderMenu, totalPrice)
    }

    private fun printOrderHistory(date: Int, orderMenu: List<Order>, totalPrice: Int) {
        outputView.printEventPreviewTitle(date)

        outputView.printMenu(orderMenu)
        outputView.printTotalPrice(totalPrice)
    }

    private fun previewBenefit(date: Int, orderMenu: List<Order>, totalPrice: Int) {
        val event = Event(date, orderMenu, totalPrice)

        if (totalPrice >= NumConstant.MIN_PRICE) {
            event.applyEvent()
        }

        outputView.printPresentMenu(event.getPresent())
        outputView.printBenefit(event.getDiscountHistory().filter { it.value != NumConstant.NO_DISCOUNT }, event.getPresent())

        val benefitPrice = event.getBenefitPrice()

        outputView.printBenefitPrice(NumConstant.NO_DISCOUNT - benefitPrice)
        outputView.printDiscountPrice(event.getDiscountApplyPrice())
        outputView.printEventBadge(Badge.grantBadge(benefitPrice))
    }

}