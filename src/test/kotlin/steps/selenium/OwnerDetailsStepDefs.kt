package steps.selenium
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import org.junit.Assert.assertTrue
import page.FindOwnerPage
import page.OwnerDetailsPage
import page.OwnerListPage

class OwnerDetailsStepDefs : StepBase(){
    var findOwnersPage = FindOwnerPage(driver)
    var owners = OwnerListPage(driver)
    var ownerDetails = OwnerDetailsPage(driver)

    @Given("I open the owner with name {string}")
    fun openOwnerWithName(name:String) {
        findOwnersPage.navigateTo()
        findOwnersPage.searchOwner(name)
        owners.clickOwnerDetails(name)
    }

    @Then("I see the owner details for {string}")
    fun ownerDetailsFor(fullName: String){
        assertTrue(ownerDetails.getFullName() == fullName)
    }


    @io.cucumber.java.After
    fun teardown(){
        driver.quit();
    }

}