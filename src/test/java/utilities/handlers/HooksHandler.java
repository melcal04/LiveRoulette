package utilities.handlers;

import io.cucumber.java.Scenario;
import utilities.settings.Variables;

public class HooksHandler extends Variables {

    /***************************************************************************************************************
     * The 'beforeScenario' method runs before the scenario begins.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void beforeScenario() { init(); }

    /***************************************************************************************************************
     * The 'afterScenario' method runs after the scenario begins.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void afterScenario() { }

    /***************************************************************************************************************
     * The 'beforeStep' method runs before each step begins.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void beforeStep(Scenario scenario) {
        setScenario(scenario);
    }

    /***************************************************************************************************************
     * The 'afterStep' method runs after each step begins.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            if (!scenarioName.contains("RS Test") && !scenarioName.contains("PO Test")) {
                FileHandler.Image.capture(scenarioName, "errors", true);
            }
        }
    }

}
