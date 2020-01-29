package page


/**
 * Date: 12.12.19<br>
 * Author: Jan Nonnen
 * </p>
 */

class HomePage: PageObject(){
    val PAGE_TITLE = "PetClinic :: a Spring Framework demonstration"


    fun isPageOpened(): Boolean{
        return header?.text.toString().contains("Welcome")
    }


    override fun navigateTo() {
        navigateToRoot()
    }

}