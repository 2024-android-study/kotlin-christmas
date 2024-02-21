package christmas.domain

import christmas.constants.NumConstant

enum class Badge(val badgeName: String) {
    STAR("별"),
    TREE("트리"),
    SANTA("산타"),
    NONE("없음");

    companion object {
        fun grantBadge(benefitPrice: Int): String {
            return when {
                benefitPrice >= NumConstant.BADGE_SANTA_RANGE -> SANTA.badgeName
                benefitPrice >= NumConstant.BADGE_TREE_RANGE -> TREE.badgeName
                benefitPrice >= NumConstant.BADGE_STAR_RANGE -> STAR.badgeName
                else -> NONE.badgeName
            }
        }
    }

}