package modules.UserInterface;

import pages.GameLobby;
import utilities.handlers.VerificationHandler;

public class UITest3 extends UserInterface {

    public static void verify() {
        System.out.println();
        System.out.println("Module: USER INTERFACE");
        System.out.println("Test Case: 3");
        System.out.println("Actual Results: ");

        VerificationHandler.verifyIfDisplayed(GameLobby.Button.TableLimits, 5);
        VerificationHandler.verifyIfDisplayed(GameLobby.Container.DealerTables, 5);
        VerificationHandler.verifyIfDisplayed(GameLobby.Button.Back, 5);
        VerificationHandler.verifyIfDisplayed(GameLobby.Button.HideShowBalance, 5);
        VerificationHandler.verifyIfDisplayed(GameLobby.Label.Balance, 5);
        VerificationHandler.verifyIfDisplayed(GameLobby.Container.DealerPhotos, 5);
        VerificationHandler.verifyIfDisplayed(GameLobby.Label.DealerNames, 5);
        VerificationHandler.verifyIfDisplayed(GameLobby.Label.TableNames, 5);
        VerificationHandler.verifyIfDisplayed(GameLobby.Container.RoadMaps, 5);
        VerificationHandler.verifyIfDisplayed(GameLobby.Label.RedCounters, 5);
        VerificationHandler.verifyIfDisplayed(GameLobby.Label.BlackCounters, 5);
        VerificationHandler.verifyIfDisplayed(GameLobby.Label.ZeroCounters, 5);
        VerificationHandler.verifyIfDisplayed(GameLobby.Label.TotalRoundCounters, 5);

        System.out.println();
    }

}
