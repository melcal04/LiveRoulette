package utilities.handlers;

import settings.AutomationSetup;

import java.io.*;

@SuppressWarnings("unused")
public class DirectoryHandler extends AutomationSetup {

    /* ? *******************************************************************************************************************
    ? THESE ARE THE LIST OF GET METHODS
    ? - public static String getFeaturePath()
    ? - public static String getTextFilePath()
    ? - public static String getScreenshotPath(String folderName)
    ? **********************************************************************************************************************/

    private static final String RESULTS_PATH = System.getProperty("user.dir") + "\\results";
    private static final String SCREENSHOTS_FOLDER = "\\screenshots";

    /*********************************************************************************************************************
     ** The 'getFeaturePath' method is utilized to retrieve directories for each module.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String getFeaturePath() {
        return createDirectory(RESULTS_PATH + "\\" + scenario.getFeature());
    }

    /*********************************************************************************************************************
     ** The 'getTextFilePath' method is used to get directories for storing test results and generating text file.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String getTextFilePath() {
        return createDirectory(RESULTS_PATH);
    }

    /*********************************************************************************************************************
     ** The 'getScreenshotPath' method is used to get directories for storing screenshots for each module.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    public static String getScreenshotPath(String folderName) {
        return createDirectory(getFeaturePath() + SCREENSHOTS_FOLDER + "\\" + folderName);
    }

    /*********************************************************************************************************************
     ** The 'createDirectory' method is used to create a specific folder within the test directory.
     *********************************************************************************************************************/

    @SuppressWarnings("unused")
    private static String createDirectory(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            boolean success = folder.mkdirs();
            if (success) System.out.println();
            else System.err.println();
        }
        return path;
    }

}
