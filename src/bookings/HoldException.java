
package bookings;

/**
 * Exception class holding exceptions in data structure
 * @author Konsta Sakharovskiy 
 * @version Mar 22, 2019
 *
 */
public class HoldException extends Exception {
    private static final long serialVersionUID = 1L;
    
    
    /**
     * Exception constructor to whom exception message is brought
     * @param message exception message
     */
    public HoldException(String message) {
        super(message);
    }

}
