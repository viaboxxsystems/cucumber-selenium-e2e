package page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import steps.SeleniumWeb


/**
 * Date: 12.12.19<br>
 * Author: Jan Nonnen
 * </p>
 */

class FindOwnerPage : PageObject(){
    @FindBy(xpath = "//button[@type='submit']")
    private val findOwnerButton: WebElement? = null

    @FindBy(xpath = "//button[@type='submit']")
    private val addOwnerLink: WebElement? = null


    @FindBy(xpath = "//input[@id='lastName']")
    private val searchField: WebElement? = null

    @FindBy(xpath= "//p[text()[contains(., 'has not been found')]]")
    private val hasNotBeenFoundText: WebElement? = null


    fun searchOwner(name : String){
        searchField?.clear()
        searchField?.sendKeys(name);
        findOwnerButton?.click();
    }

    fun isPageOpened(): Boolean{
        return header?.text.toString().contains("Find Owners")
    }

    fun hasFoundOwner(): Boolean {
        return try{
            !hasNotBeenFoundText?.isDisplayed!!
        }  catch(e: org.openqa.selenium.NoSuchElementException){
            header?.text.toString() == "Owners"
        }
    }

    override fun navigateTo() {
        navigateToRoot()
        clickFindOwners()
    }




}