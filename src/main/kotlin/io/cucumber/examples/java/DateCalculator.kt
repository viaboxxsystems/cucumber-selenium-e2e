package io.cucumber.examples.java

import java.time.LocalDate

class DateCalculator(private val now: LocalDate) {
    fun isDateInThePast(date: LocalDate): String {
        return if (date.isBefore(now)) "yes" else "no"
    }

}