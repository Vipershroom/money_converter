import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Money Converter");
        String[] money_list = handle_input();
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

    public static void calculate() {

    }

}