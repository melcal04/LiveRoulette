package pages;

import utilities.objects.Locator;

public class LiveCasino {

    /***************************************************************************************************************
     * These are the thumbnail components on the Live Casino Page.
     ***************************************************************************************************************/

    public static class Thumbnail {
        public static Locator LiveRouletteRevamp = new Locator(
                "Live Roulette Revamp",
                "Thumbnail",
                "Live Casino Page",
                "//span[contains(text(), 'SBO Live Roulette')]//ancestor::li"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the Live Casino Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Locator CloseBanner = new Locator(
                "Close Banner",
                "Button",
                "Live Casino Page",
                "//div[contains(@class, 'BannerCloseButton')]"
        );
    }

}
