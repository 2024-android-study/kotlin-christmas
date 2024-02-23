package christmas.config

enum class Menu(val type: MenuType, val title: String, val price: Int) {
    // 에피타이저
    MUSHROOM_SOUP(MenuType.APPETIZER, "양송이수프",  6000),
    TAPAS(MenuType.APPETIZER, "타파스", 5500),
    CAESAR_SALAD(MenuType.APPETIZER, "시저샐러드", 8000),
    // 메인
    T_BORN_STEAK(MenuType.MAIN, "티본스테이크", 55000),
    BARBCUE_RIBS(MenuType.MAIN, "바비큐립", 54000),
    SEAFOOD_PASTA(MenuType.MAIN, "해산물파스타", 35000),
    CHRISTMAS_PASTA(MenuType.MAIN, "크리스마스파스타", 25000),
    // 디저트
    CHOCOLATE_CAKE(MenuType.DESSERT, "초코케이크", 15000),
    ICECREAM(MenuType.DESSERT, "아이스크림", 5000),
    // 음료
    ZERO_COKE(MenuType.DRINK, "제로콜라", 3000),
    RED_WINE(MenuType.DRINK, "레드와인", 60000),
    CHAMPAGNE(MenuType.DRINK, "샴페인", 25000);

    fun getMenuName(): String {
        return title;
    }

    companion object {
        fun findMenuByName(menuName: String): Menu? {
            for (menu in Menu.entries) {
                if (menu.getMenuName().equals(menuName)) {
                    return menu
                }
            }
            return null
        }
    }

}