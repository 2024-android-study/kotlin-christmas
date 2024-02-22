package christmas.constant.error

enum class DateError(val message: String) {
    INVALID_INPUT("[ERROR] 날짜는 int 형식이어야 합니다. 다시 입력해 주세요."),
    INVALID_NUM_RANGE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    companion object {
        fun requireIsNum(str: String) {
            require(str.all { it.isDigit() }) { INVALID_INPUT.message }
        }

        fun isValidDay(day: Int) {
            require(day in 1..31) { INVALID_NUM_RANGE.message }
        }
    }
}