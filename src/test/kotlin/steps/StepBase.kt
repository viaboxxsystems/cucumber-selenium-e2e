package steps

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver

abstract class StepBase {
    var driver: ChromeDriver

    init {
        WebDriverManager.chromedriver().setup();
        driver = ChromeDriver()
    }



}
