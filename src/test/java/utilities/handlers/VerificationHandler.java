package utilities.handlers;

import utilities.objects.Locator;
import utilities.objects.CustomAssert;

@SuppressWarnings("unused")
public class VerificationHandler {

    /* ? *******************************************************************************************************************
    ? THESE ARE THE LIST OF CLASS METHODS
    ? - public static void verifyIfDisplayed(Locator locator, int seconds)
    ? - public static void verifyIfNotDisplayed(Locator locator, int seconds)
    ? - public static void verifyIfContained(Locator locator, String target, String message)
    ? - public static void verifyIfNotContained(Locator locator, String target, String message)
    ? - public static void verifyIfContained(Locator locator, String attribute, String target, String message)
    ? - public static void verifyIfNotContained(Locator locator, String attribute, String target, String message)
    ? **********************************************************************************************************************/

    /*********************************************************************************************************************
     ** The 'verifyIfDisplayed' method is used to confirm the visibility of an element
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void verifyIfDisplayed(Locator locator, int seconds) {
        String name = locator.getName();
        String type = locator.getType();
        String page = locator.getPage();
        CustomAssert.assertTrue(ConditionHandler.isDisplayed(locator, seconds),
                "** \"" + name + "\" " + type + " on " + page + " is Displayed",
                "** \"" + name + "\" " + type + " on " + page + " is Not Displayed");
    }

    /*********************************************************************************************************************
     ** The 'verifyIfNotDisplayed' method is used to confirm the invisibility of an element
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void verifyIfNotDisplayed(Locator locator, int seconds) {
        String name = locator.getName();
        String type = locator.getType();
        String page = locator.getPage();
        CustomAssert.assertFalse(ConditionHandler.isDisplayed(locator, seconds),
                "** \"" + name + "\" " + type + " on " + page + " is Not Displayed",
                "** \"" + name + "\" " + type + " on " + page + " is Displayed");
    }

    /*********************************************************************************************************************
     ** The 'verifyIfContained' method confirms the presence of text in an element's displayed text
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void verifyIfContained(Locator locator, String target, String message) {
        String name = locator.getName();
        String type = locator.getType();
        String page = locator.getPage();
        CustomAssert.assertTrue(GetHandler.getText(locator).contains(target),
                "** \"" + name + "\" " + type + " on " + page + " is " + message,
                "** \"" + name + "\" " + type + " on " + page + " is Not " + message);
    }

    /*********************************************************************************************************************
     ** The 'verifyIfNotContained' method confirms the absence of text in an element's displayed text
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void verifyIfNotContained(Locator locator, String target, String message) {
        String name = locator.getName();
        String type = locator.getType();
        String page = locator.getPage();
        CustomAssert.assertFalse(GetHandler.getText(locator).contains(target),
                "** \"" + name + "\" " + type + " on " + page + " is " + message,
                "** \"" + name + "\" " + type + " on " + page + " is Not " + message);
    }

    /*********************************************************************************************************************
     ** The 'verifyIfContained' method confirms the presence of text in an element's attribute
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void verifyIfContained(Locator locator, String attribute, String target, String message) {
        String name = locator.getName();
        String type = locator.getType();
        String page = locator.getPage();
        CustomAssert.assertTrue(GetHandler.getAttribute(locator, attribute).contains(target),
                "** \"" + name + "\" " + type + " on " + page + " is " + message,
                "** \"" + name + "\" " + type + " on " + page + " is Not " + message);
    }

    /*********************************************************************************************************************
     ** The 'verifyIfNotContained' method confirms the absence of text in an element's attribute
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void verifyIfNotContained(Locator locator, String attribute, String target, String message) {
        String name = locator.getName();
        String type = locator.getType();
        String page = locator.getPage();
        CustomAssert.assertFalse(GetHandler.getAttribute(locator, attribute).contains(target),
                "** \"" + name + "\" " + type + " on " + page + " is " + message,
                "** \"" + name + "\" " + type + " on " + page + " is Not " + message);
    }

}
