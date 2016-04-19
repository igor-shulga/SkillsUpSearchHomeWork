import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class SkillsUpSearchTest extends BasePage {
    private By skillsUpTeam = new By.ByClassName("name");// or "member" if data with position needed
    private By xPathForAlexander = new By.ByXPath("//*[@id='page_position_content']/div[3]/div[1]/div[2]/a/span[1]");
    private boolean x;
    private By artemXpath = By.xpath("//img[contains(@src,'/media/22116/Artem-Karpov_P.jpg')]");

    @Test
    public void testTestLookingForArtem() throws Exception {
        String PersonName1 = "Артем Карпов";
        System.out.println("Start looking for " + PersonName1);
        assertFalse("Why is Artem here?!", coachList().contains(PersonName1));
        System.out.println(PersonName1 + " not found :-( \n");
    }


    @Test
    public void testTestLookingForMisha() throws Exception {
        String PersonName2 = "Михаил Чокан";
        System.out.println("Start looking for " + PersonName2);
        assertTrue("Where is Misha??", coachList().contains(PersonName2));
        System.out.println(PersonName2 + " found \n");

    }


    @Test
    public void testTestLookingForAlexander() throws Exception {

        System.out.println("Start looking for Alexander Galkovski");
        Boolean isPresent = driver.findElements(xPathForAlexander).size() > 0;
        assertTrue("Where is Alexander?He is not found", isPresent == true);
        System.out.println("Alexander Galkovski found");
    }

    @Test
    public void testFindArtemWithException() throws Exception {

        artemAreYouHere();
        assertFalse("Artem found", x == true);

    }

    public boolean artemAreYouHere() {

        try {
            driver.findElement(artemXpath);
            return x = true;
        } catch (NoSuchElementException e) {
            System.err.println("Such element not found: " + e.getMessage());
            return x = false;
        }

    }

    private List coachList() {
        List coachCards = new ArrayList();
        List<WebElement> element = driver.findElements(skillsUpTeam);
        for (WebElement i : element) {
           coachCards.add(i.getText());
        }

        return coachCards;
    }
}