package creditsimulator.blu;

import creditsimulator.blu.service.CreditSimulatorService;
import creditsimulator.blu.model.VehicleLoan;
import creditsimulator.blu.strategy.MobilInterestRate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditSimulatorServiceTest {
    private CreditSimulatorService service;

    @BeforeEach
    void setUp() {
        service = new CreditSimulatorService();
    }

    @Test
    void testCalculateLoan() {
        VehicleLoan loan = new VehicleLoan("Mobil", "New", 2024, 100_000_000, 3, 35_000_000, new MobilInterestRate());

        assertDoesNotThrow(() -> service.calculateLoan(loan));
    }
}
