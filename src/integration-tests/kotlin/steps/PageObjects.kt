package steps

import org.openqa.selenium.support.PageFactory
import page.FindOwnerPage
import page.HomePage
import page.OwnerDetailsPage
import page.OwnerListPage

/**
 * Date: 29.01.20<br>
 * Author: Jan Nonnen
 * </p>
 */
object PageObjects {
    fun homePage(): HomePage = PageFactory.initElements(SeleniumWeb.driver, HomePage::class.java)
    fun findOwnerPage() =  PageFactory.initElements(SeleniumWeb.driver, FindOwnerPage::class.java)
    fun ownerListPage() =  PageFactory.initElements(SeleniumWeb.driver, OwnerListPage::class.java)
    fun ownerDetailsPage() =  PageFactory.initElements(SeleniumWeb.driver, OwnerDetailsPage::class.java)

}