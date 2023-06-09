import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Theatre {
    static int[] row1 = {0,0,0,0,0,0,0,0,0,0,0,0};
    static int[] row2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    static int[] row3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    static ArrayList<Ticket>tickets = new ArrayList<>();

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
                load();
                break;
            case "7":
                show_tickets_info();
                break;
            case "8":
                sort_tickets();
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

        System.out.println("Enter Name : ");
        String name =scanner.nextLine();

        System.out.println("Enter SurName : ");
        String surname = scanner.nextLine();

        System.out.println("Enter Email : ");
        String email = scanner.nextLine();

        System.out.println("Enter Ticket Price : ");
        double price = Double.parseDouble(scanner.nextLine());

        //add to array list
        Person person = new Person(name,surname,email);
        tickets.add(new Ticket(Integer.parseInt(rowNumber),seatNumber,price,person));

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
                System.out.println(tickets.isEmpty());
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
            cancel(row1,seatNumber,1);

        }else if(rowNumber.equals("2")){

            cancel(row2,seatNumber,2);

        }else if(rowNumber.equals("3")){

            cancel(row3,seatNumber,3);
        }else {
            System.out.println("please Enter a valid Row Number..!");
        }

    }

    //This method created for avoid boilerplate codes in cancel_ticket method
    public static void cancel(int[]row,int seatNumber,int rowNum){
        int seatCount = row.length;
        if(seatNumber <=seatCount && seatNumber>0){


            //check seat availability
            if(row[seatNumber-1] == 1){

                //loop all ticket ob in arraylist
                for (Ticket ticket : tickets) {

                    //get specifics ticket
                    if(seatNumber == ticket.seat && rowNum == ticket.row){


                        //remove ticket ob in array list
                        tickets.remove(ticket);
                       /* System.out.println(tickets.isEmpty());*/
                        break;
                    }

                }

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

    /**************************************Array Save in File**************************************/
    public static void save(){
        try {
            //send array and file name to save
            saveInFile("row1.txt",row1);
            saveInFile("row2.txt",row2);
            saveInFile("row3.txt",row3);
            System.out.println("Saved..!");
            returnToMain();
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

    /**************************************Load Array**************************************/
    public static void load(){
        try {
            //send file name to load an array
            loadFile("row1.txt");
            loadFile("row2.txt");
            loadFile("row3.txt");
            returnToMain();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    static int i =1;
    public static void loadFile(String file) throws IOException, ClassNotFoundException {
        //you should create a directory in your computer and set its path here
        String fileName= "C:\\Users\\User\\Desktop\\TxtFiles\\"+file;
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
        int[] intArr = (int[])inputStream.readObject();
        System.out.println("Row"+i+": "+Arrays.toString(intArr));
        i++;
    }

    /**************************************Load Array**************************************/
    public static void show_tickets_info(){
        System.out.println("---------------------------------Ticket Detail--------------------------------------------");
        double tot = 0;
        for (Ticket ticket : tickets) {
            tot += ticket.price;
            System.out.println("Row Number - "+ticket.row+",Seat Number - "+ticket.seat+" | Ticket Price - "+ticket.price+" | Name - "+ticket.person.name+" | Surname - "+ticket.person.surname+" | Email - "+ticket.person.email);
        }
        System.out.println("Total Price = "+tot);
        returnToMain();
    }
    /**************************************sort_tickets**************************************/
    public static void sort_tickets(){
        System.out.println("---------------------------------Ticket Detail -----------------------------------------");
        Collections.sort(tickets,(t1,t2)-> (int) (t1.price-t2.price));
        for (Ticket ticket : tickets) {
            System.out.println("Row Number - "+ticket.row+",Seat Number - "+ticket.seat+" | Ticket Price - "+ticket.price+" | Name - "+ticket.person.name+" | Surname - "+ticket.person.surname+" | Email - "+ticket.person.email);
        }
        System.out.println();
        returnToMain();
    }
}
