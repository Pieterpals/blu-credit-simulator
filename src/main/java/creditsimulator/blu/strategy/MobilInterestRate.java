package creditsimulator.blu.strategy;

/**
 * Strategi suku bunga untuk kendaraan Mobil.
 */
public class MobilInterestRate implements InterestRateStrategy {
    
    @Override
    public double getBaseRate() {
        return 8.0; // Bunga dasar untuk mobil
    }
}
