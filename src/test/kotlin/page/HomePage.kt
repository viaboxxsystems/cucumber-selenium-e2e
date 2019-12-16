package page

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import utils.UtilResources


/**
 * Date: 12.12.19<br>
 * Author: Jan Nonnen
 * </p>
 */

class HomePage(webdriver: WebDriver) : PageObject(webdriver){
    val PAGE_TITLE = "PetClinic :: a Spring Framework demonstration"

    init {
        PageFactory.initElements(webdriver, this)
    }

    fun isPageOpened(): Boolean{
        return header?.text.toString().contains("Welcome")
    }


    override fun navigateTo() {
        navigateToRoot()
    }

}