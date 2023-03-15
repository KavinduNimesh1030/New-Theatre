public class Ticket {
    int row;
    int seat;
    double price;
    Person person;

    public Ticket() {
    }

    public Ticket(int row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
}
