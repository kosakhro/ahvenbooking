package bookings;

import java.io.File;
import java.util.Collection;
import java.util.List;


/**
 * Handle ReservationBase, ClientBase, RoomsBase   
 * classes mutual communication and deliver          
 * information on request 
 * reads and writes to the data to program bases   
 * @author Konsta Sakharovskiy 
 * @version Mar 5, 2019 adding reservations
 *
 */
public class CalendarView {
    
    private ClientsBase clients ;
    private ReservationsBase reservations ;
    private RoomsBase rooms = new RoomsBase();
    
    
    
    /**
     * return the client on index i of array
     * @param i place in members array
     * @return client from members array at position i
     * @throws IndexOutOfBoundsException Exception if number is out
     */
    /*public Client giveClient(int i) throws IndexOutOfBoundsException{
        return clients.give(i);
    }*/
    
    /**
     * Search all clients reservations
     * @param client client's object
     * @return list of reservations
     *  * @example
     * <pre name="test">
     * #import java.util.*;
     * 
     *  CalendarView cv = new CalendarView();
     *  Client test1 = new Client(), test2 = new Client(), test3 = new Client();
     *  test1.register(); test2.register(); test3.register();
     *  int id1 = test1.getRegisterNro();
     *  int id2 = test2.getRegisterNro();
     *  Reservation res1 = new Reservation(id1); cv.add(res1);
     *  Reservation res2 = new Reservation(id1); cv.add(res2);
     *  Reservation res3 = new Reservation(id2); cv.add(res3);
     *  Reservation res4 = new Reservation(id2); cv.add(res4);
     *  Reservation res5 = new Reservation(id2); cv.add(res5);
     *  
     *  List<Reservation> found;
     *  found = cv.giveReservations(test3);
     *  found.size() === 0; 
     *  found = cv.giveReservations(test1);
     *  found.size() === 2; 
     *  found.get(0) == res1 === true;
     *  found.get(1) == res2 === true;
     *  found = cv.giveReservations(test2);
     *  found.size() === 3; 
     *  found.get(0) == res3 === true;
     * </pre> 
     * @throws HoldException in case of exception
     */
    public List<Reservation> giveReservations(Client client) throws HoldException {
        return reservations.giveReservations(client.getRegisterNro());
    }
    
    
    /**
     * Search all reservation's rooms
     * @param reservation reservation's object
     * @return list of rooms
     */
    public List<Room> giveRooms(Reservation reservation) {
        return rooms.giveRooms(reservation.getReservationNo());
    }
    
    
    /**
     * @param client adding client to members array
     * @throws HoldException if members is full
     * <pre name="test">
     * #THROWS HoldException
     * CalendarView clients = new CalendarView();
     * Client ronald = new Client(), george = new Client();
     * clients.getClients() === 0;
     * clients.add(ronald); clients.getClients() === 1;
     * clients.add(george); clients.getClients() === 2;
     * clients.add(ronald); clients.getClients() === 3;
     * clients.giveClient(0) === ronald;
     * clients.giveClient(1) === george;
     * clients.giveClient(2) === ronald;
     * clients.giveClient(1) == ronald === false;
     * clients.giveClient(1) == george === true;
     * clients.giveClient(3) === ronald; #THROWS IndexOutOfBoundsException
     * clients.add(ronald); clients.getClients() === 4;
     * clients.add(ronald); clients.getClients() === 5;
     * </pre>
     */
    public void add(Client client) throws HoldException {
        clients.add(client);
    }
    
    /**
     * add reservation to reservations list
     * @param reservation reservation to add
     * @throws HoldException  in case of exception
     */
    public void add(Reservation reservation) throws HoldException {
        reservations.add(reservation);
    }
    
    /**
     * add room to rooms list
     * @param room - room to add
     */
    public void add(Room room) {
        rooms.add(room);
    }
    
    

    
    /**
     * @return clients quantity
     */
    /*public int getClients() {
        return clients.getQnt();
    }*/
    
