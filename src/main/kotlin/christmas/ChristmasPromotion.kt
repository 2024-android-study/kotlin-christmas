package christmas

import christmas.view.InputView

class ChristmasPromotion {

    private val inputView = InputView()

    fun run() {
        val date = inputView.readVisitDate()
        // println("방문일자: $date")
    }
}