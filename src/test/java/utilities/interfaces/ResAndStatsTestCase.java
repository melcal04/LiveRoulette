package utilities.interfaces;

/*********************************************************************************************************************
 ** This interface represents the test case for 'Result And Statistics' module and is utilized with lambda expressions.
 *********************************************************************************************************************/

@SuppressWarnings("unused")
public interface ResAndStatsTestCase {
    int getTestCase();
    int getDivision();
    void checkStatistics();
    void saveTestCase(String[] roundResult);
}
