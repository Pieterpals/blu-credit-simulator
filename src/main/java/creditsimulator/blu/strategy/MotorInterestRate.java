package creditsimulator.blu.strategy;

/**
 * Strategi suku bunga untuk kendaraan Motor.
 */
public class MotorInterestRate implements InterestRateStrategy {
    
    @Override
    public double getBaseRate() {
        return 9.0; // Bunga dasar untuk motor
    }
}
