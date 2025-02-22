package creditsimulator.blu.util;

import java.util.Scanner;
import java.util.function.Predicate;

public class UserInputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Generic method to get validated user input.
     *
     * @param prompt       The message to display to the user.
     * @param errorMessage The error message to display if validation fails.
     * @param parser       The function to convert input to the required type.
     * @param validator    The function to validate the parsed input.
     * @param <T>          The type of input expected (String, Integer, Double, etc.).
     * @return A validated input of type T.
     */
    public static <T> T getValidatedInput(String prompt, String errorMessage, InputParser<T> parser, Predicate<T> validator) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                T parsedValue = parser.parse(input);
                if (!validator.test(parsedValue)) {
                    System.out.println("ERROR: " + errorMessage);
                    continue;
                }

                return parsedValue;
            } catch (Exception e) {
                System.out.println("ERROR: Invalid format. Please enter a valid value.");
            }
        }
    }

    /**
     * Generic method to get validated input from a file.
     *
     * @param fileScanner  The Scanner object reading from the file.
     * @param errorMessage The error message to display if validation fails.
     * @param parser       The function to convert input to the required type.
     * @param validator    The function to validate the parsed input.
     * @param <T>          The type of input expected (String, Integer, Double, etc.).
     * @return A validated input of type T, or null if file ends unexpectedly.
     */
    public static <T> T getValidatedFileInput(Scanner fileScanner, String errorMessage, InputParser<T> parser, Predicate<T> validator) {
        try {
            if (!fileScanner.hasNextLine()) {
                throw new Exception("File ended unexpectedly.");
            }

            String input = fileScanner.nextLine().trim();

            T parsedValue = parser.parse(input);
            if (validator.test(parsedValue)) {
                return parsedValue;
            }
            System.out.println("ERROR: " + errorMessage);
        } catch (Exception e) {
            System.out.println("ERROR: Invalid format in file. Please check the input file.");
        }

        return null;
    }
    
    /**
     * Functional interface for input parsing.
     */
    @FunctionalInterface
    public interface InputParser<T> {
        T parse(String input) throws Exception;
    }
}