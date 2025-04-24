package lizi_rakviashvili_1.midterm1.t2.egg.sub;
import lizi_rakviashvili_1.midterm1.t2.egg.A21;
import lizi_rakviashvili_1.midterm1.t2.egg.measuringcup.intermission.A22;

public class R21 {
public static void main(String[] args) {
    A21 a21 = new A21();
    A22 a22 = new A22();

    System.out.println("The area of the rectangle is: " + (a21.getWidth() * a21.getHeight()));

   
    String[] month = {
        "Invalid month", "January", "February", "March", "April", "May", "June", "July",
        "August", "September", "October", "November", "December"
    };

    
    System.out.println("The month is: " + month[a22.getMonth()]);;
}
}