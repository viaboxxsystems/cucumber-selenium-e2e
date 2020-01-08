package junit
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import page.FindOwnerPage
import page.OwnerListPage

@Ignore
class OwnerTest : TestBase(){
    lateinit var findOwnerPage : FindOwnerPage

    @Before
    fun beforeEach() {
        findOwnerPage = FindOwnerPage(driver)
        findOwnerPage.navigateTo()
    }

      
    @Test
    fun shouldNotFindOwner() {
        findOwnerPage.searchOwner("Blub")
        assertFalse(findOwnerPage.hasFoundOwner())

        findOwnerPage.searchOwner("Franklin")
        assertTrue(findOwnerPage.hasFoundOwner())

        val ownerList = OwnerListPage(driver)
        assertTrue(ownerList.isPageOpened())
        assertTrue(ownerList.numOfOwners() == 1)

        ownerList.ownerHasData(0, mapOf( "name" to "George Franklin" , "address" to "110 W. Liberty St.", "city" to "Madison", "phone" to "6085551023"))
        ownerList.ownerWithName(mapOf( "name" to "George Franklin" , "address" to "110 W. Liberty St.", "city" to "Madison", "phone" to "6085551023"))
    }

}