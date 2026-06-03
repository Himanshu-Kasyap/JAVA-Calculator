import java.util.Scanner;

/**
 * A simple command-line interface (CLI) calculator that supports
 * addition, subtraction, multiplication, and division.
 * 
 * Demonstrates basic input/output, exception handling, loop control,
 * and switch-case statement flow.
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("========================================");
        System.out.println("      Welcome to the CLI Calculator      ");
        System.out.println("========================================");
        System.out.println("Operations: Addition (+), Subtraction (-),");
        System.out.println("            Multiplication (*), Division (/)");
        System.out.println("Type 'exit' at any prompt to quit the program.");
        System.out.println("========================================\n");

        while (keepRunning) {
            try {
                // 1. Get first operand
                System.out.print("Enter the first number: ");
                String input1 = scanner.next().trim();
                if (input1.equalsIgnoreCase("exit")) {
                    break;
                }
                double num1;
                try {
                    num1 = Double.parseDouble(input1);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid number. Please enter a numeric value.\n");
                    continue;
                }

                // 2. Get operator
                System.out.print("Enter an operator (+, -, *, /): ");
                String operator = scanner.next().trim();
                if (operator.equalsIgnoreCase("exit")) {
                    break;
                }

                if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")) {
                    System.out.println("Error: Invalid operator. Please use +, -, *, or /.\n");
                    continue;
                }

                // 3. Get second operand
                System.out.print("Enter the second number: ");
                String input2 = scanner.next().trim();
                if (input2.equalsIgnoreCase("exit")) {
                    break;
                }
                double num2;
                try {
                    num2 = Double.parseDouble(input2);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid number. Please enter a numeric value.\n");
                    continue;
                }

                // 4. Perform calculation using switch-case
                double result = 0;
                boolean validCalculation = true;

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            System.out.println("Error: Division by zero is not allowed.\n");
                            validCalculation = false;
                        } else {
                            result = num1 / num2;
                        }
                        break;
                    default:
                        System.out.println("Error: Unknown operator.");
                        validCalculation = false;
                        break;
                }

                if (validCalculation) {
                    // Display results nicely formatted
                    System.out.printf("Result: %s %s %s = %s\n\n", 
                        formatNumber(num1), operator, formatNumber(num2), formatNumber(result));
                }

            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage() + "\n");
                scanner.nextLine(); // Clear scanner buffer
            }
        }

        System.out.println("Thank you for using the CLI Calculator. Goodbye!");
        scanner.close();
    }

    /**
     * Formats numbers to display as integers if there are no decimal places.
     * e.g., 5.0 -> "5", 5.25 -> "5.25"
     */
    private static String formatNumber(double num) {
        if (num == (long) num) {
            return String.format("%d", (long) num);
        } else {
            return String.format("%s", num);
        }
    }
}
