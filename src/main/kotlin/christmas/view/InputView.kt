package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.constants.ViewConstant
import christmas.domain.Order
import christmas.validator.DateValidator
import christmas.validator.MenuValidator

class InputView {

    private val dateValidator = DateValidator
    private val menuValidator = MenuValidator

    // 날짜 입력
    fun readDate(): Int {
        while (true) {
            println(ViewConstant.READ_DATE)
            try {
                val input = Console.readLine()

                dateValidator.validateDate(input)

                return input.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    // 주문 메뉴 입력
    fun readMenu(): List<Order> {
        while (true) {
            println(ViewConstant.READ_MENU)
            try {
                val input = Console.readLine()

                menuValidator.validateMenu(input)

                val menuList = input.split(",")

                menuValidator.validateMenuName(menuList)
                menuValidator.validateMenuCount(menuList)

                return menuList.map {
                    val menu = it.split("-")
                    Order(menu[0], menu[1].toInt())
                }
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

}