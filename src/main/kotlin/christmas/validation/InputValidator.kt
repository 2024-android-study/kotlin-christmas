package christmas.validation

import christmas.PromotionController
import christmas.constant.Menu
import christmas.error.DateError
import christmas.error.OrderError
import christmas.extension.getMenu
import christmas.extension.isNumber
import christmas.extension.toOrderMap
import christmas.extension.toOrderNameList

class InputValidator {
    fun validateDate(input: String) {
        require(input.isNumber()) { DateError.NOT_NUMBER.message }
        require(input.toInt() in START_DATE..END_DATE) { DateError.OUT_OF_RANGE.message }
    }

    fun validateOrder(input: String) {
        require(isValidateOrderFormat(input)) { OrderError.INVALID_FORMAT.message }
        require(Menu.isValidMenu(input.toOrderNameList())) { OrderError.NOT_IN_MENU.message }
        require(isDuplicateOrder(input.toOrderNameList())) { OrderError.DUPLICATE_MENU.message }
    }

    fun validateOnlyDrink(orders: Map<String, Int>) {
        require(orders.all { it.key.getMenu().category == PromotionController.DRINK }) { OrderError.ONLY_DRINK.message }
    }

    private fun isValidateOrderFormat(input: String): Boolean {
        val pattern = "^([가-힣a-zA-Z]+-[1-9]\\d*,)*([가-힣a-zA-Z]+-[1-9]\\d*)$".toRegex()
        return pattern.matches(input)
    }

    private fun isDuplicateOrder(menuNames: List<String>): Boolean {
        return menuNames.size == menuNames.toSet().size
    }

    companion object {
        const val START_DATE = 1
        const val END_DATE = 31
    }
}