package steps
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import page.FindOwner
import page.HomePage
import page.OwnerListPage
import steps.StepBase

class OwnerListStepDefs : StepBase(){
    var findOwners : FindOwner = FindOwner(driver)

    @Given("I navigate to Find Owner")
    fun beforeEach() {
        findOwners.navigateTo()
    }

    @When("I search for a owner with name {string}")
    fun shouldSearchforOwner(name : String) {
        findOwners.searchOwner(name)
    }

    @Then("I expect to find no owner")
    fun foundNoOwner() {
        assertFalse(findOwners.hasFoundOwner())
    }

    @Then("I expect to find an owner")
    fun foundOwner() {
        assertTrue(findOwners.hasFoundOwner())
    }

    @Then("I expect to find {int} owner(s)")
    fun foundOwner(num: Int) {
        assertTrue(findOwners.hasFoundOwner())
        val owners = OwnerListPage(driver)
        print(owners.numOfOwners())
        assertTrue(owners.numOfOwners() == num)
    }


}