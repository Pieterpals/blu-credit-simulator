package creditsimulator.blu.util;

import java.time.Year;

public class InputValidator {
    public static boolean isValidLoanAmount(double amount) {
        return amount > 0 && amount <= 1_000_000_000;
    }

    public static boolean isValidTenor(int tenor) {
        return tenor >= 1 && tenor <= 6;
    }

    public static boolean isValidYear(String condition, int year) {
        int currentYear = Year.now().getValue();
        if (condition.equalsIgnoreCase("New") && year < currentYear - 1) {
            return false;
        }
        return true;
    }

    public static boolean isValidDownPaymentNew(double downPayment, double loanAmount) {
        return downPayment >= (0.35 * loanAmount);
    }

    public static boolean isValidDownPaymentUsed(double downPayment, double loanAmount) {
        return downPayment >= (0.25 * loanAmount);
    }
}
