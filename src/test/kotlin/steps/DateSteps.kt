package steps

import io.cucumber.examples.java.DateCalculator
import io.cucumber.java.ParameterType
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert
import java.time.LocalDate

class DateSteps {
    
    private var result: String? = null
    private var calculator: DateCalculator? = null

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    fun iso8601Date(year: String, month: String, day: String): LocalDate {
        return LocalDate.of(year.toInt(), month.toInt(), day.toInt())
    }

    @Given("today is {iso8601Date}")
    fun today_is(date: LocalDate?) {
        calculator = DateCalculator(date!!)
    }

    @When("I ask if {iso8601Date} is in the past")
    fun I_ask_if_date_is_in_the_past(date: LocalDate?) {
        result = calculator!!.isDateInThePast(date!!)
    }

    @Then("^the result should be (yes|no)$")
    fun the_result_should_be(expectedResult: String?) {
        Assert.assertEquals(expectedResult, result)
    }
}