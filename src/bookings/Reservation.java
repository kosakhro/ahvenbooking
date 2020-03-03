
package bookings;

import java.io.PrintStream;
import database.DateCheck;
import fi.jyu.mit.ohj2.Mjonot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static database.DataGenerate.*;




/**
 * Does not know  Bases or UserInterface            
 * Can be modified                                  
 * Know all reservation columns                     
 * Can check and spell inputs                       
 * Can deliver information to ReservationsBase class
 * @author Konsta Sakharovskiy 
 * @version Mar 8, 2019
 *
 */
public class Reservation implements Cloneable {
    
    private int clientsNo; // use to assign reservation to client
    private int reservationNo; // maintain reservation number
    private static int nextNo = 1; // keeps pass-through reservation number
    
    /// reservation spec variables
    private String dayIn = "";
    private String dayOut = "";
    private String source = "";
    private String residence = "";
    private String managedBy = "";
    private String referenceNo = "";
    private String specialRequest = "";
    private boolean prereseravation;
    
    
    /**
     * use main to test the class
     * @param args not in use
     */
    public static void main(String[] args) {
        
        Reservation testingRes1 = new Reservation();
        Reservation testingRes2 = new Reservation();

        
        testingRes1.assignReservation(777);
        testingRes1.register();
        testingRes1.printing(System.out);
        
        testingRes2.assignReservation(999);
        testingRes2.register();
        testingRes2.printing(System.out);
  
    }
    
    
    /**
     * initializing resrvation
     */
    public Reservation() {
        //access method
    }
      
    /**
     * initialize clients reservation
     * @param clientsNo clients number
     */
    public Reservation (int clientsNo) {
        this.clientsNo = clientsNo;
    }

    /**
     * Assign a uniqe number to the reservation.
     * @return new number
     * @example
     * <pre name="test">
     *   Reservation test = new Reservation();
     *   test.getReservationNo() === 0;
     *   test.register();
     *   Reservation test2 = new Reservation();
     *   test2.register();
     *   int n1 = test.getReservationNo();
     *   int n2 = test2.getReservationNo();
     *   n1 === n2-1;
     * </pre>
     */
    public int register() {
        reservationNo = nextNo;
        nextNo++;
        return reservationNo;     
    }
       
    /**
     * @return reservation number
     */
    public int getReservationNo() {
        return reservationNo;
    }
    
    /**
     * @return clients number
     */
    public int getClientsNo() {
        return clientsNo;
    }
    
    
    /**
     * Use to assign reservation to client 
     * @param i clients id number
     */  
    public void assignReservation(int i) {
        clientsNo = i;
        dayIn = generateDate();
        dayOut = generateNextDate(dayIn);
        source = "Booking.com";
        residence = "leisure";
        specialRequest = "Allergic Free";          
    }
    
    /**
     * @param out print info
     */
    public void printing(PrintStream out){
        out.println("Reservation number: " + String.format("%03d", reservationNo) + " " + 
                    " Clients number: " + clientsNo);
        out.println( "day in: " +  dayIn + " " + "day out: " + dayOut + " " + "source " + source);
        out.println("residence: " + residence + " Special Request: " + specialRequest); 
        out.println("Managed by: " + managedBy + " Reference No: " + referenceNo +
                " Prereservation: " + prereseravation);                
    }
    
    
    /**
     * Set resevation number when parsing
     * and check if it's bigger than next biggest
     */
    private void setReservationNro(int nr) {
        reservationNo = nr;
        if (reservationNo >= nextNo) nextNo = reservationNo + 1;
    }
    
    @Override
    public String toString() {
        return "" +
                getClientsNo() + "|" +
                getReservationNo() + "|" +
                dayIn + "|" +
                dayOut + "|" +
                source + "|" +
                residence + "|" +
                managedBy + "|" +
                referenceNo + "|" +
                specialRequest + "|" +
                prereseravation;
                        
    }
    
