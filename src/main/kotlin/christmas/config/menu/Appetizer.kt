package christmas.config.menu

enum class Appetizer(val menuName: String, val price: Int) : Menu {
    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    SIZER_SALAD("시저샐러드", 8_000);
}