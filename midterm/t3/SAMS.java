package t3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SAMS {
    private List<Event> storage = new ArrayList<>();
    private Map<Customer, List<Event>> bookings = new HashMap<>();

    public void addEvent(Event event) {
        storage.add(event);
    }

    public boolean removeEvent(Event event) {
        return storage.remove(event);
    }

    public void printStorage() {
        if (storage.isEmpty()) {
            System.out.println("The storage is empty");
        } else {
            for (Event e : storage) {
                System.out.println(e.getType() + ", " + e.getName());
            }
        }
    }

    public boolean bookEvent(Event event, Customer customer) {
        if (!storage.contains(event)) {
            System.out.println("Event does not exist in the arena");
            return false;
        }

        bookings.computeIfAbsent(customer, k -> new ArrayList<>());
        bookings.get(customer).add(event);
        return true;
    }

    public boolean cancelBooking(Event event, Customer customer) {
        if (!bookings.containsKey(customer)) {
            System.out.println("Customer has no bookings");
            return false;
        }

        List<Event> customerBookings = bookings.get(customer);
        if (customerBookings.remove(event)) {
            return true;
        }

        System.out.println("Booking not found for this customer");
        return false;
    }

    public void printCustomerBookings(Customer customer) {
        List<Event> customerBookings = bookings.get(customer);
        if (customerBookings == null || customerBookings.isEmpty()) {
            System.out.println("Customer " + customer.getName() + " " +
                               customer.getSurname() + " has no bookings");
            return;
        }

        System.out.println("Bookings for " + customer.getName() + " " +
                           customer.getSurname() + ":");
        for (Event e : customerBookings) {
            System.out.println("- " + e.getType() + ": " + e.getName());
        }
    }

    public void printEventInformation(Event event) {
        if (!storage.contains(event)) {
            System.out.println("Event does not exist in the arena");
            return;
        }

        System.out.println("Event Information:");
        System.out.println("Type: " + event.getType());
        System.out.println("Name: " + event.getName());

        int bookingCount = 0;
        for (List<Event> events : bookings.values()) {
            for (Event e : events) {
                if (e.equals(event)) {
                    bookingCount++;
                }
            }
        }
        System.out.println("Total Bookings: " + bookingCount);
    }
}
