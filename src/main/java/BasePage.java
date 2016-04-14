import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


public class BasePage extends TestCase {

    protected static WebDriver driver;
    private String basePage = "http://skillsup.ua/about/our-team.aspx"; // base url page


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.navigate().to(basePage);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}


