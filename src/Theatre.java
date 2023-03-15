import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Theatre {
    static int[] row1 = {0,0,0,0,0,0,0,0,0,0,0,0};
    static int[] row2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    static int[] row3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

     static  Scanner scanner = new Scanner(System.in);  // Create a Scanner object to get user option

    public static void main(String[] args) {
        System.out.println("Welcome to the New Theatre");
        start();
    }
    public static void start(){
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
            case "3":
                cancel_ticket();
                break;
            case "4":
                show_available();
                break;
            case "5":
                    save();
                break;
            case "6":

                /*   load();*/

                break;
            case "0":
                System.exit(0);
                break;
            default:

        }

    }
    /**************************************Return to main menu **************************************/
    public static void returnToMain(){
        System.out.println();
        System.out.println("Do you want to go back to main menu,1(yes)/2(no) : ");
        int rowNumber = Integer.parseInt(scanner.nextLine());
        if(rowNumber == 1){
            start();
        }else {
            System.exit(0);
        }
    }
    /**************************************Buy Ticket**************************************/
    public static void buyTicket(){
        System.out.println("--------------------Buy Ticket--------------------");

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
        int seatCount = row.length;
        if(seatNumber <=seatCount && seatNumber>0){

            System.out.println("data "+row[seatNumber-1]);
            //check seat availability
            if(row[seatNumber-1] == 0){
                row[seatNumber-1] = 1;
                System.out.println("Buy ticket successful..!");
                returnToMain();

                    /* System.out.println("Array"+Arrays.toString(row1));*/
            }else {
                System.out.println("Seat Not Available ..!");
                System.out.println("Enter another Seat Number : ");
                int newSeatNumber = Integer.parseInt(scanner.nextLine());
                bookTicket(row,newSeatNumber);
            }

        }else {
            System.out.println("please Enter a valid seat Number..!");
            returnToMain();
        }
    }

    /**************************************print_seating_are**************************************/
    public static void print_seating_area(){
        System.out.println("\t ***********");
        System.out.println("\t *  Stage  *");
        System.out.println("\t ***********");

        System.out.println();
        System.out.print("\t");
        //get all data in row1
        for (int i = 0; i < row1.length; i++) {
            //check seat available or not
          if(row1[i]==0){
              if (i==6) {
                  System.out.print(" ");
              }
              System.out.print("O");
          }else{
              System.out.print("X");
          }

        }
        System.out.println();
        System.out.print("  ");
        //get all data in row2
        for (int i = 0; i < row2.length; i++) {
            //check seat available or not
            if(row2[i]==0){
                if (i==8) {
                    System.out.print(" ");
                }
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
                if (i==10) {
                    System.out.print(" ");
                }
                System.out.print("O");
            }else{
                System.out.print("X");
            }
        }
        returnToMain();
    }

    /**************************************cancel_ticket**************************************/

    public static void cancel_ticket(){
        System.out.println("--------------------Cancel Ticket--------------------");
        System.out.println("Enter Row Number : ");
        String rowNumber = scanner.nextLine();

        System.out.println("Enter Seat Number : ");
        int seatNumber = Integer.parseInt(scanner.nextLine());

        if(rowNumber.equals("1")){

            //check valid seat number
            cancel(row1,seatNumber);

        }else if(rowNumber.equals("2")){

            cancel(row2,seatNumber);

        }else if(rowNumber.equals("3")){

            cancel(row3,seatNumber);
        }else {
            System.out.println("please Enter a valid Row Number..!");
        }

    }

    //This method created for avoid boilerplate codes in cancel_ticket method
    public static void cancel(int[]row,int seatNumber){
        int seatCount = row.length;
        if(seatNumber <=seatCount && seatNumber>0){

            System.out.println("data "+row[seatNumber-1]);
            //check seat availability
            if(row[seatNumber-1] == 1){
                row[seatNumber-1] = 0;
                System.out.println("Cancel Ticket Process Successful..!");
                returnToMain();
            }else {
                System.out.println("Seat already Available..!");
                returnToMain();
            }

        }else {
            System.out.println("please Enter a valid seat Number..!");
            returnToMain();
        }


    }
    /**************************************show_available**************************************/
    public static void show_available(){
        //Row 1
        System.out.print("Seats available in row 1: ");
        for (int i = 0; i < row1.length; i++) {
            if (row1[i]==0){
                System.out.print((i+1)+",");
            }
        }
        System.out.println("\b"+".");

        //Row 2
        System.out.print("Seats available in row 2: ");
        for (int i = 0; i < row2.length; i++) {
            if (row2[i]==0){
                System.out.print((i+1)+",");
            }
        }
        System.out.println("\b"+".");

        //Row 3
        System.out.print("Seats available in row 3: ");
        for (int i = 0; i < row3.length; i++) {
            if (row3[i]==0){
                System.out.print((i+1)+",");
            }
        }
        System.out.println("\b"+".");

        returnToMain();
    }
    public static void save(){
        try {
            saveInFile("row1.txt",row1);
            saveInFile("row2.txt",row2);
            saveInFile("row3.txt",row3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveInFile(String file,int[]row) throws IOException {
        //you should create a directory in your computer and set its path here
        String fileName= "C:\\Users\\User\\Desktop\\TxtFiles\\"+file;
        ObjectOutputStream outputStream = null;


            outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            outputStream.writeObject(row);



    }
 /*   public static void load() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
        int[] intArr = (int[])inputStream.readObject();
        System.out.println("Array: "+Arrays.toString(intArr));
    }*/
}
