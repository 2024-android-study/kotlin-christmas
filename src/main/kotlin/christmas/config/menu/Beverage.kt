package christmas.config.menu

enum class Beverage(val menuName: String, val price: Int): Menu {
    ZERO_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000)
}