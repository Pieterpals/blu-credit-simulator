package creditsimulator.blu.factory;

import creditsimulator.blu.model.VehicleLoan;
import creditsimulator.blu.strategy.InterestRateStrategy;
import creditsimulator.blu.strategy.MobilInterestRate;
import creditsimulator.blu.strategy.MotorInterestRate;

public class VehicleLoanFactory {
    /**
     * Membuat objek VehicleLoan dengan validasi dari InputValidator
     */
    public static VehicleLoan createVehicleLoan(String type, String condition, int year, double loanAmount, int tenor, double downPayment) {
         // Tentukan strategi suku bunga berdasarkan jenis kendaraan
         InterestRateStrategy interestRateStrategy = type.equalsIgnoreCase("Mobil") ? 
         new MobilInterestRate() : new MotorInterestRate();

        // Membuat Object Berdasarkan Vehicle Type
        return new VehicleLoan(type, condition, year, loanAmount, tenor, downPayment, interestRateStrategy);
    }
}
