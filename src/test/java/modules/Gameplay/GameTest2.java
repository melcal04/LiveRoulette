package modules.Gameplay;

import pages.GameLobby;
import utilities.handlers.EventHandler;
import utilities.handlers.VerificationHandler;

public class GameTest2 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 2");
        System.out.println("Actual Results: ");

        EventHandler.scroll(GameLobby.Label.FirstResultInRoadMap);
        VerificationHandler.verifyIfDisplayed(GameLobby.Label.FirstResultInRoadMap, 5);

        System.out.println();
    }

}
