
import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(dryRun = false, strict = true, features = ["src/test/resources/"],monochrome = true, plugin=["json:out.json","junit:out.xml"])
class RunCucumberTest 