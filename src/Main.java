import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Money Converter");
        System.out.println(handle_input());
    }

    public static int handle_input() {
        Scanner input_object = new Scanner(System.in);
        System.out.println("Please enter your amount");
        String input = input_object.nextLine();
        return Integer.parseInt(input);
    }

}