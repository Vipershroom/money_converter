import java.text.ParseException;
import java.util.Scanner;
import java.util.HashMap;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Money Converter");
        String[] money_list = handle_input();
        HashMap<String, Double> coin = calculate(money_list);
        renderCoins(coin);
    }

    public static String[] handle_input() {
        System.out.println("Please enter your amount:");
        while (true) {
            // Handles User Input
            Scanner input_object = new Scanner(System.in);
            String line = input_object.nextLine();

            // Check if input is a number
            try {
                double num = Double.parseDouble(line);
            } catch (NumberFormatException err) {
                System.out.println("Please enter a number");
                continue;
            }

            String[] input = line.split("\\.", 2);
            // Check if decimal is to the hundreths place
            if (input[1].length() > 2) {
                System.out.println("Please enter a decimal up to the hundreths place");
                continue;
            }

            return input;
        }

    }

    public static double remainder(String type, double num) {
        // Find the remainder of the amount given the coin type
        return switch (type) {
            case "Quarter" -> num % 25;
            case "Dime" -> num % 10;
            case "Nickel" -> num % 5;
            default -> num;
        };
    }

    public static HashMap<String, Double> calculate(String[] money_list) {
        // Create Coin hashmap
        HashMap<String, Double> coins = new HashMap<String, Double>();

        double dollar = Double.parseDouble(money_list[0]);
        double cents = Double.parseDouble(money_list[1]);

        // Find the amount of coins and remainders
        double quarters = Math.floor(cents / 25);
        double quarters_remainder = remainder("Quarter", cents);

        double dimes = Math.floor(quarters_remainder / 10);
        double dimes_remainder = remainder("Dime", quarters_remainder);

        double nickel = Math.floor(dimes_remainder / 5);
        double nickel_remainder = remainder("Nickel", dimes_remainder);

        // Put key value pairs into hashmap.
        coins.put("Quarters", dollar * 4.0 + quarters);
        coins.put("Dimes", dimes);
        coins.put("Nickels", nickel);
        coins.put("Pennies", nickel_remainder);

        return coins;
    }

    public static void renderCoins(HashMap<String, Double> coins) {
        // Render the coin amounts
        coins.forEach((type, amount) -> {
            if (amount == 0) {
                return;
            }
            System.out.println(type + ": " + amount);
        });
    }
}

