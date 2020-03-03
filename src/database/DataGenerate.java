package database;

import java.time.LocalDate;

/**
 * Assisting class for data ganerating
 * @author Konsta Sakharovskiy 
 * @version Mar 1, 2019
 *
 */
public class DataGenerate {

   
    /**
     * Generate random integer within intervals
     * @param minimum data generate minimum
     * @param maximum data genetrate maximum
     * @return data
     */
    public static int rand(int minimum, int maximum) {
      double n = (maximum-minimum)*Math.random() + minimum;
      return (int)Math.round(n);
    }
   
    // TODO: time to ISO 8601 format
    
    /**
     * @return generated random date data
     */
    public static String generateDate() {
        return  String.format("%02d",rand(1900,2019)) + "-" +
                String.format("%02d",rand(1,12))      + "-" +
                String.format("%02d",rand(1,28));   
    }
    
    /**
     * generate random day of check-out using day of check-in
     * @param i day of chek-in
     * @return  day of check-out within random 1-60 days of stay
     */
    public static String generateNextDate(String i) {        
        int yearIn = Integer.parseInt(i.substring(0,4));
        int monthIn = Integer.parseInt(i.substring(5,7));
        int  dayIn = Integer.parseInt(i.substring(8)); 
        return LocalDate.of( yearIn, monthIn, dayIn ).plusDays(rand(1,60)).toString();       
    }
    
    
    
    /**
     * @example
     * <pre name="test">
     *   int test1 = generateBinary();
     *   (test1 == 1 || test1 == 0) === true;
     * </pre>
     * @return generated random 0 or 1
     */
    public static int generateBinary() {
        return  rand(0,1);   
    }
    
    /**
     * @return generated random gender Mr. or Mrs.
     */
    public static String generateGender() {
        int i = generateBinary();
        if (i == 0 ) return "Mr.";
        return  "Mrs.";   
    }
    
    /**
     * @return generated random true or false
     */
    public static boolean generateLogic() {
        int i = generateBinary();
        if (i == 0 ) return true;
        return  false;   
    }
   
}
