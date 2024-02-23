package christmas

import christmas.config.OrderedMenu
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
        // 계산
        val totalAmount = calculateTotalAmount(orderedMenus)
        val eventDiscount = EventDiscount(day)
        // 출력
        outputView.printBenefitPreview(day)
        outputView.printMenu(orderedMenus)
        outputView.printTotalAmount(totalAmount)
    }

    private fun calculateTotalAmount(orderedMenus: List<OrderedMenu>): Int {
        var totalAmount = 0
        for (order in orderedMenus) {
            totalAmount += order.menu.price * order.num
        }
        return totalAmount
    }
}