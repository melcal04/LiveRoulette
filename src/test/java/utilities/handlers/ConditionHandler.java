package utilities.handlers;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.objects.Locator;
import settings.AutomationSetup;

@SuppressWarnings("unused")
public class ConditionHandler extends AutomationSetup {

    /* ? *******************************************************************************************************************
    ? THESE ARE THE LIST OF CONDITION METHODS
    ? - public static boolean isUrlContains(String text, int seconds)
    ? - public static boolean isDisplayed(Component component, int seconds)
    ? - public static boolean isPresent(Component component, int seconds)
    ? - public static boolean isSelected(Component component, int seconds)
    ? **********************************************************************************************************************/

    /*********************************************************************************************************************
     ** The 'isUrlContains' method checks if the URL contains a specific text.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean isUrlContains(String text, int seconds) {
        try {
            new WebDriverWait(driver, seconds).until(ExpectedConditions.urlContains(text));
            return true;
        } catch (Exception e) { return false; }
    }

    /*********************************************************************************************************************
     ** The 'isDisplayed' method checks if the element is visible.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean isDisplayed(Locator locator, int seconds) {
        try {
            new WebDriverWait(driver, seconds)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator.getPath()));
            return true;
        } catch (Exception e) { return false; }
    }

    /*********************************************************************************************************************
     ** The 'isPresent' method checks if the element is present.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean isPresent(Locator locator, int seconds) {
        try {
            new WebDriverWait(driver, seconds)
                    .until(ExpectedConditions.presenceOfElementLocated(locator.getPath()));
            return true;
        } catch (Exception e) { return false; }
    }

    /*********************************************************************************************************************
     ** The 'isSelected' method checks if the element is selected.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean isSelected(Locator locator, int seconds) {
        try {
            return new WebDriverWait(driver, seconds)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator.getPath())).isSelected();
        } catch (Exception e) { return false; }
    }

}
