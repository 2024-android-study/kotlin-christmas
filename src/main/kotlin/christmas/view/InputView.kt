package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.constant.ViewConst
import christmas.extension.toOrderMap
import christmas.validation.InputValidator

class InputView {
    fun getDate(): Int {
        println(ViewConst.INPUT_DATE)
        val input = Console.readLine()
        InputValidator().validateDate(input)
        return input.toInt()
    }

    fun getOrder(): Map<String, Int> {
        println(ViewConst.INPUT_ORDER)
        val input = Console.readLine()
        InputValidator().apply {
            validateOrder(input)
            validateOnlyDrink(input.toOrderMap())
        }
        return input.toOrderMap()
    }
}