package creditsimulator.blu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import creditsimulator.blu.controller.CreditSimulatorController;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {
    private final CreditSimulatorController controller;

    public MainApplication(CreditSimulatorController controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (args.length > 0) {
            controller.loadFromFile(args[0]);
        } else {
            controller.startConsoleMenu();
        }
    }
}