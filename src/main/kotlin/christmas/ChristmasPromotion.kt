package christmas

import christmas.service.EventDiscount
import christmas.view.InputView
import christmas.view.OutputView

class ChristmasPromotion {

    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        // 입력
        val day = inputView.readVisitDate()
        val orderedMenus = inputView.readOrder()
        val eventDiscount = EventDiscount(day)
        // 출력
        outputView.printBenefitPreview(day)
        outputView.printMenu(orderedMenus)
    }
}