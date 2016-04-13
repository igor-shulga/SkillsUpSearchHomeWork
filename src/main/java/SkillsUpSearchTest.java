import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SkillsUpSearchTest extends BasePage{
       private By className = new By.ByClassName("member");

    @Test
    public void testLookingForMisha() throws Exception {


        List<WebElement> element = driver.findElements(className);
        for(WebElement i : element)
        {
            String memberText = i.getText();
            if (memberText.contains("Чокан")) {
            System.out.println("Misha found!!");
            System.out.println(memberText);
                break;


            }

         //assertTrue("Misha not found", memberText.contains("Чокан"));


        }

        // looking for Michael Chokan


        //name.contains("Чокан");
        //assertTrue("This not Chuck!", name.contains("Chuck"));
        //System.out.println(element);


    }
}
