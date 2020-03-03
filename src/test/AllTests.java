package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Initialize all project tests 
 * @author Konsta Sakharovskiy
 * @version 3.1.2019
 */
@RunWith(Suite.class)
@SuiteClasses({
    bookings.RoomTest.class,
    bookings.RoomsBaseTest.class,
    bookings.ClientTest.class,
    //bookings.ClientsBaseTest.class,
    bookings.ReservationTest.class,
    //bookings.ReservationsBaseTest.class,
    //bookings.CalendarViewTest.class,
    database.DataGenerateTest.class,
    database.DateCheckTest.class

})

public class AllTests {
    //

}
