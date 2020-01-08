package page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory


/**
 * Date: 12.12.19<br>
 * Author: Jan Nonnen
 * </p>
 */

class OwnerDetailsPage(driver: WebDriver) : PageObject(driver) {


    @FindBy(xpath = "//*[@id='first-name']")
    private val firstName: WebElement? = null

    @FindBy(xpath = "//*[@id='last-name']")
    private val lastName: WebElement? = null

    @FindBy(xpath = "//")
    private val address: WebElement? = null

    @FindBy(xpath = "//")
    private val city: WebElement? = null

    @FindBy(xpath = "//")
    private val phone: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun getLastName(): String {
        return lastName!!.text
    }
    fun getFirstName(): String {
        return firstName!!.text
    }

    fun getFullName(): String {
        return "${getFirstName()} ${getLastName()}"
    }
    
    fun isPageOpened(): Boolean {
        return header?.text.toString() == "Owner Information"
    }

    fun navigateTo(lastname: String) {
        navigateToRoot()
        clickFindOwners()
        val findOwner = FindOwnerPage(webDriver)
        findOwner.searchOwner(lastname)
        val  ownerListPage = OwnerListPage(webDriver)
        ownerListPage.clickOwnerDetails(lastname)
    }

    override fun navigateTo() {
        TODO("not implemented")
    }


}