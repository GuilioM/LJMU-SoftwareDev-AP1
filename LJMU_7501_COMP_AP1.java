import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class LJMU_7501_COMP_AP1 {

    public static void main(String[] args) {
        // Create line reader for user input
        String[] programs = {"Basic Input", "Simple Math", "A Currency Converter", "Compound Interest Calculator", "Leap Year", "Quit"};

        do {
            // Asks the instructor to select a program to run
            int choice = JOptionPane.showOptionDialog(null, "Welcome, which program would you like to use?", "LJMU_7501_COMP_AP1", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, programs, programs[0]);

            // Calls the method that runs the program that matches the selected choice
            switch (choice+1) {
                case 1 -> BasicInput();
                case 2 -> SimpleMath();
                case 3 -> CurrencyConverter();
                case 4 -> CompoundInterestCalc();
                case 5 -> LeapYear();
                default -> {
                    JOptionPane.showMessageDialog(null, "Goodbye!", "LJMU_7501_COMP_AP1: Simple Math", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
        }while (true);
    }

    public static void BasicInput () {
        // Declare variables
        String name, dobString, gender;
        int leave;

        do {
            // Prompt the user for their name
            do {
                name = JOptionPane.showInputDialog(null, "Hey, let's get acquainted! \nWhat's your name? ", "LJMU_7501_COMP_AP1: Basic Input", JOptionPane.QUESTION_MESSAGE);
            } while (name.isEmpty());

            // Prompt the user for their date of birth
            dobString = JOptionPane.showInputDialog(null, "When were you born? (yyyy-mm-dd)", "LJMU_7501_COMP_AP1: Basic Input", JOptionPane.QUESTION_MESSAGE);

            // Validate the date of birth format
            while (!dobString.matches("\\d{4}-\\d{2}-\\d{2}")) {
                dobString = JOptionPane.showInputDialog(null, "Invalid date format. Enter your date of birth (yyyy-mm-dd): ", "LJMU_7501_COMP_AP1: Basic Input", JOptionPane.ERROR_MESSAGE);
            }

            // Prompt the user to input their gender
            gender = JOptionPane.showInputDialog(null, "What's your gender?", "LJMU_7501_COMP_AP1: Basic Input", JOptionPane.QUESTION_MESSAGE);

            // Convert the user's date of birth to a LocalDate object
            LocalDate dob = LocalDate.parse(dobString);

            // Calculate the user's age
            LocalDate today = LocalDate.now();
            Period age = Period.between(dob, today);

            // Format the current date as a string
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy");
            String dateString = today.format(formatter);

            // Print the welcome message with the user's name, age, and the current date
            JOptionPane.showMessageDialog(null, "Welcome " + name + ", you are " + age.getYears() + " years old, your gender is " + gender + " and today's date is " + dateString, "LJMU_7501_COMP_AP1: Basic Input", JOptionPane.PLAIN_MESSAGE);
            leave = JOptionPane.showConfirmDialog(null, "Would you like to try again?", "LJMU_7501_COMP_AP1: Basic Input", JOptionPane.YES_NO_OPTION);
        }while (leave== JOptionPane.YES_OPTION);
    }

    public static void SimpleMath () {

        String[] calculations = {"Exit", "Calculate the Sum", "Round a number", "Sum, Stats and Square root"};
        int choice;
        do {
            // Display the menu and prompt the user to choose an option
            choice = JOptionPane.showOptionDialog(null, "Welcome, which program would you like to use?", "LJMU_7501_COMP_AP1: Simple Math", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, calculations, calculations[0]);

            switch (choice) {
                case 1:
                    // Prompt the user to enter two whole numbers
                    int num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the first number", "LJMU_7501_COMP_AP1: Simple Math", JOptionPane.QUESTION_MESSAGE));
                    int num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the second number", "LJMU_7501_COMP_AP1: Simple Math", JOptionPane.QUESTION_MESSAGE));

                    // Calculate and display the sum of the two numbers
                    int sum = num1 + num2;
                    JOptionPane.showMessageDialog(null,  "the sum of "+num1+" and "+num2+" is "+sum, "LJMU_7501_COMP_AP1: Simple Math", JOptionPane.INFORMATION_MESSAGE, null);
                    break;

                case 2:
                    // Prompt the user to enter a number to convert
                    double num = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a number to round\n(minimum of 3 decimal points)", "LJMU_7501_COMP_AP1: Simple Math", JOptionPane.QUESTION_MESSAGE));

                    // Display the result and convert the number to two decimal points
                    JOptionPane.showMessageDialog(null, num+" rounded to two decimal points is "+String.format("%.2f", num), "LJMU_7501_COMP_AP1: Simple Math", JOptionPane.INFORMATION_MESSAGE, null);
                    break;

                case 3:
                    // Prompt the user to enter five values
                    double[] values = new double[5];
                    for (int i = 0; i < 5; i++) {
                        values[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter value # "+ (i + 1), "LJMU_7501_COMP_AP1: Simple Math", JOptionPane.QUESTION_MESSAGE));
                    }

                    // Calculate the sum, average, minimum, maximum, and square root of the maximum value
                    double sum2 = 0;
                    double min = values[0];
                    double max = values[0];
                    // Iterate through each value in array values
                    for (double value : values) {
                        // Add each value
                        sum2 += value;
                        // Determine if value is the new minimum value
                        if (value < min) {
                            min = value;
                        }
                        // Determine if value is the new maximum value
                        if (value > max) {
                            max = value;
                        }
                    }
                    // Calculate the average
                    double average = sum2 / values.length;
                    // Call on Math package to calculate the square root of the maximum value
                    double sqrtMax = Math.sqrt(max);

                    // Display the results
                    JOptionPane.showMessageDialog(null, "Sum: "+sum2+"\nAverage: "+average+"\nMinimum: "+min+"\nMaximum: "+max+"\nSquare root of maximum: "+sqrtMax, "LJMU_7501_COMP_AP1: Simple Math", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 0:
                    // Exit the program
                    break;

                default:
                    // Invalid choice
                    JOptionPane.showMessageDialog(null, "Invalid choice, please try again.", "LJMU_7501_COMP_AP1: Simple Math", JOptionPane.ERROR_MESSAGE);
            }
            // Break the loop if the user's choice is 0
        } while (choice != 0);
    }

    public static void CurrencyConverter () {
        // Declare the exchange rates
        double rateUSD = 0.50; // rate of 1 USD in Belize dollars
        double rateEUR = 0.42; // rate of 1 EUR in Belize dollars
        double rateGBP = 0.36; // rate of 1 GBP in Belize dollars
        double rateMXN = 10.20; // rate of 1 MXN in Belize dollars
        String[] choices = {"US dollars", "Euros", "British pounds", "Mexican pesos", "Quit"};
        int choice;

        JOptionPane.showMessageDialog(null, "Welcome to the Belize dollar currency converter!", "LJMU_7501_COMP_AP1: Currency Converter", JOptionPane.PLAIN_MESSAGE);

        while (true) {
            // Prompt the user for a value in BZD
            double belizeDollars = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter an amount in Belize dollars to convert", "LJMU_7501_COMP_AP1: Currency Converter", JOptionPane.QUESTION_MESSAGE));

            do {
            // Display the conversion menu and save the choice
            choice = JOptionPane.showOptionDialog(null, "Choose a currency to convert to", "LJMU_7501_COMP_AP1: Currency Converter", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, choices, choices[0])+1;

            double result=0;
            String currency="";

            switch (choice) {
                case 1:
                    result = belizeDollars * rateUSD;
                    currency = "USD";
                    break;
                case 2:
                    result = belizeDollars * rateEUR;
                    currency = "EUR";
                    break;
                case 3:
                    result = belizeDollars * rateGBP;
                    currency = "GBP";
                    break;
                case 4:
                    result = belizeDollars * rateMXN;
                    currency = "MXN";
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }
            // Display results
            JOptionPane.showMessageDialog(null, String.format("%.2f", belizeDollars)+" BZD is "+String.format("%.2f", result)+" "+currency, "LJMU_7501_COMP_AP1: Currency Converter", JOptionPane.INFORMATION_MESSAGE);

            } while (choice != 0); // Repeat loop until user chooses to quit
        }
    }

    public static void CompoundInterestCalc () {

        // Initialize variables
        String[] freqPeriods = {"yearly", "monthly", "daily"};
        double principal, rate, time;
        int freq;

        try {
            // Prompt the user for a series of inputs
            System.out.print("Enter principal amount: ");
            principal = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter principal amount", "LJMU_7501_COMP_AP1: Currency Converter", JOptionPane.QUESTION_MESSAGE));

            System.out.print("Enter interest rate: ");
            rate = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the interest rate (%)", "LJMU_7501_COMP_AP1: Currency Converter", JOptionPane.QUESTION_MESSAGE));

            System.out.print("Enter time period: ");
            time = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the time period (in years)", "LJMU_7501_COMP_AP1: Currency Converter", JOptionPane.QUESTION_MESSAGE));

            System.out.print("Enter frequency of compounding (yearly, monthly, or daily): ");
            freq = JOptionPane.showOptionDialog(null, "Enter frequency of compounding", "LJMU_7501_COMP_AP1: Currency Converter", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, freqPeriods, freqPeriods[0]) + 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid entry, please try again.", "LJMU_7501_COMP_AP1: Currency Converter", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Call the calculateCompoundInterest method and save the returned double value into amount
        double amount = calculateCompoundInterest(principal, rate, time, freqPeriods[freq]);

        // Display the compound interest
        JOptionPane.showMessageDialog(null, "Compound interest is "+String.format("%.2f", amount-principal), "LJMU_7501_COMP_AP1: Currency Converter", JOptionPane.INFORMATION_MESSAGE);
    }

    public static double calculateCompoundInterest(double principal, double rate, double time, String freq) {
        double n = 0;
        // Convert rate into decimal
        double r = rate / 100;
        // Determine the number of times the interest is compounded
        switch (freq) {
            case "yearly" -> n = 1;
            case "monthly" -> n = 12;
            case "daily" -> n = 365;
            default -> {
                JOptionPane.showMessageDialog(null, "Invalid frequency, closing program now.", "LJMU_7501_COMP_AP1: Simple Math", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
        // Calculate the compound interest based on the frequency and rate calculated earlier
        return principal * Math.pow((1 + r / n), n * time);
    }
    
    public static void LeapYear () {
        int year = 0, opt;
        do {
            try {
                // Prompt the user for a valid year to calculate
                while (year <= 0) {
                    year = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a year", "LJMU_7501_COMP_AP1: Leap Year", JOptionPane.QUESTION_MESSAGE));
                    if (year <= 0) {
                        JOptionPane.showMessageDialog(null, "Invalid entry, please try again.", "LJMU_7501_COMP_AP1: Leap Year", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid entry, please try again.", "LJMU_7501_COMP_AP1: Leap Year", JOptionPane.ERROR_MESSAGE);
                break;
            }

            // Calculate if the input is a leap year
            boolean isLeapYear = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);

            // Display the proper feedback to the result
            if (isLeapYear) {
                JOptionPane.showMessageDialog(null, year + " is a leap year.", "LJMU_7501_COMP_AP1: Leap Year", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, year + " is not a leap year.", "LJMU_7501_COMP_AP1: Leap Year", JOptionPane.INFORMATION_MESSAGE);
            }
            opt = JOptionPane.showConfirmDialog(null, "Would you like to try another year?", "LJMU_7501_COMP_AP1: Leap Year", JOptionPane.YES_NO_OPTION);
            year = 0;
        } while (opt !=1);
    }
}