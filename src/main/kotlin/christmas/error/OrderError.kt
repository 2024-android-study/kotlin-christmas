package christmas.error

enum class OrderError(val message: String) {
    NOT_IN_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_FORMAT("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    DUPLICATE_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),

}