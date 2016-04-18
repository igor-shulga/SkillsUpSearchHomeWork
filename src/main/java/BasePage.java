import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class BasePage extends TestCase {

    protected static WebDriver driver;
    private String basePage = "http://skillsup.ua"; // base url page
    private By aboutUs = By.xpath(".//*[@id='menu3039']/a");
    private By ourTeam = By.xpath(".//*[@id='menu3039']/ul/li[1]/a");


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.navigate().to(basePage);

        WebElement hoverElement = driver.findElement(aboutUs);
        WebElement clickElement = driver.findElement(ourTeam);
        Actions openTeamPage = new Actions(driver);
        openTeamPage.moveToElement(hoverElement).perform();
        openTeamPage.moveToElement(clickElement).click().perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}

