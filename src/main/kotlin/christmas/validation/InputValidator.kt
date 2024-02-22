package christmas.validation

import christmas.constant.error.DateError

object InputValidator {
    fun checkDayValidation(input: String) {
        DateError.requireIsNum(input)
        DateError.isValidDay(input.toInt())
    }


}