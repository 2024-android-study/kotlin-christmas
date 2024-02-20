package christmas.config.date

enum class Calendar(val dates: List<Int>) {
    CHRISTMAS_D_DAY(
        listOf(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25
        )
    ),
    WEEKDAY(
        listOf(
            1,
            4, 5, 6, 7, 8,
            11, 12, 13, 14, 15,
            18, 19, 20, 21, 22,
            25, 26, 27, 28, 29
        )
    ),
    WEEKEND(
        listOf(
            2, 3, 9, 10, 16, 17, 23, 24, 30, 31
        )
    ),
    SPECIAL_DAY(
        listOf(
            3, 10, 17, 24, 25, 31
        )
    )
}