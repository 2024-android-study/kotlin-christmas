package christmas

import christmas.service.EventDiscount
import christmas.view.InputView

class ChristmasPromotion {

    private val inputView = InputView()

    fun run() {
        val day = inputView.readVisitDate()
        val orderedMenu = inputView.readOrder()
        println(orderedMenu)
        val eventDiscount = EventDiscount(day)
    }
}