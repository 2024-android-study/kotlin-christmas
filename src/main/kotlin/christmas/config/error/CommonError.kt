package christmas.config.error

enum class CommonError(message: String) {
    INVALID_INPUT_NUM("[ERROR] 숫자를 입력해 주세요.");

    companion object {
        fun requireIsNum(str: String) {
            require(str.all { it.isDigit() }) { DateError.INVALID_INPUT.message }
        }
    }
}