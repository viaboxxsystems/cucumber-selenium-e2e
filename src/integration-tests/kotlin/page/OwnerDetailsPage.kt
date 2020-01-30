package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import steps.PageObjects


/**
 * Date: 12.12.19<br>
 * Author: Jan Nonnen
 * </p>
 */

class OwnerDetailsPage : PageObject() {
    @FindBy(xpath = "//*[@id='first-name']")
    private val firstName: WebElement? = null

    @FindBy(xpath = "//*[@id='last-name']")
    private val lastName: WebElement? = null

    @FindBy(xpath = "//")
    private val address: WebElement? = null

    @FindBy(xpath = "//")
    private val city: WebElement? = null

    @FindBy(xpath = "//")
    private val telephone: WebElement? = null

    @FindBy(xpath="//*[@id='edit-owner-button']")
    private val editButton: WebElement?= null

    fun getLastName(): String {
        return lastName!!.text
    }
    fun getFirstName(): String {
        return firstName!!.text
    }

    fun getStreet(): String {
        return address!!.text
    }
    fun getCity(): String {
        return city!!.text
    }

    fun getPhoneNumber(): String {
        return telephone!!.text
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
        PageObjects.findOwnerPage().searchOwner(lastname)
        PageObjects.ownerListPage().clickOwnerDetails(lastname)
    }

    override fun navigateTo() {
        TODO("not implemented")
    }


}