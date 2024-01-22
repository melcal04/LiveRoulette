package utilities.handlers;

import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.objects.Component;
import utilities.settings.Variables;

public class ConditionHandler extends Variables {

    /***************************************************************************************************************
     * The 'isUrlContains' method checks if the URL contains a specific text.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean isUrlContains(String text) {
        try {
            wait.until(ExpectedConditions.urlContains(text));
            return true;
        } catch (Exception e) { return false; }
    }

    /***************************************************************************************************************
     * The 'isDisplayed' method checks if the element is visible.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean isDisplayed(Component component) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(component.getPath()));
            return driver.findElement(component.getPath()).isDisplayed();
        } catch (Exception e) { return false; }
    }

    /***************************************************************************************************************
     * The 'isEmpty' method checks if the element is empty.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean isEmpty(Component component) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(component.getPath()));
            return driver.findElements(component.getPath()).isEmpty();
        } catch (Exception e) { return false; }
    }

    /***************************************************************************************************************
     * The 'isEmpty' method checks if the element is present.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean isPresence(Component component) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(component.getPath()));
            return true;
        } catch (Exception e) { return false; }
    }

    /***************************************************************************************************************
     * The 'isEmpty' method checks if the element is selected.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static boolean isSelected(Component component) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(component.getPath()));
            return driver.findElement(component.getPath()).isSelected();
        } catch (Exception e) { return false; }
    }

}
