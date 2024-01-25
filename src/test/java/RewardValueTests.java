import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardValueTests {

    @Test
    void create_with_cash_value() {
        double cashValue = 100;
        var rewardValue = new RewardValue(cashValue);
        assertEquals(cashValue, rewardValue.getCashValue());
    }

    @Test
    void create_with_miles_value() {
        int milesValue = 10000;
        var rewardValue = new RewardValue(milesValue);
        assertEquals(milesValue, rewardValue.getMilesValue());
    }
    static final double MILES_TO_CASH_CONVERSION_RATE = 0.0035;
    @Test
    void convert_from_cash_to_miles() {
        double cashValue = 100;
        int milesValue = (int) (cashValue / MILES_TO_CASH_CONVERSION_RATE);
        int rewardValue = RewardValue.convertToMiles((int) cashValue);
        assertEquals(milesValue, rewardValue);
    }

    @Test
    void convert_from_miles_to_cash() {
        double milesValue = 10000;
        double cashValue = milesValue * MILES_TO_CASH_CONVERSION_RATE;
        double rewardValue = RewardValue.convertToCash((int) milesValue);
        assertEquals(cashValue, rewardValue);
    }
}
