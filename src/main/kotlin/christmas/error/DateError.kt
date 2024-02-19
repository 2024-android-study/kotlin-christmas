package christmas.error

enum class DateError(val message: String) {
    NOT_NUMBER("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    OUT_OF_RANGE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
}