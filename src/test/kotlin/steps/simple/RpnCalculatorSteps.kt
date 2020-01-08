package steps.simple

import io.cucumber.examples.java.RpnCalculator
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.Scenario
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.jupiter.api.Assertions

class RpnCalculatorSteps {
    private var calc: RpnCalculator? = null
    @Given("a calculator I just turned on")
    fun a_calculator_I_just_turned_on() {
        calc = RpnCalculator()
    }

    @When("I add {int} and {int}")
    fun adding(arg1: Int, arg2: Int) {
        calc!!.push(arg1)
        calc!!.push(arg2)
        calc!!.push("+")
    }

    @Given("^I press (.+)$")
    fun I_press(what: String) {
        calc!!.push(what)
    }

    @Then("the result is {int}")
    fun the_result_is(expected: Double) {
        Assertions.assertEquals(expected, calc!!.value())
    }

    @Before("not @foo")
    fun before(scenario: Scenario) {
        scenario.write("Runs before scenarios *not* tagged with @foo")
    }

    @After
    fun after(scenario: Scenario) { // scenario.write("HELLLLOO");
    }

    @Given("the previous entries:")
    fun thePreviousEntries(entries: List<Entry>) {
        for (entry in entries) {
            calc!!.push(entry.first)
            calc!!.push(entry.second)
            calc!!.push(entry.operation)
        }
    }

    class Entry {
        var first: Int? = null
        var second: Int? = null
        var operation: String? = null

    }
}