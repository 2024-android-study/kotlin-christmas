package christmas

import christmas.view.InputView

class ChristmasPromotion {

    private val inputView = InputView()

    fun run() {
        val date = inputView.readVisitDate()
        val orderedMenu = inputView.readOrder()
        println(orderedMenu)
    }
}