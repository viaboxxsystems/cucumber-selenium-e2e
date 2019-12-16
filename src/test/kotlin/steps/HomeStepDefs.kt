package steps
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import org.junit.Assert.assertTrue
import page.HomePage
import steps.StepBase

class HomeStepDefs : StepBase(){
    var homePage : HomePage = HomePage(driver)

    @Given("I navigate to the homepage")
    fun beforeEach() {
        homePage.navigateTo()
    }

    @Then("I should see the homepage")
    fun shouldHaveHomepageOpen() {
        assertTrue((homePage.isPageOpened()))
    }




}