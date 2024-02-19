package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.constant.ViewConst
import christmas.validation.InputValidator

class InputView {
    fun getDate(): Int {
        println(ViewConst.INPUT_DATE)
        val input = Console.readLine()
        InputValidator().validateDate(input)
        return input.toInt()
    }

    fun getOrder(): String {
        println(ViewConst.INPUT_ORDER)
        val input = Console.readLine()
        InputValidator().validateOrder(input)
        return input
    }
}