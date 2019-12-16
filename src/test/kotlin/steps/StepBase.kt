package steps

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.After
import org.openqa.selenium.chrome.ChromeDriver

abstract class StepBase {
    var driver: ChromeDriver

    init {
        WebDriverManager.chromedriver().setup();
        driver = ChromeDriver()
    }

    @io.cucumber.java.After
    fun teardown(){
        driver.quit();
    }

}
