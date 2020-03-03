package bookings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Database handling class
 * <pre>
 *    Kanta kanta = Kanta.alustaKanta("tiedot");
 *    ...
 *    try ( Connection con = kanta.annaKantayhteys() ) {
 *      ...
 *    }  
 * </pre>
 * @author vesal
 * @version 7.2.2015
 *
 */
public class Database {
    private static HashMap<String, Database> databases = new HashMap<String, Database>();
    private String databaseName = "";
    
    /** 
     * Initialize the db
     */
    private Database(String name) {
        setDatabase(name);
    }

    
    /**
     * Initialize database
     * @param name database name
     * @return database's information
     */
    public static Database makeBase(String name) {
        if ( databases.containsKey(name) ) return databases.get(name); 
        Database newDB = new Database(name);
        databases.put(name, newDB);
        return newDB;
    }
    
    
    /**
     * Set the new name of the db
     * @param name new name
     */
    public void setDatabase(String name) {

        databaseName = name;
    }
    
    
    /**
     * Return the full name of the db
     * @return db full name
     */
    public String getDatabaseName() {
        return databaseName + ".db";
    }
    
    
    /**
     * Give established connection to the database
     * @return connection with db
     * @throws SQLException in case of connection exception
     */
    public Connection establishConnection() throws SQLException {
        String sDriver = "org.sqlite.JDBC";
        try {
            Class.forName(sDriver);
        } catch (ClassNotFoundException e) {
            System.err.println("Mistake in class " + sDriver + "uploading: " + e.getMessage());
        }
        return DriverManager.getConnection("jdbc:sqlite:" + getDatabaseName());
    }
    
}