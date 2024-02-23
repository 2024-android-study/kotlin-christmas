package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.config.OrderedMenu
import christmas.service.InputConverter
import christmas.validation.InputValidator

class InputView {

    fun readVisitDate(): Int {
        println(MSG_PLANNER_INTRODUCE)
        while (true) {
            try {
                println(INPUT_VISITDAY)
                val input = Console.readLine()
                InputValidator.checkDayValidation(input)
                return input.toInt()
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    fun readOrder(): List<OrderedMenu> {
        while (true) {
            try {
                println(INPUT_MENU_AND_NUM)
                val input = Console.readLine()
                return InputConverter.convertOrderToMenuList(input)
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    companion object {
        const val MSG_PLANNER_INTRODUCE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
        const val INPUT_VISITDAY = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
        const val INPUT_MENU_AND_NUM = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"
    }
}