package modules.Gameplay;

import org.openqa.selenium.WebElement;
import pages.DealerTable;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.objects.CustomAssert;
import utilities.objects.Locator;

import java.util.List;

public class GameTest6 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 6");
        System.out.println("Actual Results: ");

        Locator chipOptions = DealerTable.Button.ChipOptions;
        List<WebElement> chipOptionList = GetHandler.getElements(chipOptions);
        for (WebElement chipOption : chipOptionList) {
            EventHandler.click(chipOption);
            CustomAssert.assertFalse(chipOption.getAttribute("class").contains("disabled"),
                    "** " + chipOption.getText() + " Chip is Highlighted",
                    "** " + chipOption.getText() + " Chip is Not Highlighted");
            for (WebElement otherOption : chipOptionList) {
                if (otherOption != chipOption) {
                    CustomAssert.assertTrue(otherOption.getAttribute("class").contains("disabled"),
                            "** " + otherOption.getText() + " Chip is Dimmed",
                            "** " + otherOption.getText() + " Chip is Not Dimmed");
                }
            }
        }

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
