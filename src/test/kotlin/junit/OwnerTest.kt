package junit
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import page.FindOwner
import page.OwnerListPage

class OwnerTest : TestBase(){
    lateinit var findOwner : FindOwner

    @Before
    fun beforeEach() {
        findOwner = FindOwner(driver)
        findOwner.navigateTo()
    }

      
    @Test
    fun shouldNotFindOwner() {
        findOwner.searchOwner("Blub")
        assertFalse(findOwner.hasFoundOwner())

        findOwner.searchOwner("Franklin")
        assertTrue(findOwner.hasFoundOwner())

        val ownerList = OwnerListPage(driver)
        assertTrue(ownerList.isPageOpened())
        assertTrue(ownerList.numOfOwners() == 1)

        ownerList.ownerHasData(0, mapOf( "name" to "George Franklin" , "address" to "110 W. Liberty St.", "city" to "Madison", "phone" to "6085551023"))
        ownerList.ownerWithName(mapOf( "name" to "George Franklin" , "address" to "110 W. Liberty St.", "city" to "Madison", "phone" to "6085551023"))
    }

}