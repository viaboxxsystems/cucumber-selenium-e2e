package page

import org.junit.Assert.assertTrue
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindAll
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.FindBys
import org.openqa.selenium.support.PageFactory


/**
 * Date: 12.12.19<br>
 * Author: Jan Nonnen
 * </p>
 */

class OwnerListPage(driver: WebDriver) : PageObject(driver) {


    @FindBys(FindBy(xpath = "//a[@class='owner-name']"))
    private val ownerLinks: List<WebElement> = emptyList()

    @FindBys(FindBy(xpath = "//tr[@class='owner']"))
    private val owners: List<WebElement> = emptyList()

    init {
        PageFactory.initElements(driver, this)
    }


    fun isPageOpened(): Boolean {
        return header?.text.toString() == "Owners"
    }

    fun numOfOwners(): Int {
        return ownerLinks.size
    }

    fun clickOwnerDetails(num: Int) {
        ownerLinks[num].click()
    }

    fun ownerHasData(num: Int, data: Map<String, String>) {
        val element = owners[num]
        for ((k, v) in data) {
           assertTrue(element.findElement(By.className("owner-$k")).text == v )
        }
    }


    override fun navigateTo() {
        navigateToRoot()
        clickFindOwners()
    }


}