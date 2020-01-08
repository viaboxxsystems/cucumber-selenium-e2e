package steps.selenium

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import utils.UtilResources.getProperties


abstract class StepBase {
    var driver: ChromeDriver

    init {
        WebDriverManager.chromedriver().setup()
        val options = ChromeOptions()
        if (getProperties("headless").toBoolean()){
            options.addArguments("--headless")
        }
        options.addArguments("--disable-gpu")
        driver = ChromeDriver(options)
    }




}
