package steps
import io.cucumber.java.AfterStep
import io.cucumber.java.BeforeStep
import io.cucumber.java.Scenario
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import org.junit.AfterClass
import org.junit.Assert.assertTrue
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.support.PageFactory
import page.FindOwnerPage
import page.HomePage
import page.OwnerListPage
import steps.LivePageObjects.homePage

class HomeStepDefs {

    @Given("I navigate to the homepage")
    fun beforeEach() {
        homePage().navigateTo()
    }

    @Then("I should see the homepage")
    fun shouldHaveHomepageOpen() {
        assertTrue(homePage().isPageOpened())
        
    }

    @AfterStep
    fun doScreenshot(scenario: Scenario) {
        try {
            val ts = SeleniumWeb.driver as TakesScreenshot
            val screenshot = ts.getScreenshotAs(OutputType.BYTES)
            scenario.embed(screenshot, "image/png")
        } catch (wde: Throwable) {
            System.err.println(wde.message)
        } catch (cce: ClassCastException) {
            cce.printStackTrace()
        }
    }



    
}