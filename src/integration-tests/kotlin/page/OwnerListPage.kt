package page

import org.junit.Assert.assertTrue
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindAll
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.FindBys
import org.openqa.selenium.support.PageFactory
import steps.SeleniumWeb


/**
 * Date: 12.12.19<br>
 * Author: Jan Nonnen
 * </p>
 */

class OwnerListPage : PageObject() {
    @FindBys(FindBy(xpath = "//a[@class='owner-name']"))
    private val ownerLinks: List<WebElement> = emptyList()

    @FindBys(FindBy(xpath = "//tr[@class='owner']"))
    private val owners: List<WebElement> = emptyList()


    fun isPageOpened(): Boolean {
        return header?.text.toString() == "Owners"
    }

    fun numOfOwners(): Int {
        return ownerLinks.size
    }

    fun clickOwnerDetails(num: Int) {
        ownerLinks[num].click()
    }

    fun clickOwnerDetails(name: String) {
        val ownerWithName: WebElement = ownerLinks.first { it.text.contains(name) }
        ownerWithName.click()
    }

    fun ownerHasData(num: Int, data: Map<String, String>) {
        val element = owners[num]
        assertTrue( ownerMatches(element, data) )
    }
    fun ownerWithName(data: Map<String, String>) {
        assertTrue(data.containsKey("name"))
        val element = owners.filter {it.findElement(By.className("owner-name")).text == data["name"]}.first()
        assertTrue( ownerMatches(element, data) )
    }

    private fun ownerMatches(owner: WebElement, data: Map<String, String>) :Boolean {
        return  data.all { (k,v) -> owner.findElement(By.className("owner-$k")).text == v }
    }
        
    override fun navigateTo() {                          
        navigateToRoot()
        clickFindOwners()
    }


}