
import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(dryRun = false, strict = true, features = ["src/test/resources"], glue = ["steps"],monochrome = true)
class RunCucumberTest 