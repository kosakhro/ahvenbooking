
package bookings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * maintain the actual information about rooms 
 * add room to reservation  
 * @author Konsta Sakharovskiy 
 * @version Mar 8, 2019
 *
 */
public class RoomsBase implements Iterable<Room>  {

    private Collection<Room> rooms = new ArrayList<Room>();
    private String           fullName        = "";
    private String           dataBaseName    = "";
    
    
    
    /**
     * main method to test class
     * @param args not in use
     */
    public static void main(String[] args) {
        
        RoomsBase rb = new RoomsBase();
        
        Room room1 = new Room();
        Room room2 = new Room();
        Room room3 = new Room();
        
        room1.register();
        room2.register();
        room3.register();
        
        room1.assignRoom(101);
        room2.assignRoom(202);
        room3.assignRoom(101);
        
        rb.add(room1);
        rb.add(room2);
        rb.add(room3);
        
        List<Room> rooms2 = rb.giveRooms(101);
        
        for (Room rm : rooms2) {
            System.out.println("========================================");
            rm.printing(System.out);
        }  
    }
        
    /**
     * add room to rooms list
     * @param rm room to add
     */
    public void add(Room rm) {
        rooms.add(rm);
    }
    
    /**
     * @return rooms quantity
     */
    public int getQnt() {
        return rooms.size();
    }
    
    /**
     * Itarate through all rooms
     * @return rooms iterator
     * 
     * @example
     * <pre name="test">
     * #PACKAGEIMPORT
     * #import java.util.*;
     * 
     *  RoomsBase test = new RoomsBase();
     *  Room res1 = new Room(); test.add(res1);
     *  Room res2 = new Room(); test.add(res2);
     *  Room res3 = new Room(); test.add(res3);
     *  Room res4 = new Room(); test.add(res4);
     *  Room res5 = new Room(); test.add(res5);
     * 
     *  Iterator<Room> testIterator = test.iterator();
     *  testIterator.next() === res1;
     *  testIterator.next() === res2;
     *  testIterator.next() === res3;
     *  testIterator.next() === res4;
     *  testIterator.next() === res5;
     *  testIterator.next() === res1;  #THROWS NoSuchElementException  
     *  
     * </pre>
     */   
    @Override
    public Iterator<Room> iterator() {
        
        return rooms.iterator();
    }
    
    /**
     * Search and return rooms by reservation id
     * @param reservationNo reservation number
     * @return found rooms in list
     */
    public List<Room> giveRooms(int reservationNo) {
        List<Room> found = new ArrayList<Room>();
        for (Room rm : rooms)
            if (rm.getReservationNo() == reservationNo) found.add(rm);
        return found;
    }
    
    
    /**
     * Read rooms  data from database
     * @param databaseName name of database
     * @throws HoldException if reading problems occur
     */
    public void readData(String databaseName) throws HoldException {
        setDataBaseName(databaseName);
        try ( BufferedReader fi = new BufferedReader(new FileReader(getDataName())) ) {
            fullName = fi.readLine();
            if ( fullName == null ) throw new HoldException("missed name");
            String line = fi.readLine();
            if ( line == null ) throw new HoldException("miss the size");


            while ( (line = fi.readLine()) != null ) {
                line = line.trim();
                if ( "".equals(line) || line.charAt(0) == ';' ) continue;
                Room room = new Room();
                room.parse(line);
                add(room);
            }
        } catch ( FileNotFoundException e ) {
            throw new HoldException("Can't open " + getDataName());
        } catch ( IOException e ) {
            throw new HoldException("probblemm: " + e.getMessage());
        }
    }
    
    /**
     * @throws HoldException if reading problem occurs
     */
    public void readData() throws HoldException {
        readData(getDataBaseName());
    }
    
    
    /**
     * Save rooms data to database
     * @throws HoldException if saving problem occurs
     * @example
     * <pre name="test">
     * #THROWS HoldException 
     * #import java.io.File;
     * #import java.util.Iterator;
     * 
     *  RoomsBase rooms = new RoomsBase();
     *  Room room1 = new Room(), room2 = new Room();
     *  room1.assignRoom(777);
     *  room1.register();
     *  room2.assignRoom(555);
     *  room2.register();
     *  String folder = "testings";
     *  String databaseName = folder+"/rooms";
     *  File dir = new File(folder);
     *  dir.mkdir();
     *  
     *  rooms.readData(databaseName); #THROWS HoldException
     *  rooms.add(room1);
     *  rooms.add(room2); 
     *  Iterator<Room> i = rooms.iterator();
     *  i.next() === room1;
     *  i.next() === room2;
     *  i.hasNext() === false;
     *  rooms.saveData();
     *  
     *  rooms = new RoomsBase(); 
     *  rooms.readData(databaseName);
     *  Iterator<Room> u = rooms.iterator();
     *  u.next() === room1;
     *  u.next() === room2;
     *  u.hasNext() === false;    
     *  rooms.add(room2);
     *  rooms.saveData();
     *  File bakOver = new File(databaseName+".bak");
     *  bakOver.delete() === true;
     *  File datOver = new File(databaseName+".dat");
     *  datOver.delete() === true;
     * </pre>
     */
    public void saveData() throws HoldException {
        File fbak = new File(getBakName());
        File ftied = new File(getDataName());
        fbak.delete(); 
        ftied.renameTo(fbak); 

        try ( PrintWriter fo = new PrintWriter(new FileWriter(ftied.getCanonicalPath())) ) {
            fo.println(getFullName());
            fo.println(rooms.size());
            for (Room room : this) {
                fo.println(room.toString());
            }
        } catch ( FileNotFoundException ex ) {
            throw new HoldException("Database " + ftied.getName() + " can't open");
        } catch ( IOException ex ) {
            throw new HoldException("Database " + ftied.getName() + " writing problem");
        }

    }
    
    
    /**
     * return collection rooms searched by condition
     * @param condition search string
     * @param i position
     * @return reservations in collection
     */
    @SuppressWarnings("unused")
    public Collection<Room> search(String condition, int i){
        Collection<Room> found = new ArrayList<Room>();
        for  (Room room : this) {
            found.add(room);
        }
        return found;
    }
    
    
    /**
     * getting database backup name
     * @return database backup name
     */
    public String getBakName() {
        return dataBaseName + ".bak";
    }
    
    /**
     * getting database dat name
     * @return database dat name
     */
    public String getDataName() {
        return getDataBaseName() + ".dat";
    }
    
    /**
     * setting database name
     * @param name database name
     */
    public void setDataBaseName(String name) {
        dataBaseName = name;
    }
    
    /**
     * getting database name
     * @return database name
     */
    public String getDataBaseName() {
        return dataBaseName;
    }
    
    /**
     * getting database full name
     * @return full name
     */
    public String getFullName() {
        return fullName;
    }
 
    
    

}
