package bookings;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
//import bookings.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2019.03.09 00:39:02 // Generated by ComTest
 *
 */
public class ReservationTest {



  // Generated by ComTest BEGIN
  /** testRegister82 */
  @Test
  public void testRegister82() {    // Reservation: 82
    Reservation test = new Reservation(); 
    assertEquals("From: Reservation line: 84", 0, test.getReservationNo()); 
    test.register(); 
    Reservation test2 = new Reservation(); 
    test2.register(); 
    int n1 = test.getReservationNo(); 
    int n2 = test2.getReservationNo(); 
    assertEquals("From: Reservation line: 90", n2-1, n1); 
  } // Generated by ComTest END
}