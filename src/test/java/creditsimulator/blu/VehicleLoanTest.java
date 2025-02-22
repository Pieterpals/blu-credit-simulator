package creditsimulator.blu;

import creditsimulator.blu.strategy.InterestRateStrategy;
import creditsimulator.blu.strategy.MobilInterestRate;
import creditsimulator.blu.model.VehicleLoan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleLoanTest {

    @Test
    void testVehicleLoanGetters() {
        InterestRateStrategy interestRateStrategy = new MobilInterestRate();
        VehicleLoan loan = new VehicleLoan("Mobil", "New", 2024, 100_000_000, 3, 35_000_000, interestRateStrategy);

        assertEquals("Mobil", loan.getType());
        assertEquals("New", loan.getCondition());
        assertEquals(2024, loan.getYear());
        assertEquals(100_000_000, loan.getLoanAmount());
        assertEquals(35_000_000, loan.getDownPayment());
        assertEquals(3, loan.getTenor());
        assertEquals(8.0, loan.getBaseRate()); // Base rate untuk mobil adalah 8%
    }
}