    /**
     * Parse data from string separated by "|"
     * @param line string line to parse
     */
    public void parsing(String line) {
        StringBuffer sb = new StringBuffer(line);
        clientsNo = Mjonot.erota(sb, '|', clientsNo);
        setReservationNro(Mjonot.erota(sb, '|', getReservationNo()));
        dayIn = Mjonot.erota(sb, '|', dayIn);
        dayOut = Mjonot.erota(sb, '|', dayOut);
        source = Mjonot.erota(sb, '|', source);
        residence = Mjonot.erota(sb, '|', residence);
        managedBy = Mjonot.erota(sb, '|', managedBy);
        referenceNo = Mjonot.erota(sb, '|', referenceNo);
        specialRequest = Mjonot.erota(sb, '|', specialRequest);
        prereseravation = Boolean.parseBoolean(Mjonot.erota(sb, '|', prereseravation));
        
    }
    
    @Override
    public boolean equals(Object reservation) {
        if ( reservation == null ) return false;
        return this.toString().equals(reservation.toString());
    }
    
    @Override
    public int hashCode() {
        return reservationNo;
    }
   

    /**
     * @return check-in day
     */
    public String getDayIn() {
        
        return dayIn;
    }
    
    /**
     * @return check-out day
     */
    public String getDayOut() {
        
        return dayOut;
    }
    
    /**
     * @return source of reservation
     */
    public String getSource() {
        
        return source;
    }
    
    /**
     * @return type of residence
     */
    public String getResidence() {
        
        return residence;
    }
    
    /**
     * @return reservation's manager
     */
    public String getManagedBy() {
        
        return managedBy;
    }
    
    /**
     * @return reservations's reference number
     */
    public String getReferenceNo() {
        
        return referenceNo;
    }
    
    /**
     * @return client's special request
     */
    public String getSpeialRequest() {
        
        return specialRequest;
    }
    
    
    /**
     * @return prereservation status
     */
    public String getPrereservation() {
        
        return "confirmed";
    }
    
    
    /**
     * return attribut's name by switcher
     * @param k key switcher
     * @return attrubut's name
     */
    public String getQuest(int k) {
        switch ( k ) {
        case 0: return  "reservationNo";
        case 1: return  "clientsNo"   ;
        case 2: return  "dayIn"   ;
        case 3: return  "dayOut" ;
        case 4: return  "source"  ;
        case 5: return  "residence" ;
        case 6: return  "managedBy"     ;
        case 7: return  "referenceNo"    ;
        case 8: return  "specialRequest" ;
        case 9: return  "prereservation"       ;

  
        default: return "";
        }
    }
    
    /**
     * return attributes value as a text by switcher
     * @param k key switcher
     * @return attributes name
     */
    public String give(int k) {
        switch ( k ) {
        case 0: return  "" + reservationNo   ;
        case 1: return  "" + clientsNo       ;
        case 2: return  "" + dayIn           ;
        case 3: return  "" + dayOut          ;
        case 4: return  "" + source          ;
        case 5: return  "" + residence       ;
        case 6: return  "" + managedBy       ;
        case 7: return  "" + referenceNo     ;
        case 8: return  "" + specialRequest  ;
        case 9: return  "" + prereseravation ;

  
        
        default: return "";
        }
    }

    /**
     * @param s input string
     * @return Date of check-in
     */
    public String setDayIn(String s) {        
        DateCheck dc = new DateCheck();
        String typo = dc.dateCheck(s);
        if (typo != null) return typo;
        dayIn = s;
        return null;
    }

    /**
     * @param s input string
     * @return Date of check-out
     */
    public String setDayOut(String s) {
        DateCheck dc = new DateCheck();
        String typo = dc.dateCheck(s);
        if (typo != null) return typo;  
        dayOut = s;
        return null;
    }

    /**
     * @param s input string
     * @return Reservation's source
     */
    public String setSource(String s) {
        source = s;
        return null;
    }

    /**
     * @param s input string
     * @return Residence type
     */
    public String setResidence(String s) {
        residence = s;
        return null;
    }
    
