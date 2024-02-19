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

    fun getMenu(): String {
        println(ViewConst.INPUT_DATE)
        val input = Console.readLine()
        InputValidator().validateMenu(input)
        return input
    }
}