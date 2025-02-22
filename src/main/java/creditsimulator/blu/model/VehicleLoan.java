package creditsimulator.blu.model;
import jakarta.validation.constraints.*;
import creditsimulator.blu.strategy.InterestRateStrategy;

/**
 * Model untuk menyimpan data pinjaman kendaraan.
 */
public class VehicleLoan {
    @NotNull
    private String type;

    @NotNull
    private String condition;

    private int year;

    @Min(1) @Max(1_000_000_000)
    private double loanAmount;

    @Min(1) @Max(6)
    private int tenor;

    @Min(0)
    private double downPayment;

    private InterestRateStrategy interestRateStrategy;

    public VehicleLoan(String type, String condition, int year, double loanAmount, int tenor, double downPayment, InterestRateStrategy interestRateStrategy) {
        this.type = type;
        this.condition = condition;
        this.year = year;
        this.loanAmount = loanAmount;
        this.tenor = tenor;
        this.downPayment = downPayment;
        this.interestRateStrategy = interestRateStrategy;
    }

    // Getter untuk baseRate
    public double getBaseRate() {
        return interestRateStrategy.getBaseRate();
    }

    // Getter untuk Loan Amount
    public double getLoanAmount() {
        return loanAmount;
    }

    // Getter untuk Down Payment
    public double getDownPayment() {
        return downPayment;
    }

    // Getter untuk Tenor
    public int getTenor() {
        return tenor;
    }

    // Getter tambahan jika diperlukan
    public String getType() {
        return type;
    }

    public String getCondition() {
        return condition;
    }

    public int getYear() {
        return year;
    }
}
