package junit

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Test
import page.HomePage


class HomeTest : TestBase(){
    lateinit var homePage : HomePage

    @BeforeClass
    fun beforeEach() {
        homePage = HomePage(driver)
        homePage.navigateTo()
    }

    @Test
    fun shouldHaveHomepageOpen() {
        assertTrue((homePage.isPageOpened()))
    }
      
    @Test
    fun shouldHaveDifferentPageOpen() {
        homePage.clickFindOwners()
        assertFalse((homePage.isPageOpened()))
    }



}