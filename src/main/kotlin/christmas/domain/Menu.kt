package christmas.domain

import christmas.constants.ViewConstant.CATEGORY_APPETIZER
import christmas.constants.ViewConstant.CATEGORY_DESSERT
import christmas.constants.ViewConstant.CATEGORY_DRINK
import christmas.constants.ViewConstant.CATEGORY_MAIN

enum class Menu(val menuName: String, val price: Int) {
    // Appetizer
    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    CAESAR_SALAD("시저샐러드", 8_000),

    // Main
    T_BONE_STEAK("티본스테이크", 55_000),
    BBQ_RIBS("바비큐립", 54_000),
    SEAFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000),

    // Dessert
    CHOCO_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000),

    // Drink
    ZERO_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);

    companion object {
        fun getMenu(category: String): List<String> {
            return when (category) {
                CATEGORY_APPETIZER -> listOf(MUSHROOM_SOUP.menuName, TAPAS.menuName,CAESAR_SALAD.menuName)
                CATEGORY_MAIN -> listOf(T_BONE_STEAK.menuName, BBQ_RIBS.menuName, SEAFOOD_PASTA.menuName, CHRISTMAS_PASTA.menuName)
                CATEGORY_DESSERT -> listOf(CHOCO_CAKE.menuName, ICE_CREAM.menuName)
                CATEGORY_DRINK -> listOf(ZERO_COKE.menuName, RED_WINE.menuName, CHAMPAGNE.menuName)
                else -> emptyList()
            }
        }
    }
}