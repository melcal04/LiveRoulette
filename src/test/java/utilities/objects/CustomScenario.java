package utilities.objects;

import io.cucumber.java.Scenario;

import java.net.URI;
import java.nio.file.Paths;

/*********************************************************************************************************************
 ** This object class is customized to manage the information for each scenario.
 *********************************************************************************************************************/

@SuppressWarnings("unused")
public class CustomScenario {

    /* ? *******************************************************************************************************************
    ? THESE ARE THE LIST OF CLASS METHODS
    ? - public String getName()
    ? - public String getFeature()
    ? - public boolean isFailed()
    ? - public void attach(byte[] data, String mediaType, String name)
    ? **********************************************************************************************************************/

    @SuppressWarnings("unused")
    private final Scenario scenario;

    @SuppressWarnings("unused")
    public CustomScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return this.scenario.getName().replace(":", "");
    }

    @SuppressWarnings("unused")
    public String getFeature() {
        return Paths.get(URI.create(String.valueOf(this.scenario.getUri()))).getFileName().toString().replace(".feature", "");
    }

    @SuppressWarnings("unused")
    public boolean isFailed() { return this.scenario.isFailed(); }

    @SuppressWarnings("unused")
    public void attach(byte[] data, String mediaType, String name) {
        this.scenario.attach(data, mediaType, name);
    }

}