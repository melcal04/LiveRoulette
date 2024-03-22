package utilities.interfaces;

import java.util.List;

/*********************************************************************************************************************
 ** This interface represents the test case for 'Payout' module and is utilized with lambda expressions.
 *********************************************************************************************************************/

@SuppressWarnings("unused")
public interface PayoutTestCase {
    int getTestCase();
    void placeBettingOption();
    void checkBettingChip();
    void computeWinResult(String[] roundResult);
    void saveTestCase(String[] roundResult, List<PayoutTestCase> payoutTestCaseList);
}
