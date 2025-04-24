package t3;

public class ArenaTester {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.setName("David");
        c1.setSurname("Johnson");
        c1.setId("12345678912");

        Customer c2 = new Customer();
        c2.setName("Maria");
        c2.setSurname("Smith");
        c2.setId("98765432105");

        Event e1 = new Event();
        e1.setName("Basketball Championship");
        e1.setType("Basketball");

        Event e2 = new Event();
        e2.setName("Regional Soccer Tournament");
        e2.setType("Soccer");

        SAMS sams = new SAMS();

        sams.addEvent(e1);
        sams.addEvent(e1);
        sams.addEvent(e2);

        System.out.println("Removing an event: " + sams.removeEvent(e1));

        System.out.println("Current events in the arena:");
        sams.printStorage();

        System.out.println("\n=== Testing New Booking Feature ===");

        sams.bookEvent(e1, c1);
        sams.bookEvent(e2, c1);
        sams.bookEvent(e2, c2);

        sams.printCustomerBookings(c1);
        sams.printCustomerBookings(c2);

        System.out.println();
        sams.printEventInformation(e2);

        System.out.println("\nCanceling booking for " + c1.getName());
        sams.cancelBooking(e2, c1);

        System.out.println();
        sams.printCustomerBookings(c1);
        sams.printEventInformation(e2);
    }
}
