package christmas.view

import christmas.constant.ViewConst

class OutputView {
    fun printOrder(date:Int, order: Map<String, Int>) {
        println(ViewConst.OUTPUT_ORDER.format(date))
        order.map {
            println("${it.key} ${it.value}개")
        }
    }

    fun printPriceBefore(price: Int) {
        println(ViewConst.OUTPUT_PRICE_BEFORE.format(price))
    }

    fun printGift(gift: Map<String, Int>) {
        println(ViewConst.OUTPUT_GIFT)
        println(
            if(gift.isEmpty()) ViewConst.OUTPUT_NONE
            else gift.map { "${it.key} ${it.value}개" }
        )
    }
    fun printBenefitHistory(benefit: Map<String, Int>){
        println(ViewConst.OUTPUT_BENEFIT_HISTORY)
        println(
            if(benefit.isEmpty()) ViewConst.OUTPUT_NONE
            else benefit.map { "${it.key}: -${it.value}원" }
        )
    }
    fun printWholeBenefit(benefit: Int){
        println(ViewConst.OUTPUT_WHOLE_BENEFIT.format(benefit))
    }
    fun printPriceAfter(price: Int) {
        println(ViewConst.OUTPUT_PRICE_AFTER.format(price))
    }
    fun printBadge(badge: String) {
        println(ViewConst.OUTPUT_BADGE.format(badge))
    }
}