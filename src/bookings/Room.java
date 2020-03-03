
package bookings;

import java.io.PrintStream;

import fi.jyu.mit.ohj2.Mjonot;

/**
 * Does not know Reservations, Clients or Bases 
 * Know and may check type of rooms             
 * Can be added (no change or deleting)         
 * Can deliver information to RoomsBase class   
 * @author Konsta Sakharovskiy 
 * @version Mar 7, 2019
 *
 */
public class Room {
    
    private int reservationNo; // use to assign room to reservation
    private int roomNo; // maintain room number
    private String roomType = ""; // double, single, suite, etc 
    private static int nextNo = 1; //keeps pass-through rooms number
    
     
    

    /**
     * Main used to test the class
     * @param args not in use
     */
    public static void main(String[] args) {
       
        Room testRoom1 = new Room();
        Room testRoom2 = new Room();

        
        testRoom1.register();
        testRoom2.register();
        
        testRoom1.assignRoom(1);
        testRoom2.assignRoom(3);
        
        testRoom1.printing(System.out);
        testRoom2.printing(System.out);
 
    }
    
    /**
     * Assign a uniqe number to the room.
     * @return room number
     * @example
     * <pre name="test">
     *   Room test = new Room();
     *   test.getRoomNo() === 0;
     *   test.register();
     *   Room test2 = new Room();
     *   test2.register();
     *   int n1 = test.getRoomNo();
     *   int n2 = test2.getRoomNo();
     *   n1 === n2-1;
     * </pre>
     */
    public int register() {
        roomNo = nextNo;
        nextNo++;
        return roomNo;          
    }
   
    /**
     * Use to assign room to reservation 
     * @param i reservations id number
     */  
    public void assignRoom(int i) {
        reservationNo = i;
        roomType = "suite";         
    }
    
    /**
     * @param out print info
     */
    public void printing(PrintStream out){
        out.println("Room number: " + String.format("%03d", roomNo) + " Room type: " + roomType );                
    }
    
    /**
     * @return reservation number
     */
    public int getReservationNo() {
        return reservationNo;
    }
    
    /**
     * @return room number
     */
    public int getRoomNo() {
        return roomNo;
    }
    
    /**
     * Set room number when parsing
     * and check if it's bigger than next biggest
     */
    private void setRoomNro(int nr) {
        roomNo = nr;
        if (roomNo >= nextNo) nextNo = roomNo + 1;
    }
    
    @Override
    public String toString() {
        return "" +
                getReservationNo() + "|" +
                getRoomNo() + "|" +
                roomType;
                        
    }
    
    /**
     * Parse data from string separated by "|"
     * @param line string line to parse
     */
    public void parse(String line) {
        StringBuffer sb = new StringBuffer(line);
        reservationNo = Mjonot.erota(sb, '|', reservationNo);
        setRoomNro(Mjonot.erota(sb, '|', getRoomNo()));
        roomType = Mjonot.erota(sb, '|', roomType);
        
    }
    
    @Override
    public boolean equals(Object room) {
        if ( room == null ) return false;
        return this.toString().equals(room.toString());
    }
    
    @Override
    public int hashCode() {
        return roomNo;
    }
       

}
