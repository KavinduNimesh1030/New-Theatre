import java.lang.reflect.Array;
import java.util.Scanner;

public class Theatre {
    int[] row1 = {};
    int[] row2 = {};
    int[] row3 = {};

    public static void main(String[] args) {
        System.out.println("Welcome to the New Theatre");

        System.out.println("Please select an option:");
        System.out.println("1) Buy a ticket");
        System.out.println("2) Print seating area");
        System.out.println("3) Cancel ticket ");
        System.out.println("4) List available seats");
        System.out.println("5) Save to file");
        System.out.println("6) Load from file");
        System.out.println("7) Print ticket information and total price");
        System.out.println("8) Sort tickets by price");
        System.out.println("0) Quit");

        System.out.println("------------------------------------------------");

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object to get user option
        System.out.println("Enter Option : ");

        String option = myObj.nextLine();
        

    }
}
