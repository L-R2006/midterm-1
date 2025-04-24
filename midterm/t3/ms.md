OBJECT ORIENTED PROGRAMMING 
APRIL 24, 2025 PAGE 1 (OF 4)
Sports Arena Management System
Masterclass in Java

Description
Create Sports Arena Management System (SAMS) in Java. SAMS is widely used software. It can be any complexity. Our example is a basic one, which has the following features:

storage for sports events
ability to add an event to the arena
ability to remove an event from the arena
ability to print the arena event information on the console

SAMS structure
We will need the following classes for the software:

Event – the event itself.
SAMS – sports arena management system.
ArenaTester – the tester class. This class will be used to test our management system.

Show Image
Class Event
The class Event should have several fields, including name and type. This class can be implemented in the following way:
javapackage t3;

public class Event {
    private String name, type;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
Pay attention to the setters and getters of the fields. In general, all the fields are private (unless the special requirements are stated) and the access functions are implemented such as setters and getters.
Read about toString() function and implement it for Event class.
OBJECT ORIENTED PROGRAMMING PAATA GOGISHVILI
APRIL 24, 2025 PAGE 2 (OF 4)
Class SAMS
The sports arena management system should have an inner structure for storing events. The management system should have methods for adding the new events and removing the old ones. It should have the ability to print the entire arena content when needed. The class can be implemented in the following way:
javapackage t3;

import java.util.ArrayList;
import java.util.List;

public class SAMS {
    // Mapping with Event and the number of this event in the arena
    private List<Event> storage = new ArrayList<Event>();
    
    // adds the event to the arena
    public void addEvent(Event event) {
        storage.add(event);
    }
    
    // removes the event from the arena
    public boolean removeEvent(Event event) {
        boolean removed = false;
        for (int i = 0; i < storage.size(); i++) {
            Event e = storage.get(i);
            if (e.getName().equals(event.getName()) && e.getType().equals(event.getType())) {
                storage.remove(i);
                removed = true;
                break;
            }
        }
        return removed;
    }
    
    public void printStorage() {
        if (storage.isEmpty()) {
            System.out.println("The storage is empty");
        } else {
            for (Event e: storage) {
                System.out.println(e.getType() + ", " + e.getName());
                System.out.println();
            }
        }
    }
}
Pay attention to the usage of the ArrayList class, for loops for the lists, break clause and the String object comparison. It is a good point to understand how Interface works. Usage of the boolean variables can also be observed in this example.
OBJECT ORIENTED PROGRAMMING PAATA GOGISHVILI
APRIL 24, 2025 PAGE 3 (OF 4)
SAMS Tester class
Now let's test our management system. First, create some events. Then create SAMS and add those events to the arena using the SAMS. Then try to remove some of the events.
javapackage t3;

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
        sams.removeEvent(e1);
        sams.printStorage();
    }
}
We print the state of the arena to check if all the methods are working properly.
Future Improvements
The example above is very basic for the SAMS. It can be improved by adding convenient features. Let's define some of them. Consider adding some packages if convenient.

Add the ability to tell how many of each event is available in the arena.
Introduce the class for customer and add the ability to SAMS to make accounting of the process of booking and canceling the events. Implement the following methods for SAMS:
a) boolean bookEvent(Event event, Customer customer)
b) boolean cancelBooking(Event event, Customer customer)
c) void printCustomerBookings(Customer customer)
d) void printEventInformation(Event event)

OBJECT ORIENTED PROGRAMMING 
APRIL 24, 2025 PAGE 4 (OF 4)
New Feature
The Sports Arena Management System has been enhanced with an Event Booking System feature that allows customers to book events and administrators to manage these bookings. This feature addresses one of the future improvements mentioned earlier and has been fully implemented in the SAMS class.
Event Booking System
This new feature manages the relationship between customers and events through the following functionalities:

Book Events: Customers can now book events available in the arena through the bookEvent(Event, Customer) method.
Cancel Bookings: Customers can cancel their existing bookings using the cancelBooking(Event, Customer) method.
View Customer Bookings: Arena administrators can see all events booked by a specific customer using the printCustomerBookings(Customer) method.
View Event Details: Event information including booking statistics can be viewed with the printEventInformation(Event) method.

The implementation uses a HashMap to efficiently store and manage the relationship between customers and their booked events. This approach ensures fast lookup times for customer bookings and simplifies the process of adding or removing bookings.
Implementation Details
The feature has been implemented using the following data structure:
javaprivate Map<Customer, List<Event>> bookings = new HashMap<>();
This structure allows the system to:

Associate multiple events with a single customer
Quickly retrieve all events booked by a specific customer
Efficiently add and remove bookings
Track event popularity through booking counts

The code includes comprehensive validation to ensure that events exist in the arena before booking and that customers have valid bookings before cancellation operations.