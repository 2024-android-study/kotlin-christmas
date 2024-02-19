package christmas.view

import christmas.constant.ViewConst

class OutputView {
    fun printOrder(order: Map<String, Int>) {
        println(ViewConst.OUTPUT_ORDER)
        order.map {
            println("${it.key} ${it.value}개")
        }
    }

    private fun printPriceBefore(price: Int) {
        println(ViewConst.OUTPUT_PRICE_BEFORE.format(price))
    }

    private fun printGift(gift: Map<String, Int>) {
        println(ViewConst.OUTPUT_GIFT)
        println(
            if(gift.isEmpty()) ViewConst.OUTPUT_NONE
            else gift.map { "${it.key} ${it.value}개" }
        )
    }
    private fun printBenefit(benefit: Map<String, Int>){
        println(ViewConst.OUTPUT_BENEFIT)
        println(
            if(benefit.isEmpty()) ViewConst.OUTPUT_NONE
            else benefit.map { "${it.key}: -${it.value}원" }
        )
    }
    private fun printWholeBenefit(benefit: Int){
        println(ViewConst.OUTPUT_WHOLE_BENEFIT.format(benefit))
    }
    private fun printPriceAfter(price: Int) {
        println(ViewConst.OUTPUT_PRICE_AFTER.format(price))
    }
    private fun printBadge(badge: String) {
        println(ViewConst.OUTPUT_BADGE.format(badge))
    }
}