    /**
     * @return resrvations quantity
     */
    /*public int getReservations() {
        return reservations.getQnt();
    }*/
    
    
    /**
     * Setting name to database
     * @param name - name to db
     */
    /*public void setDataName(String name) {
        File dir = new File(name);
        dir.mkdirs();
        String directoryName = "";
        if ( !name.isEmpty() ) directoryName = name +"/";
        clients.setDataBaseName(directoryName + "clients");
        reservations.setDataBaseName(directoryName + "reservations");
        rooms.setDataBaseName(directoryName + "rooms");
    }*/
    
    
    
    /**
     * Reading data from databases
     * @param name database name
     * @throws HoldException if problem with reading
     */
    /*public void readData(String name) throws HoldException {
        clients = new ClientsBase(); 
        reservations = new ReservationsBase();
        rooms = new RoomsBase();

        setDataName(name);
        clients.readData();
        reservations.readData();
        rooms.readData();

    }*/
    
    
    /**
     * save data to databases
     * @throws HoldException if problem occurs
     */
    /*public void saveData() throws HoldException {
        String mistake = "";
        try {
            clients.saveData();
        } catch ( HoldException ex ) {
            mistake = ex.getMessage();
        }
        
        
        try {
            reservations.saveData();
        } catch ( HoldException ex ) {
            mistake += ex.getMessage();
        }
        
        try {
            rooms.saveData();
        } catch ( HoldException ex ) {
            mistake += ex.getMessage();
        }
        
        
        if ( !"".equals(mistake)) throw new HoldException(mistake);
           
        
    }*/
    
    /**
     * return collection clients searched by condition
     * @param condition condition search string
     * @param i position
     * @return selected clients in collection
     * @throws HoldException  in case of exception
     */ 
    public Collection<Client> searchClient(String condition, int i) throws HoldException{
        
        return clients.search(condition, i);
    }
    

    /**
     * return collection reservations searched by condition
     * @param condition condition search string
     * @param i position
     * @return reservations in collection
     * @throws HoldException in case of exception
     */
    public Collection<Reservation> searchReservation(String condition, int i) throws HoldException{
        
        return reservations.search(condition, i);
    }
    
    
    /**
     * @param nimi database name
     * @throws HoldException in case of exception
     */
    public void lueTiedostosta(String nimi) throws HoldException {
        clients = new ClientsBase(nimi);
        reservations = new  ReservationsBase(nimi);
    }
    
    
    /**
     * main method for test purposes
     * @param args not in use
     */
    public static void main(String[] args) {
        try {
            new File("kokeilu.db").delete();
            CalendarView kerho = new CalendarView();
            kerho.lueTiedostosta("kokeilu");

            Client aku1 = new Client(), aku2 = new Client();
            aku1.autogenerateContent();
            aku2.autogenerateContent();

            kerho.add(aku1);
            kerho.add(aku2);
            int id1 = aku1.getRegisterNro();
            int id2 = aku2.getRegisterNro();
            Reservation pitsi11 = new Reservation(id1); pitsi11.assignReservation(id1);  kerho.add(pitsi11);
            Reservation pitsi12 = new Reservation(id1); pitsi12.assignReservation(id1);  kerho.add(pitsi12);
            Reservation pitsi21 = new Reservation(id2); pitsi21.assignReservation(id2);  kerho.add(pitsi21);
            Reservation pitsi22 = new Reservation(id2); pitsi22.assignReservation(id2);  kerho.add(pitsi22);
            Reservation pitsi23 = new Reservation(id2); pitsi23.assignReservation(id2);  kerho.add(pitsi23);

            System.out.println("============= Kerhon testi =================");
            
            Collection<Client> jasenet = kerho.searchClient("", -1);
            int i = 0;
            for (Client jasen : jasenet) {
                System.out.println("Jäsen paikassa: " + i);
                jasen.printing(System.out);
                List<Reservation> loytyneet = kerho.giveReservations(jasen);
                for (Reservation harrastus : loytyneet)
                    harrastus.printing(System.out);
                i++;
            }

        } catch ( HoldException ex ) {
            System.out.println(ex.getMessage());
        }
        
        new File("kokeilu.db").delete();
    }


}
