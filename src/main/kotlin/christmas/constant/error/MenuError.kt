package christmas.constant.error

import christmas.config.Menu

enum class MenuError(val message: String) {
    INVALID_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_ORDER_IN_MENU("메뉴 안에 없음"),
    INVALID_ORDER_NUM("메뉴 개수는 1 이상이어야 함");

    companion object {
        fun requireInMenu(orderedMenu: String) { // 메뉴판 안에 있는 메뉴여야 함
            val menuList = Menu.values() // 메뉴판의 메뉴들
            require(menuList.any { it.title.equals(orderedMenu) }) { INVALID_MENU.message + "\n" + INVALID_ORDER_IN_MENU.message}
        }

        fun requiredOrderNum(num: Int) { // 주문하는 메뉴 개수는 1 이상이어야 함
            require(num >= 1) { INVALID_MENU.message + "\n" + INVALID_ORDER_NUM.message }
        }
    }
}