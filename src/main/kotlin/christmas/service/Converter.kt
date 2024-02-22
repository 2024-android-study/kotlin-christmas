package christmas.service

import christmas.config.Menu
import christmas.config.OrderedMenu
import christmas.constant.error.CommonError
import christmas.constant.error.MenuError

object Converter {

    // (ex) 해산물파스타-2,레드와인-1,...
    private const val ORDER_DELIMINATOR = ","
    private const val MENU_DELIMINATOR = "-"

    // 콤마(,)로 주문 분리
    private fun splitOrderByDeliminator(str: String): List<String> {
        return str.split(ORDER_DELIMINATOR)
    }

    // 하이픈(-)으로 메뉴 이름과 개수 분리
    private fun splitMenuNameAndNumByDeliminator(order: String): Pair<String, Int> {
        val splitStr = order.split(MENU_DELIMINATOR)
        CommonError.requireIsNum(splitStr[1])
        return Pair(splitStr[0], splitStr[1].toInt())
    }

    private fun convertPairToOrderedMenu(pair: Pair<String, Int>): OrderedMenu? {
        // 메뉴 이름 확인
        val menuName = pair.first
        MenuError.requireInMenu(menuName)
        // 메뉴 개수 확인
        val menuNum = pair.second
        MenuError.requiredOrderNum(menuNum)

        return Menu.findMenuByName(menuName)?.let { OrderedMenu(it, menuNum) }
    }

    // 주문 리스트를 반환
    fun convertOrderToMenuList(orderStr: String): List<OrderedMenu> {
        val splitList = splitOrderByDeliminator(orderStr) // 콤마(,)를 기준으로 자른 리스트
        val orderedMenuList = mutableListOf<OrderedMenu>()
        for (i in splitList) {
            convertPairToOrderedMenu(splitMenuNameAndNumByDeliminator(i))?.let { orderedMenuList.add(it) }
        }
        return orderedMenuList
    }
}