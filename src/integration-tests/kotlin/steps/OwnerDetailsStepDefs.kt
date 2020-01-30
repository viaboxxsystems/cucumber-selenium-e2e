package steps
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import org.junit.Assert.assertTrue
import steps.PageObjects.findOwnerPage
import steps.PageObjects.ownerDetailsPage
import steps.PageObjects.ownerListPage

class OwnerDetailsStepDefs {
    @Given("I open the owner with name {string}")
    fun openOwnerWithName(name:String) {
        findOwnerPage().navigateTo()
        findOwnerPage().searchOwner(name)
        ownerListPage().clickOwnerDetails(name)
    }

    @Then("I see the owner details for {string}")
    fun ownerDetailsFor(fullName: String){
        assertTrue(ownerDetailsPage().getFullName() == fullName)
    }



}