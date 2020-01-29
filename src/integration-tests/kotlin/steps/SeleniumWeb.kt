package steps

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.AfterClass
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

/**
 * Date: 29.01.20<br>
 * Author: Jan Nonnen
 * </p>
 */
object SeleniumWeb {
    var driver: ChromeDriver

    val headless: Boolean = true


    init {
        WebDriverManager.chromedriver().useBetaVersions().setup()
        val options = ChromeOptions()
        if (headless){
            options.addArguments("--headless")
        }
        options.addArguments("--disable-gpu")
        driver = ChromeDriver(options)
    }
   

    @AfterClass
    @JvmStatic
    fun closeDriver(){
        driver.close()
    }
}