import java.util.Objects;
import java.util.Scanner;
import java.util.HashMap;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Money Converter");
        String[] money_list = handle_input();
        calculate(money_list);
    }

    public static String[] handle_input() {
        // Handles User Input
        Scanner input_object = new Scanner(System.in);
        System.out.println("Please enter your amount");
        String[] input = input_object.nextLine().split("\\.", 2);

        // Add a zero if the decimal portion is empty
        if (input[1].length() == 1) {
            input[1] = input[1] + "0";
        }
        return input;
    }

    public static void calculate(String[] money_list) {
        // Create Coin hashmap
        HashMap<String, Integer> coins = new HashMap<String, Integer>();
        coins.put("Quarters", 0);
        coins.put("Dimes", 0);
        coins.put("Nickels", 0);
        coins.put("Pennies", 0);

        int dollar = Integer.parseInt(money_list[0]);
        double cents = Double.parseDouble(money_list[1]);

        coins.put("Quarters",dollar);

        double quarters = Math.floor(cents / 25);
        double quarters_remainder = remainder("Quarter", cents);
        System.out.println(quarters);
        System.out.println(quarters_remainder);

        System.out.println();

    }

    public static double remainder(String type, double num) {
        if (type.equals("Quarter")) {
            return num % 25;
        } else if (type.equals("Dime")) {
            return num % 10;
        } else if (type.equals("Nickel")) {
            return num % 5;
        }
        return num;
    }

}