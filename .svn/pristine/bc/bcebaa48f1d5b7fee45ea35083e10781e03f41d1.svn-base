package bookings;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static bookings.Database.makeBase;
import java.sql.*;

/**
 * maintain the actual information about reservations
 * add remove and change reservations
 * upload and print reservations information
 * searching, sorting and filtering 
 * @author Konsta Sakharovskiy 
 * @version Mar 8, 2019
 *
 */
public class ReservationsBase {
    
    private static Reservation bufferReservation = new Reservation();
    private Database db;

    
    
    /**
     * Check if there is table in the db
     * @param name database name
     * @throws HoldException in case of exception
     */
    public ReservationsBase(String name) throws HoldException {
        db = makeBase(name);
        try ( Connection con = db.establishConnection() ) {
            DatabaseMetaData meta = con.getMetaData();
            try ( ResultSet table = meta.getTables(null, null, "Reservations", null) ) {
                if ( !table.next() ) {
                    try ( PreparedStatement sql = con.prepareStatement(bufferReservation.annaLuontilauseke()) ) {
                        sql.execute();
                    }
                }
            }
                
        } catch ( SQLException e ) {
            throw new HoldException("Error with database: " + e.getMessage());
        }
    }
    

    /**
     * main method for testing
     * @param args not in use
     */
    public static void main(String[] args) {
        
        try {
            new File("testing.db").delete();
            ReservationsBase reserv = new ReservationsBase("testing");
            Reservation stay1 = new Reservation();
            stay1.assignReservation(2);
            Reservation stay2 = new Reservation();
            stay2.assignReservation(1);
            Reservation stay3 = new Reservation();
            stay3.assignReservation(2);
            Reservation stay4 = new Reservation();
            stay4.assignReservation(2);

            reserv.add(stay1);
            reserv.add(stay2);
            reserv.add(stay3);
            reserv.add(stay4);
            
            System.out.println("============= test =================");
    
            List<Reservation> reservList;
            
            reservList = reserv.giveReservations(2);
            
            for (Reservation res : reservList) {
                System.out.print(res.getClientsNo() + " ");
                res.printing(System.out);
            }
            
            new File("testing.db").delete();
        } catch (HoldException ex) {
            System.out.println(ex.getMessage());
        }
           
   
    }
    
    /**
     * initialize reservation
     */
    public ReservationsBase() {
        // access method if reservation without client
    }
    
    /**
     * add reservation to reservations list
     * @param res reservaton to add
     * @throws HoldException in case of exception
     */
    public void add(Reservation res) throws HoldException {
        try ( Connection con = db.establishConnection(); PreparedStatement sql = res.annaLisayslauseke(con) ) {
            sql.executeUpdate();
            try ( ResultSet rs = sql.getGeneratedKeys() ) {
                res.checkId(rs);
             }   
        } catch (SQLException e) {
            throw new HoldException("Error with database: " + e.getMessage());
        }
    }
    
    

    
    /**
     * Search and return reservations by client's id
     * @param clientsNo clients id
     * @return found reservations in list
     * @throws HoldException in case of exception
     ** @example
     * <pre name="test">
     * #import java.util.*;
     *  ReservationsBase test = new ReservationsBase();
     *  Reservation res1 = new Reservation(2); test.add(res1);
     *  Reservation res2 = new Reservation(1); test.add(res2);
     *  Reservation res3 = new Reservation(2); test.add(res3);
     *  Reservation res4 = new Reservation(1); test.add(res4);
     *  Reservation res5 = new Reservation(2); test.add(res5);
     *  Reservation res6 = new Reservation(5); test.add(res6);
     *  List<Reservation> found;
     *  found = test.giveReservations(3);
     *  found.size() === 0; 
     *  found = test.giveReservations(1);
     *  found.size() === 2; 
     *  found.get(0) == res2 === true;
     *  found.get(1) == res4 === true;
     *  found = test.giveReservations(5);
     *  found.size() === 1; 
     *  found.get(0) == res6 === true;
     * </pre> 
     */
    public List<Reservation> giveReservations(int clientsNo) throws HoldException {
        List<Reservation> found = new ArrayList<Reservation>();
        
        try ( Connection con = db.establishConnection();
                PreparedStatement sql = con.prepareStatement("SELECT * FROM Reservations WHERE clientsNo = ?")
                  ) {
              sql.setInt(1, clientsNo);
              try ( ResultSet tulokset = sql.executeQuery() )  {
                  while ( tulokset.next() ) {
                      Reservation har = new Reservation();
                      har.parse(tulokset);
                      found.add(har);
                  }
              }
              
          } catch (SQLException e) {
              throw new HoldException("Error with database: " + e.getMessage());
          }
          return found;
    }
    
    
    
    /**
     * return collection reservations searched by condition
     * @param condition search string
     * @param i position
     * @return reservations in collection
     * @throws HoldException in case of exception
     */
    public Collection<Reservation> search(String condition, int i) throws HoldException{
        String ehto = condition;
        String quest = bufferReservation.getQuest(i);
        if ( i < 0 ) { quest = bufferReservation.getQuest(0); ehto = ""; }
        // Avataan yhteys tietokantaan try .. with lohkossa.
        try ( Connection con = db.establishConnection();
              PreparedStatement sql = con.prepareStatement("SELECT * FROM Reservations WHERE " + quest + " LIKE ?") ) {
            ArrayList<Reservation> found = new ArrayList<Reservation>();
            
            sql.setString(1, "%" + ehto + "%");
            try ( ResultSet result = sql.executeQuery() ) {
                while ( result.next() ) {
                    Reservation j = new Reservation();
                    j.parse(result);
                    found.add(j);
                }
            }
            return found;
        } catch ( SQLException e ) {
            throw new HoldException("Error with database: " + e.getMessage());
        }
    }
    


}
