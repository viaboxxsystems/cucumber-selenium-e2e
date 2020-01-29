package steps

import io.cucumber.java.en.But
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en_lol.ICANHAZ
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals

class VariablesSteps {
    lateinit var state: Any

    @Given("I can has {string}?")
    @ICANHAZ("I can haz {string}?")
    fun given_i_can_has(input: String) {
        state = input
    }

    @Given("I can has {int}?")
    fun given_i_can_has_number(input: Int) {
        state = input
    }

    @Given("He took his vorpal sword in hand.")
    fun given_he_took_the_vorpal_sword() {
        state = "vorpal sword"
    }
    
    @Then("The vorpal blade went snicker-snack!")
    fun then_vorpal_sword_went_snicker_snack(){
        assertEquals("vorpal sword", state)
    }

    @Then("I got {string}")
    fun then_i_got(input: String) {
        assertEquals(input, state)
    }
    @Then("I got {int}")
    fun then_i_got(input: Int) {
        assertEquals(input, state)
    }


    @But("where the {string}?")
    fun but_i_got(input: String) {
        assertNotEquals(input, state)
    }

}