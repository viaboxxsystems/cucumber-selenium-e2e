package page

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.CacheLookup
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import steps.SeleniumWeb

abstract class PageObject  {
    val webDriver: WebDriver = SeleniumWeb.driver

    val rootURL= "http://localhost:8081"
    
    @FindBy(xpath = "/html/body/div/div/h2")
    val header:  WebElement? = null

    @FindBy(xpath ="//a[@title='home page']")
    @CacheLookup
    private val homeLink: WebElement?= null

    @FindBy(xpath ="//a[@title='find owners']")
    @CacheLookup
    private val findOwnerLink: WebElement?= null



    abstract fun navigateTo()

    fun navigateToRoot() {
        webDriver.get(rootURL)
    }

    fun clickFindOwners() {
        findOwnerLink?.click()
        val wait = WebDriverWait(webDriver, 10)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/h2[contains(text(),'Find Owners')]")))
    }

    fun clickHome() {
        homeLink?.click()
        val wait = WebDriverWait(webDriver, 10)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/h2[contains(text(),'Welcome')]")))
    }

    fun pageHeader(): String {
        return header!!.text
    }
}
