package bookings;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.*;
import static bookings.Database.makeBase;


/**
 *  maintain the actual information about clients
 *  add remove and change clients                
 *  upload and print clients information         
 *  searching, sorting and filtering
 * @author Konsta Sakharovskiy 
 * @version Mar 5, 2019
 *
 */
public class ClientsBase {


    private Database db;
    private static Client bufferClient = new Client();
    
    
    /**
     * Check if there is table in the db
     * @param name database name
     * @throws HoldException in case of exception
     */
    public ClientsBase(String name) throws HoldException {
        db = makeBase(name);
        try ( Connection con = db.establishConnection() ) {
            /* Obtaining database metadata and checking whether
               There is a table called "Clients".
               If not, create it. Here is no question of whether
               the right structure on the possibly existing board,
               the user can hear it through an error message */
            DatabaseMetaData meta = con.getMetaData();
            
            try ( ResultSet table = meta.getTables(null, null, "Clients", null) ) {
                if ( !table.next() ) {
                    try ( PreparedStatement sql = con.prepareStatement(bufferClient.annaLuontilauseke()) ) {
                        sql.execute();
                    }
                }
            }
            
        } catch ( SQLException e ) {
            throw new HoldException("Error with database: " + e.getMessage());
        }
    }
   
    
    /**
     * main method for testing purposes
     * @param args not in use
     */
    public static void main(String[] args) {
        try {
            new File("testing.db").delete();
            ClientsBase clients = new ClientsBase("testing");
    
            Client donald = new Client(), vladimir = new Client();
            donald.autogenerateContent();
            vladimir.autogenerateContent();
            
            clients.add(donald);
            clients.add(vladimir);
            vladimir.printing(System.out);
            donald.printing(System.out);
            
            System.out.println("=============  test =================");

            int i = 0;
            for (Client client:clients.search("", -1)) {
                System.out.println("Client #: " + i++);
                client.printing(System.out);
            }
            
            new File("testing.db").delete();
        } catch ( HoldException ex ) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * initial
     */
    public ClientsBase(){
        //
    }
        
    /**
     * @param client adding client to clients array
     * @throws HoldException if clients array is full
     * <pre name="test">
     * #THROWS HoldException
     * ClientsBase clients = new ClientsBase();
     * Client ronald = new Client(), george = new Client();
     * clients.getQnt() === 0;
     * clients.add(ronald); clients.getQnt() === 1;
     * clients.add(george); clients.getQnt() === 2;
     * clients.add(ronald); clients.getQnt() === 3;
     * clients.give(0) === ronald;
     * clients.give(1) === george;
     * clients.give(2) === ronald;
     * clients.give(1) == ronald === false;
     * clients.give(1) == george === true;
     * clients.give(3) === ronald; #THROWS IndexOutOfBoundsException
     * clients.add(ronald); clients.getQnt() === 4;
     * clients.add(ronald); clients.getQnt() === 5;
     * clients.add(ronald); clients.getQnt() === 6;
     * clients.add(ronald); clients.getQnt() === 7;
     * clients.add(ronald); clients.getQnt() === 8;
     * clients.add(ronald); // #THROWS HoldException upscaled v.6
     * </pre>
     */
    public void add(Client client) throws HoldException {
        try ( Connection con = db.establishConnection(); PreparedStatement sql = client.annaLisayslauseke(con) ) {
            sql.executeUpdate();
            try ( ResultSet rs = sql.getGeneratedKeys() ) {
               client.tarkistaId(rs);
            }   
            
        } catch (SQLException e) {
            throw new HoldException("Error with database: " + e.getMessage());
        }
    }

    
    /**
     * return collection clients searched by condition
     * @param condition search string
     * @param i position
     * @return selected clients in collection
     * @throws HoldException  exception
     * @example 
     * <pre name="test"> 
     * #THROWS HoldException
     *   #import java.util.Collection;  
     *   ClientsBase clients = new ClientsBase(); 
     *   Client c1 = new Client(); c1.parse("222|Mr.|Bibrik|Tornius||||DC|USA||+1234|+9876|5555|false||facebook.com||||7777||||false"); 
     *   Client c2 = new Client(); c2.parse("333|Mr.|Korma|Tuata||||DC|USA||+1234|+9876|5555|false||facebook.com||||7777||||false");  
     *   Client c3 = new Client(); c3.parse("444|Mr.|Molka|Bambik||||DC|USA||+1234|+9876|5555|false||facebook.com||||7777||||false"); 
     *   Client c4 = new Client(); c4.parse("22|Mr.|Svego|Muu||||DC|USA||+1234|+9876|5555|false||facebook.com||||7777||||false"); 
     *   Client c5 = new Client(); c5.parse("11||Koloolo|Baaya||||DC|USA||+1234|+9876|5555|false||facebook.com||||7777||||false"); 
     *   clients.add(c1); clients.add(c2); clients.add(c3); clients.add(c4); clients.add(c5);
     *   Collection<Client> found;  
     *   found = clients.search("Mr.",1);  
     *   found.size() === 4;
     *   found.contains(c1) === true; 
     *   found = clients.search("*o*",3);  
     *   found.size() === 4;  
     *     
     * </pre> 
     */
    public Collection<Client> search(String condition, int i) throws HoldException{
        String ehto = condition;
        String quest = bufferClient.getQuest(i);
        if ( i < 0 ) { quest = bufferClient.getQuest(0); ehto = ""; }
        // Avataan yhteys tietokantaan try .. with lohkossa.
        try ( Connection con = db.establishConnection();
              PreparedStatement sql = con.prepareStatement("SELECT * FROM Clients WHERE " + quest + " LIKE ?") ) {
            ArrayList<Client> found = new ArrayList<Client>();
            
            sql.setString(1, "%" + ehto + "%");
            try ( ResultSet result = sql.executeQuery() ) {
                while ( result.next() ) {
                    Client j = new Client();
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
