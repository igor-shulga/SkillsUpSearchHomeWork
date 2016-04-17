import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.util.List;


public class SkillsUpSearchTest extends BasePage {
    private By skillsUpTeam = new By.ByClassName("member");
    private String memberText;
    private By xPathForAlexander = new By.ByXPath("//*[@id='page_position_content']/div[3]/div[1]/div[2]/a/span[1]");
    private boolean x;
    private By artemXpath = By.xpath("//img[contains(@src,'/media/22116/Artem-Karpov_P.jpg')]");

    @Test
    public void testTestLookingForArtem() throws Exception {
        String PersonName = "Артем Карпов";
        System.out.println("Start looking for " + PersonName);
        lookingPersonByName(PersonName);
        assertFalse("Why is Artem here?!", memberText.contains("Артем Карпов"));
        System.out.println(PersonName + " not found :-( \n");
    }


    @Test
    public void testTestLookingForMisha() throws Exception {
        String PersonName = "Чокан";
        System.out.println("Start looking for " + PersonName);
        lookingPersonByName(PersonName);
        assertTrue("Where is Misha??", memberText.contains("Чокан"));
    }


    @Test
    public void testTestLookingForAlexander() throws Exception {

        System.out.println("Start looking for Alexander Galkovski");
        Boolean isPresent = driver.findElements(xPathForAlexander).size() > 0;
        assertTrue("Where is Alexander?He is not found", isPresent == true);
        System.out.println("Alexander Galkovski found");
    }

    @Test
    public void testFindArtemWithException()throws Exception{

        artemAreYouHere();
        assertFalse("Artem found", x == true);

    }

    public boolean artemAreYouHere(){

        try {
            driver.findElement(artemXpath);
            return x=true;
        } catch (NoSuchElementException e) {
            System.err.println("Such element not found: " + e.getMessage());
            return x=false;
        }

    }

    public String lookingPersonByName(String PersonName) {

        List<WebElement> element = driver.findElements(skillsUpTeam);

        for (WebElement i : element) {
            memberText = i.getText();
            if (memberText.contains(PersonName)) {
                System.out.println(PersonName + " found!!");
                System.out.println(memberText + "\n");
                return memberText;
            }
        }
        return memberText;
    }


}








