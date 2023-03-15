import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Theatre {
    static int[] row1 = {0,1,0,0,0,0,0,0,0,0,0,0};
    static int[] row2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    static int[] row3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

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
                print_seating_area();
                break;
            default:

        }


    }

    public static void buyTicket(){

        System.out.println("Enter Row Number : ");
        String rowNumber = scanner.nextLine();

        System.out.println("Enter Seat Number : ");
        int seatNumber = Integer.parseInt(scanner.nextLine());

        //check which array matches for user input row number
        if(rowNumber.equals("1")){

            //check valid seat number
            bookTicket(row1,seatNumber);

        }else if(rowNumber.equals("2")){

            bookTicket(row2,seatNumber);

        }else if(rowNumber.equals("3")){

            bookTicket(row3,seatNumber);
        }else {
            System.out.println("please Enter a valid Row Number..!");
        }
    }

    //This method created for avoid boilerplate codes
    public static void bookTicket(int[]row,int seatNumber){

        if(seatNumber <=15 && seatNumber>0){

            System.out.println("data "+row[seatNumber-1]);
            //check seat availability
            if(row[seatNumber-1] == 0){
                row[seatNumber-1] = 1;
                System.out.println("Buy ticket successful..!");
                    /* System.out.println("Array"+Arrays.toString(row1));*/
            }else {
                System.out.println("Seat Not Available ..!");
                System.out.println("Enter another Seat Number : ");
                int newSeatNumber = Integer.parseInt(scanner.nextLine());
                bookTicket(row,newSeatNumber);
            }

        }else {
            System.out.println("please Enter a valid seat Number..!");
        }
    }
    public static void  print_seating_area(){
        //get all data in row1
        for (int i = 0; i < row1.length; i++) {
            //check seat available or not
          if(row1[i]==0){
              System.out.print("O");
          }else{
              System.out.print("X");
          }

        }
        System.out.println();
        //get all data in row2
        for (int i = 0; i < row2.length; i++) {
            //check seat available or not
            if(row2[i]==0){
                System.out.print("O");
            }else{
                System.out.print("X");
            }

        }
        System.out.println();
        //get all data in row3
        for (int i = 0; i < row3.length; i++) {
            //check seat available or not
            if(row3[i]==0){
                System.out.print("O");
            }else{
                System.out.print("X");
            }
        }
    }
}
