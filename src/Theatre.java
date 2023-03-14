import java.lang.reflect.Array;
import java.util.Scanner;

public class Theatre {
    int[] row1 = {0,0,0,0,0,0,0,0,0,0,0,0};
    int[] row2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int[] row3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

     static  Scanner scanner = new Scanner(System.in);  // Create a Scanner object to get user option

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


        System.out.println("Enter Option : ");

        String option = scanner.nextLine();

        switch(option) {
            case "1":
                buyTicket();
                break;
            case "2":

                break;
            default:

        }


    }

    public static void buyTicket(){
        System.out.println("Enter Row Number : ");
        String rowNumber = scanner.nextLine();
        System.out.println(rowNumber);
        System.out.println("Enter Seat Number : ");
        String seatNumber = scanner.nextLine();
        System.out.println(seatNumber);
    }
}
