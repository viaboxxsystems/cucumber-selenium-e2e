package steps
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import org.junit.Assert.assertTrue
import page.FindOwnerPage
import page.OwnerDetailsPage
import page.OwnerListPage
import steps.LivePageObjects.findOwnerPage
import steps.LivePageObjects.ownerDetailsPage
import steps.LivePageObjects.ownerListPage

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