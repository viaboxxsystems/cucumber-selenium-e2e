package junit

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.After
import org.junit.Ignore
import org.openqa.selenium.chrome.ChromeDriver




@Ignore
abstract
class TestBase {
    var driver: ChromeDriver

    init {
          WebDriverManager.chromedriver().setup();
          driver = ChromeDriver()
    }

    @After
    fun teardown(){
        driver.quit();
    }


}
