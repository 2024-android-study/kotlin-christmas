package christmas.config

enum class Badge(val title: String, val criteriaAmount: Int) {
    NONE("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    companion object {
        fun findBadgeByAmount(amount: Int): String {
            return when(amount) {
                in NONE.criteriaAmount..STAR.criteriaAmount -> NONE.title
                in STAR.criteriaAmount..TREE.criteriaAmount -> STAR.title
                in TREE.criteriaAmount..SANTA.criteriaAmount -> TREE.title
                else -> SANTA.title
            }
        }
    }
}