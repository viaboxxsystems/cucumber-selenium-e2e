package steps
import io.cucumber.datatable.DataTable
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import page.FindOwnerPage
import page.OwnerDetailsPage
import page.OwnerListPage
import steps.LivePageObjects.findOwnerPage
import steps.LivePageObjects.ownerListPage

class OwnerListStepDefs {
    @Given("I navigate to Find Owner")
    fun beforeEach() {
        findOwnerPage().navigateTo()
    }

    @When("I search for a owner with name {string}")
    fun shouldSearchforOwner(name : String) {
        findOwnerPage().searchOwner(name)
    }

    @Then("I expect to find no owner")
    fun foundNoOwner() {
        assertFalse(findOwnerPage().hasFoundOwner())
    }

    @Then("I expect to find {int} owner(s)")
    fun foundOwner(num: Int) {
        assertTrue(findOwnerPage().hasFoundOwner())

        print(ownerListPage().numOfOwners())
        assertTrue(ownerListPage().numOfOwners() == num)
    }
    
    @Then("I expect to find the owner(s)")
    fun ownertable(arg : DataTable) {
        assertTrue(findOwnerPage().hasFoundOwner())
        for(row in arg.asMaps()){
            ownerListPage().ownerWithName(row)
        }
    }

    @Then("I see the owner list page")
    fun should_match_page_header(){
       assertTrue( findOwnerPage().pageHeader() == "Owners")
    }


}