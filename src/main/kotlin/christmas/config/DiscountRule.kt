package christmas.config

enum class DiscountRule(val type: String, val value: Int) {
    DISCOUNT_CHRISTMAS_DDAY("크리스마스 디데이 할인", 100),
    DISCOUNT_WEEKDAY("평일 할인", 2023),
    DISCOUNT_WEEKEND("주말 할인", 2023),
    DISCOUNT_SPECIAL("특별 할인", 1000)
}

enum class PresentRule(val item: Menu, val value: Int) {
    EVENT_PRESENT(Menu.CHAMPAGNE, 1);
}