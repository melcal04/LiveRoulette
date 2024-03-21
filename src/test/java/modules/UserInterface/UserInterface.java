package modules.UserInterface;

import globals.TestMethods;
import pages.DealerTable;
import utilities.handlers.VerificationHandler;

public class UserInterface extends TestMethods {

    protected static void verifyGameUI() {
        VerificationHandler.verifyIfDisplayed(DealerTable.Button.Back, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Label.TableInfo, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Label.TotalBet, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Button.HideShowBalance, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Label.Balance, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Button.Menu, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Button.SwitchTable, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Button.ExpandShrink, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Button.TableLimit, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Button.Statistics, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Button.Undo, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Button.Double, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Button.Confirm, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Label.NumbersInResultPanel, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Button.ChipOptions, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Button.EditChips, 5);
        VerificationHandler.verifyIfDisplayed(DealerTable.Container.BettingOptions, 5);
    }

}
