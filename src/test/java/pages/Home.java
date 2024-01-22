package pages;

import utilities.objects.Component;

public class Home {

    /***************************************************************************************************************
     * These are the thumbnail components on the Home Page.
     ***************************************************************************************************************/

    public static class Thumbnail {
        public static Component LiveCasino = new Component(
                "Live Casino",
                "Thumbnail",
                "Home Page",
                "//div[text()='Live Casino']/ancestor::div[1]"
        );
    }

}
