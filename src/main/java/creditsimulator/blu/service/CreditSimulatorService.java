package creditsimulator.blu.service;

import creditsimulator.blu.model.VehicleLoan;

import java.text.DecimalFormat;

// import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

@Service
public class CreditSimulatorService {

    private static final DecimalFormat CURRENCY_FORMAT = new DecimalFormat("Rp #,##0.00");
    private static double baseRate;

    public void calculateLoan(VehicleLoan loan) {
        baseRate = loan.getBaseRate();
        double principal = loan.getLoanAmount() - loan.getDownPayment();
        int tenor = loan.getTenor();
        int totalMonths = tenor * 12;

        System.out.println("===== Simulasi Kredit =====");
        
        for (int year = 1; year <= tenor; year++) {
            if (year == 3) {
                System.out.println(year);
            }
            
            // Hitung suku bunga berdasarkan aturan yang diberikan
            double newRate = calculateInterestRate(year); // Konversi ke desimal
            if (year > 1) {
                baseRate += newRate;
            }
            // Update principal dengan suku bunga tahun ini
            principal = principal * (1 + baseRate/100);

            // Hitung jumlah bulan yang tersisa
            int monthsLeft = totalMonths - (year - 1) * 12;

            // Hitung cicilan bulanan menggunakan metode amortisasi
            double monthlyInstallment = principal / monthsLeft;
            double yearlyInstallment = monthlyInstallment * 12;

            // Kurangi pokok pinjaman setelah pembayaran tahunan
            principal -= yearlyInstallment;

            // Cetak hasil cicilan per bulan dan suku bunga
            System.out.printf("Tahun %d : %s/bln , Suku Bunga : %.1f%%\n",
                    year, CURRENCY_FORMAT.format(monthlyInstallment), baseRate);
        }

    }

    private double calculateInterestRate(int year) {
        if (year == 1) {
            return baseRate;
        }

        if (year % 2 == 0) {
            return 0.1; // Jika tahun genap, suku bunga naik 0.1%
        } else {
            return 0.5; // Jika tahun ganjil (setelah tahun pertama), suku bunga naik 0.5%
        }
    }
}


