package christmas.validator

import christmas.constants.NumConstant

enum class DateValidator(val message: String) {
    EMPTY("[ERROR] 날짜를 입력하지 않았습니다. 다시 입력해 주세요."),
    INCLUDE_BLANK("[ERROR] 공백이 포함되어 있습니다. 다시 입력해 주세요."),
    NOT_NUMBER("[ERROR] 숫자가 아닙니다. 다시 입력해 주세요."),
    OUT_OF_RANGE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    companion object {
        fun validateDate(input: String) {
            val error = when {
                input.isEmpty() -> EMPTY
                input.contains(" ") -> INCLUDE_BLANK
                input.matches(Regex("^\\d+$")).not() -> NOT_NUMBER
                input.toInt() !in (NumConstant.DAY_FIRST .. NumConstant.DAY_LAST) -> OUT_OF_RANGE
                else -> return
            }

            throw IllegalArgumentException(error.message)
        }
    }
}