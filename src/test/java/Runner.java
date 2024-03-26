import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                // ! DO NOT EDIT HERE
                monochrome = true,
                plugin = {
                        "pretty",
                        "html:test-output",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                },
                dryRun = false,
                features = "src/test/resources",
                glue = "steps",
                // ! DO NOT EDIT HERE

                /*

                 ? PLEASE READ:

                 ? FOR TEST EXECUTION, THERE ARE 5 DIFFERENT RUNS THAT EXECUTE DIFFERENT FEATURES
                 ? - SHORT RUN IS THE FASTEST RUN THAT EXECUTES SMALL FEATURES AND CAN RUN ANYTIME
                 ? - LONG RUN IS THE RUN THAT EXECUTES BIG FEATURES AND WILL TAKE MORE THAN AN HOUR
                 ? - FULL RUN IS THE RUN THAT EXECUTES ALL FEATURES AT THE SAME TIME
                 ? - RE-RUN IS THE RUN THAT EXECUTES A TARGET SCENARIOS OR FEATURES
                 ? - MAINTENANCE RUN IS THE RUN THAT EXECUTES SPECIFIED FEATURES AFTER MAINTENANCE

                 ? MODULE IS EQUAL TO FEATURE
                 ? TEST CASE IS EQUAL TO SCENARIO

                 ? THESE AUTOMATION TEST WILL RUN BASED ON THESE PRIORITIES:
                 ? 1. PAYOUT MODULE
                 ? 2. BET INFORMATION MODULE
                 ? 3. GAMEPLAY MODULE
                 ? 4. FUNCTIONALITY MODULE
                 ? 5. OTHER MODULES

                TODO: RUN THE TEST AUTOMATION
                * TO RUN, COMMENT THE LINE CODE BY ADDING '//' BEFORE 'tags'
                * IN OPPOSITE, UNCOMMENT THE LINE CODE BY DELETING '//' BEFORE 'tags'

                * NOTE:
                * ONLY ONE 'tags' MUST HAVE NO COMMENT '//'
                * DO NOT EDIT ALL THE 'tags' EXCEPT IN THE RE-RUN 'tags'
                * ALL FEATURES AND SCENARIOS EDITED IN RE-RUN 'tags' MUST BE CORRECT

                */

                // * SHORT RUN
                //tags = "@BetInformation"
                //tags = "@UserInterface"

                // * LONG RUN
                //tags= "@Payout"
                //tags= "@Gameplay"
                //tags= "@Functionality"

                // * FULL RUN
                tags = "@Payout or @BetInformation or @Gameplay or @ResultAndStatistics or @UserInterface"

                // * RE-RUN
                //tags = "@UserInterfaceTest1"

                // * MAINTENANCE RUN
                //tags = "@Maintenance"

        )

public class Runner { }