    /**
     * @param s input string
     * @return Reservation's manager
     */
    public String setManagedBy(String s) {
        managedBy = s;
        return null;
    }

    /**
     * @param s input string
     * @return Reservation's reference number
     */
    public String setReferenceNo(String s) {
        referenceNo = s;
        return null;
    }

    /**
     * @param s input string
     * @return Guest's special request
     */
    public String setSpecialRequest(String s) {
        specialRequest = s;
        return null;
    }
    
    /**
     * @param s input string
     * @return Preseservation status
     */
    public String setPrereservation(String s) {
        prereseravation = Boolean.parseBoolean(s); 
        return null;
    }
    
  
    @Override
    public Reservation clone() throws CloneNotSupportedException{
        Reservation reserv;
        reserv = (Reservation) super.clone();
        return reserv;
    }
    
    
    
    
    /**
     * Antaa tietokannan luontilausekkeen harrastustaululle
     * @return harrastustaulun luontilauseke
     */
    public String annaLuontilauseke()  {
        return "CREATE TABLE Reservations (" +
                "reservationNo INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "clientsNo INTEGER, " +
                "dayIn VARCHAR(100) NOT NULL, " +
                "dayOut VARCHAR(100) NOT NULL, " +
                "FOREIGN KEY (clientsNo) REFERENCES Clients(clientsNo)" +
                ")";
    }
    
    
    /**
     * Antaa harrastuksen lisäyslausekkeen
     * @param con tietokantayhteys
     * @return jäsenen lisäyslauseke
     * @throws SQLException Jos lausekkeen luonnissa on ongelmia
     */
    public PreparedStatement annaLisayslauseke(Connection con)
            throws SQLException {
        PreparedStatement sql = con.prepareStatement(
                "INSERT INTO Reservations (reservationNo, clientsNo, dayIn, " +
                "dayOut) VALUES (?, ?, ?, ?)");
        
        // Syötetään kentät näin välttääksemme SQL injektiot.
        // Käyttäjän syötteitä ei ikinä vain kirjoiteta kysely
        // merkkijonoon tarkistamatta niitä SQL injektioiden varalta!
        if ( reservationNo != 0 ) sql.setInt(1, reservationNo); else sql.setString(1, null);
        sql.setInt(2, clientsNo);
        sql.setString(3, dayIn);
        sql.setString(4, dayOut);
        
        return sql;
    }
    
    /**
     * Tarkistetaan onko id muuttunut lisäyksessä
     * @param rs lisäyslauseen ResultSet
     * @throws SQLException jos tulee jotakin vikaa
     */
    public void checkId(ResultSet rs) throws SQLException {
        if ( !rs.next() ) return;
        int id = rs.getInt(1);
        if ( id == reservationNo ) return;
        setReservationNro(id);
    }
    
    /**
     * Otetaan tiedot ResultSetistä
     * @param tulokset mistä tiedot otetaan
     * @throws SQLException Jos jokin menee vikaan
     */
    public void parse(ResultSet tulokset) throws SQLException {
        setReservationNro(tulokset.getInt("reservationNo"));
        clientsNo = tulokset.getInt("clientsNo");
        dayIn = tulokset.getString("dayIn");
        dayOut = tulokset.getString("dayOut");
    }

    
    
    /**
     * Antaa harrastuksen päivityslausekkeen
     * @param con tietokantayhteys
     * @return harrastuksen päivityslauseke
     * @throws SQLException Jos lausekkeen luonnissa on ongelmia
     */
    @SuppressWarnings("unused")
    public PreparedStatement annaPaivityslauseke(Connection con)
            throws SQLException {
        return null;
    }
    
    
    /**
     * Antaa harrastuksen poistolausekkeen
     * @param con tietokantayhteys
     * @return harrastuksen poistolauseke
     * @throws SQLException Jos lausekkeen luonnissa on ongelmia
     */
    @SuppressWarnings("unused")
    public PreparedStatement annaPoistolauseke(Connection con)
            throws SQLException {
        return null;
    }
    
 

}
