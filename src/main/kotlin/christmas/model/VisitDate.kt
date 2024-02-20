package christmas.model

import christmas.config.date.Calendar

class VisitDate(private val date: Int) {

    fun isChristmasDDAy(): Boolean {
        return Calendar.CHRISTMAS_D_DAY.dates.contains(date)
    }

    fun isWeekday(): Boolean {
        return Calendar.WEEKDAY.dates.contains(date)
    }

    fun isWeekend(): Boolean {
        return Calendar.WEEKEND.dates.contains(date)
    }

    fun isSpecialDay(): Boolean {
        return Calendar.SPECIAL_DAY.dates.contains(date)
    }
}