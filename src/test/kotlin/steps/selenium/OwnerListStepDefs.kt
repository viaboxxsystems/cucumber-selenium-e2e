package steps.selenium
import io.cucumber.datatable.DataTable
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import page.FindOwnerPage
import page.OwnerDetailsPage
import page.OwnerListPage

class OwnerListStepDefs : StepBase(){
    var findOwnersPage = FindOwnerPage(driver)
    var owners = OwnerListPage(driver)
    var ownerDetails = OwnerDetailsPage(driver)

    @Given("I navigate to Find Owner")
    fun beforeEach() {
        findOwnersPage.navigateTo()
    }

    @When("I search for a owner with name {string}")
    fun shouldSearchforOwner(name : String) {
        findOwnersPage.searchOwner(name)
    }

    @Then("I expect to find no owner")
    fun foundNoOwner() {
        assertFalse(findOwnersPage.hasFoundOwner())
    }

    @Then("I expect to find {int} owner(s)")
    fun foundOwner(num: Int) {
        assertTrue(findOwnersPage.hasFoundOwner())
        val owners = OwnerListPage(driver)
        print(owners.numOfOwners())
        assertTrue(owners.numOfOwners() == num)
    }
    
    @Then("I expect to find the owner(s)")
    fun ownertable(arg : DataTable) {
        assertTrue(findOwnersPage.hasFoundOwner())

        for(row in arg.asMaps()){
           owners.ownerWithName(row)
        }
    }

    @Then("I see the owner list page")
    fun should_match_page_header(){
       assertTrue( findOwnersPage.pageHeader() == "Owners")
    }

    @io.cucumber.java.After
    fun teardown(){
        driver.quit();
    }

}