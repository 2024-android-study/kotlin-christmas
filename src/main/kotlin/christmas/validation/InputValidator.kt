package christmas.validation

import christmas.config.error.DateError

object InputValidator {
    fun checkDayValidation(input: String) {
        DateError.requireIsNum(input)
        DateError.isValidDay(input.toInt())
    }


}