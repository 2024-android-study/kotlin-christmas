package christmas.service

import java.text.DecimalFormat

object OutputConverter {
    fun convertToTitleFormat(title: String): String {
        return ("<" + title + ">")
    }

    fun decimalAmount(amount: Int): String {
        val dec = DecimalFormat("#,###")
        return dec.format(amount)
    }
}