package christmas.domain

data class Price(
    val orderMenu: List<Order>
) {
    fun getTotalPrice(): Int {
        var sum = 0

        orderMenu.forEach { order ->
            sum +=  enumValues<Menu>().first { menu -> order.menuName == menu.menuName }.price * order.count
        }

        return sum
    }
}
