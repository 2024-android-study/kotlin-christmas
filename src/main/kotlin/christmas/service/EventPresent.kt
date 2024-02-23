package christmas.service

import christmas.config.PresentRule
import christmas.constant.EventConstant

class EventPresent(val totalAmount: Int) {
    fun champagnePresent(): Int {
        if (totalAmount >= EventConstant.PRESENT_CRITERIA.value) {
            return PresentRule.EVENT_CHAMPAGNE_PRESENT.value
        }
        return 0
    }
}