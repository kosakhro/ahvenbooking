package database;

/**
 * Use to check corectness of date input information
 * @author Konsta Sakharovskiy 
 * @version Apr 26, 2019
 *
 */
public class DateCheck {

    /**
     * Use to store days in each month TODO: leap years
     */
    public static int[] MONTHS = {31,29,31,30,31,30,31,31,30,31,30,31};


    /**
     * Check date correctness in format "2001-12-31"
     * @param s input to check
     * @return error text or null if correct
     * @example
     * <pre name="test">
     * DateCheck test = new DateCheck();
     * test.dateCheck("1")       === "Too short input, example: 2001-12-31";
     * test.dateCheck("11111111111") === "Too long input, example: 2001-12-31";
     * test.dateCheck("2200-01-01")  === "Biggest year is 2100";
     * test.dateCheck("1700-02-07")  === "Smallest year is 1900"
     * test.dateCheck("2018-13-01")  === "Month's number too big";
     * test.dateCheck("2018-12-45")  === "Day's number too big";
     * test.dateCheck("2001-01-01")  === null;
     * </pre>
     */  
    public String dateCheck(String s) {
        int l = s.length();
        if ( l < 10 ) return "Too short input, example: 2001-12-31";
        if ( l > 10 ) return "Too long input, example: 2001-12-31";
        try {
            int vv = Integer.parseInt(s.substring(0,4));
            char v1 = s.charAt(4);
            int pv = Integer.parseInt(s.substring(8,10));
            char v2 = s.charAt(7);
            int kk = Integer.parseInt(s.substring(5,7));
            if (vv > 2100) return "Biggest year is 2100";
            if (vv < 1900) return "Smallest year is 1900";
            if (v1 != '-') return "Dash separate, example: 2001-12-31";
            if ( kk < 1 )  return "Month's number too small";
            if ( 12 < kk ) return "Month's number too big";
            if (v2 != '-') return "Dash separate, example: 2001-12-31";
            int pvmkk = MONTHS[kk-1];
            if ( pv < 1 )  return "Day's number too small";
            if ( pvmkk < pv ) return "Day's number too big";
            if (v2 != '-' || v1 != '-') return "Dash separate, example: 2001-12-31";
        } catch(Exception e) {
            return "Only numbers!";
        } 
        
        return null;
    }



}