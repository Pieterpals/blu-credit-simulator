package creditsimulator.blu.controller;

import creditsimulator.blu.factory.VehicleLoanFactory;
import creditsimulator.blu.model.VehicleLoan;  // Ensure this is imported
import creditsimulator.blu.service.CreditSimulatorService;
import creditsimulator.blu.util.InputValidator;
// import creditsimulator.blu.util.InputValidator;
import creditsimulator.blu.util.UserInputHelper;

import java.io.FileNotFoundException;
import java.io.File;
// import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.stereotype.Controller;


@Controller
public class CreditSimulatorController {
    private final CreditSimulatorService service;

    public CreditSimulatorController(CreditSimulatorService service) {
        this.service = service;
    }

  public void startConsoleMenu() {
    System.out.println("===== Credit Simulator =====");

    // Validasi dilakukan di sini sebelum objek dibuat
    String type = UserInputHelper.getValidatedInput(
            "Enter vehicle type (Motor/Mobil): ",
            "Vehicle type must be 'Motor' or 'Mobil'.",
            input -> input,
            input -> input.equalsIgnoreCase("Motor") || input.equalsIgnoreCase("Mobil")
    );

    String condition = UserInputHelper.getValidatedInput(
            "Enter vehicle condition (New/Used): ",
            "Vehicle condition must be 'New' or 'Used'.",
            input -> input,
            input -> input.equalsIgnoreCase("New") || input.equalsIgnoreCase("Used")
    );

    int year = UserInputHelper.getValidatedInput(
            "Enter vehicle year: ",
            "NEW vehicles must have a year >= (current year - 1).",
            Integer::parseInt,
            input -> InputValidator.isValidYear(condition, input)
    );

    double loanAmount = UserInputHelper.getValidatedInput(
            "Enter loan amount (max 1B): ",
            "Loan amount must be between 1 and 1,000,000,000.",
            Double::parseDouble,
            input -> input > 0 && input <= 1_000_000_000
    );

    int tenor = UserInputHelper.getValidatedInput(
            "Enter tenor (1-6 years): ",
            "Tenor must be between 1 and 6 years.",
            Integer::parseInt,
            InputValidator::isValidTenor
    );

    double downPayment = UserInputHelper.getValidatedInput(
            "Enter down payment: ",
            "Down Payment does not meet the minimum requirement.",
            Double::parseDouble,
            input -> condition.equalsIgnoreCase("New") ?
                    InputValidator.isValidDownPaymentNew(input, loanAmount) :
                    InputValidator.isValidDownPaymentUsed(input, loanAmount)
    );

    // Jika semua input valid, baru buat objek VehicleLoan
    VehicleLoan loan = VehicleLoanFactory.createVehicleLoan(type, condition, year, loanAmount, tenor, downPayment);
    service.calculateLoan(loan);
    }


    public void loadFromFile(String filePath) {
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            System.out.println("📂 Loading data from file: " + filePath);

            String type = fileScanner.nextLine().trim();
            String condition = fileScanner.nextLine().trim();
            int year = Integer.parseInt(fileScanner.nextLine().trim());
            double loanAmount = Double.parseDouble(fileScanner.nextLine().trim());
            int tenor = Integer.parseInt(fileScanner.nextLine().trim());
            double downPayment = Double.parseDouble(fileScanner.nextLine().trim());

            try {
                VehicleLoan loan = VehicleLoanFactory.createVehicleLoan(type, condition, year, loanAmount, tenor, downPayment);
                service.calculateLoan(loan);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }

        } catch (FileNotFoundException e) {
            System.err.println("ERROR: File not found - " + filePath);
        } catch (Exception e) {
            System.err.println("ERROR: Invalid file format. Please check the input.");
        }
    }

    
}
