package utilities.handlers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.enums.HandleCollection;
import utilities.objects.Locator;
import utilities.objects.Printer;
import settings.AutomationSetup;

@SuppressWarnings("unused")
public class EventHandler extends AutomationSetup {

    /* ? *******************************************************************************************************************
    ? THESE ARE THE LIST OF EVENT METHODS
    ? - public static void sendKeys(Component component, String input)
    ? - public static void select(Component component, String value)
    ? - public static void click(Component component)
    ? - public static void click(Component component, HandleCollection handleCollection)
    ? - public static void click(Component component, int seconds)
    ? - public static void click(WebElement element)
    ? - public static void click(WebElement element, HandleCollection handleCollection)
    ? - public static void click(int xCoordinate, int yCoordinate)
    ? - public static void scroll(Locator locator)
    ? - public static void scroll(WebElement element)
    ? - public static void pressAndHold(Locator locator, int seconds)
    ? **********************************************************************************************************************/

    /*********************************************************************************************************************
     ** The 'sendKeys' method is used for inputting data into the located element.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void sendKeys(Locator locator, String input) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator.getPath())).sendKeys(input);
        } catch (Exception e) {
            String name = locator.getName();
            String type = locator.getType();
            String page = locator.getPage();
            Printer.printError("Failed to input \"" + input + "\" in \"" + name + "\" " + type + " on " + page);
            throw e;
        }
    }

    /*********************************************************************************************************************
     ** The 'select' method is used for selecting an option within the located element.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void select(Locator locator, String value) {
        try {
            new Select(wait.until(ExpectedConditions.elementToBeClickable(locator.getPath()))).selectByVisibleText(value);
        } catch (Exception e) {
            String name = locator.getName();
            String type = locator.getType();
            String page = locator.getPage();
            Printer.printError("Failed to select \"" + value + "\" in \"" + name + "\" " + type + " on " + page);
            throw e;
        }
    }

    /*********************************************************************************************************************
     ** The 'click' method is used for clicking the located element.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void click(Locator locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator.getPath())).click();
        } catch (Exception e) {
            String name = locator.getName();
            String type = locator.getType();
            String page = locator.getPage();
            Printer.printError("Failed to click \"" + name + "\" " + type + " on " + page);
            throw e;
        }
    }

    /*********************************************************************************************************************
     ** The 'click' method is used for clicking the located element with exception or with scroll.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void click(Locator locator, HandleCollection handleCollection) {
        switch (handleCollection) {
            case WithException:
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(locator.getPath())).click();
                } catch (Exception e) { /* Exclude the exception. */ }
                break;
            case WithScroll:
                try {
                    WebElement element = driver.findElement(locator.getPath());
                    jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
                    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                } catch (Exception e) {
                    String name = locator.getName();
                    String type = locator.getType();
                    String page = locator.getPage();
                    Printer.printError("Failed to click \"" + name + "\" " + type + " on " + page + " with scroll");
                    throw e;
                }
                break;
            case WithJavaScript:
                try {
                    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator.getPath()));
                    jsExecutor.executeScript("arguments[0].click();", element);
                } catch (Exception e) {
                    String name = locator.getName();
                    String type = locator.getType();
                    String page = locator.getPage();
                    Printer.printError("Failed to click \"" + name + "\" " + type + " on " + page + " with JavaScript");
                    throw e;
                }
                break;
        }
    }

    /*********************************************************************************************************************
     ** The 'click' method is used for clicking the located element, then waiting a few seconds.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void click(Locator locator, int seconds) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator.getPath())).click();
            WaitHandler.wait(seconds);
        } catch (Exception e) {
            String name = locator.getName();
            String type = locator.getType();
            String page = locator.getPage();
            Printer.printError("Failed to click \"" + name + "\" " + type + " on " + page +
                    " then wait " + seconds + " seconds");
            throw e;
        }
    }

    /*********************************************************************************************************************
     ** The 'click' method is used for clicking the element directly.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void click(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            Printer.printError("Failed to click \"" + element.getText() + "\" web element");
            throw e;
        }
    }

    /*********************************************************************************************************************
     ** The 'click' method is used for clicking the element directly with exception or with scroll.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void click(WebElement element, HandleCollection handleCollection) {
        switch (handleCollection) {
            case WithException:
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                } catch (Exception e) { /* Exclude the exception. */ }
                break;
            case WithScroll:
                try {
                    jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
                    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                } catch (Exception e) {
                    Printer.printError("Failed to click \"" + element.getText() + "\" web element with scroll");
                    throw e;
                }
                break;
            case WithJavaScript:
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(element));
                    jsExecutor.executeScript("arguments[0].click();", element);
                } catch (Exception e) {
                    Printer.printError("Failed to click \"" + element.getText() + "\" web element with JavaScript");
                    throw e;
                }
                break;
        }
    }

    /*********************************************************************************************************************
     ** The 'click' method is used for clicking a specific coordinates on a web page.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void click(int xCoordinate, int yCoordinate) {
        try {
            actions.moveByOffset(xCoordinate, yCoordinate).click().perform();
        } catch (Exception e) {
            Printer.printError("Failed to click in location of {" + xCoordinate + ", " + yCoordinate + "}");
            throw e;
        }
    }

    /*********************************************************************************************************************
     ** The 'scroll' method is used to navigate and view the located element.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void scroll(Locator locator) {
        try {
            WebElement element = driver.findElement(locator.getPath());
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            String name = locator.getName();
            String type = locator.getType();
            String page = locator.getPage();
            Printer.printError("Failed to scroll \"" + name + "\" " + type + " on " + page);
            throw e;
        }
    }

    /*********************************************************************************************************************
     ** The 'scroll' method is used to navigate and view the element directly.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void scroll(WebElement element) {
        try {
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            Printer.printError("Failed to scroll \"" + element.getText() + "\" web element");
            throw e;
        }
    }

    /*********************************************************************************************************************
     ** The 'pressAndHold' method is used to press and hold the located element for a specific duration.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void pressAndHold(Locator locator, int seconds) {
        try {
            int millis = seconds * 1000;
            actions.clickAndHold(wait.until(ExpectedConditions.elementToBeClickable(locator.getPath()))).perform();
            actions.pause(millis).perform();
            actions.release().perform();
        } catch (Exception e) {
            String name = locator.getName();
            String type = locator.getType();
            String page = locator.getPage();
            Printer.printError("Failed to press and hold \"" + name + "\" " + type + " on " + page);
            throw e;
        }
    }

}
