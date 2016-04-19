import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class SkillsUpSearchTest extends BasePage {
    private By skillsUpTeam = new By.ByClassName("name");// or "member" if data with position needed

    @Test
    public void testTestLookingForArtem() throws Exception {
        String PersonName1 = "Артем Карпов";
        System.out.println("Start looking for " + PersonName1);
        assertFalse("Why is Artem here?!", getCoachList().contains(PersonName1));
        System.out.println(PersonName1 + " not found :-( \n");
    }


    @Test
    public void testTestLookingForMisha() throws Exception {
        String PersonName2 = "Михаил Чокан";
        System.out.println("Start looking for " + PersonName2);
        assertTrue("Where is Misha??", getCoachList().contains(PersonName2));
        System.out.println(PersonName2 + " found \n");
    }


    @Test
    public void testTestLookingForAlexander() throws Exception {
        String PersonName3 = "Александр Галковский";
        System.out.println("Start looking for " + PersonName3 );
        assertTrue("Where is Alexander?He is not found", getCoachList().contains(PersonName3));
        System.out.println(PersonName3+" found");
    }


    private List <String> getCoachList() {
        List coachCards = new ArrayList();
        List<WebElement> element = driver.findElements(skillsUpTeam);
        for (WebElement i : element) {
           coachCards.add(i.getText());
        }
        return coachCards;
    }
}