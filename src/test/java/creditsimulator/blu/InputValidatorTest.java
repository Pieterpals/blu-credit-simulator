package creditsimulator.blu;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import creditsimulator.blu.util.InputValidator;

public class InputValidatorTest {
        @Test
    void testValidYearForNewVehicle() {
        assertTrue(InputValidator.isValidYear("New", 2024)); // Current year
        assertFalse(InputValidator.isValidYear("New", 2022)); // Too old
    }

    @Test
    void testValidTenor() {
        assertTrue(InputValidator.isValidTenor(3)); // Allowed
        assertFalse(InputValidator.isValidTenor(7)); // More than 6 years
        assertFalse(InputValidator.isValidTenor(0)); // Below 1 year
    }

    @Test
    void testValidDownPaymentNew() {
        assertTrue(InputValidator.isValidDownPaymentNew(35000000, 100000000)); // 35%
        assertFalse(InputValidator.isValidDownPaymentNew(34000000, 100000000)); // Below 35%
    }

    @Test
    void testValidDownPaymentUsed() {
        assertTrue(InputValidator.isValidDownPaymentUsed(25000000, 100000000)); // 25%
        assertFalse(InputValidator.isValidDownPaymentUsed(24000000, 100000000)); // Below 25%
    }
}
