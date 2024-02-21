package christmas.validator

import christmas.constants.NumConstant
import christmas.constants.ViewConstant
import christmas.domain.Menu

enum class MenuValidator(val message: String) {
    EMPTY("[ERROR] 메뉴를 입력하지 않았습니다. 다시 입력해 주세요."),
    INCLUDE_BLANK("[ERROR] 공백이 포함되어 있습니다. 다시 입력해 주세요."),
    NOT_DRINK("[ERROR] 음료만 주문할 수 없습니다. 다시 입력해 주세요."),
    MENU_CNT("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요"),
    INVALID_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    companion object {
        fun validateMenu(input: String) {
            val error = when {
                input.isEmpty() -> EMPTY
                input.contains(" ") -> INCLUDE_BLANK
                !input.contains(",") -> INVALID_MENU
                input.contains(",,") -> INVALID_MENU
                else -> return
            }

            throw IllegalArgumentException(error.message)
        }

        fun validateMenuName(menuList: List<String>) {
            val menuNames = menuList.map {
                it.split("-")[0]
            }

            val error = when {
                !isContainHyphen(menuList) -> INVALID_MENU
                !checkExistMenu(menuNames) -> INVALID_MENU
                isDuplicate(menuNames) -> INVALID_MENU
                checkOnlyDrink(menuNames) -> NOT_DRINK
                else -> return
            }

            throw IllegalArgumentException(error.message)
        }

        fun validateMenuCount(menuList: List<String>) {
            val menuCounts = menuList.map {
                it.split("-")[1]
            }

            val error = when {
                !checkMenuCountType(menuCounts) -> INVALID_MENU
                !checkMinCount(menuCounts) -> INVALID_MENU
                !checkTotalCount(menuCounts) -> MENU_CNT
                else -> return
            }

            throw IllegalArgumentException(error.message)
        }

        // - 포함하고 있는지 확인
        private fun isContainHyphen(menuList: List<String>): Boolean {
            return menuList.all { it.contains("-") }
        }

        // 메뉴판에 있는 메뉴인지 확인
        private fun checkExistMenu(menuNames: List<String>):Boolean {
            return menuNames.all { it in Menu.entries.map { menu -> menu.menuName } }
        }

        // 메뉴가 중복되는지 확인
        private fun isDuplicate(menuNames: List<String>): Boolean {
            return menuNames.size != menuNames.toSet().size
        }

        // 음료만 있는지 확인
        private fun checkOnlyDrink(menuNames: List<String>): Boolean {
            val filterMenuName = menuNames.filterNot { it in Menu.getMenu(ViewConstant.CATEGORY_DRINK) }
            return filterMenuName.isEmpty()
        }

        // 메뉴 개수가 숫자인지 확인
        private fun checkMenuCountType(menuCounts: List<String>): Boolean {
            return menuCounts.all { it.matches(Regex("^\\d+$")) }
        }

        // 메뉴를 1개이상 입력했는지 확인
        private fun checkMinCount(menuCounts: List<String>): Boolean {
            return menuCounts.all { it.toInt() >= NumConstant.MIN_MENU_CNT }
        }

        // 총 개수가 20개 이하인지 확인
        private fun checkTotalCount(menuCounts: List<String>): Boolean {
            return menuCounts.sumOf { it.toInt() } <= NumConstant.MAX_MENU_CNT
        }

    }
}