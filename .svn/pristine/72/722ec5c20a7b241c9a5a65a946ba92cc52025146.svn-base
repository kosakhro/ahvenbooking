package bookings;

import java.sql.*;

import java.io.PrintStream;

import fi.jyu.mit.ohj2.Mjonot;

import static database.DataGenerate.*;







/**
 * Does not know  Bases or UserInterface             
 * Can be modified                                   
 * Know all clients     columns                      
 * Can check and spell inputs                        
 * Can deliver information to ClientsBase class 
 * @author Konsta Sakharovskiy 
 * @version Mar 1, 2019
 *
 */
public class Client implements Cloneable {

    private int registerNo; // maintain registration number
    private static int nextNo = 1; //keeps pass-through reg number
    
    /// Name and address variables
    private String     title          = "";
    private String     name           = "";
    private String     surname        = "";
    private String     street         = "";
    private String     street2        = "";
    private String     zip            = "";   
    private String     city           = "";
    private String     country        = "";
    
    /// Contact variables
    private String     email          = "";
    private String     phone          = "";
    private String     phone2         = "";
    private String     fax            = "";
    private boolean    subscript          ;
    private String     otherContact   = "";
    private String     some           = "";
    private String     language       = "";
    private String     comments       = "";
    
    /// id and other datails variables
    private String     nationality    = "";
    private String     passportNo     = "";
    private String     dateOfBirth    = "";
    private String     socialSecNo    = "";
    private String     account        = "";
    private boolean    loyality           ;
     
    /**
     * Main used to test the class
     * @param args not in use
     */
    public static void main(String args[]) {
        

        Client donald = new Client(), kim = new Client();
        
        donald.register();
        kim.register();

        
        donald.printing(System.out);

        donald.autogenerateContent();
        donald.printing(System.out);
        
        
        kim.printing(System.out);
        kim.autogenerateContent();
        kim.printing(System.out);
        
        Client client = new Client();
        client.parse("0|Mrs.|Trolland|Dump|1600 Pennsylvania Ave|Oval Office|20500|DC|USA|dump@thewhitehouse.gov|+1234|+9876|0101010|true||facebook.com||gluten free breakfast|Citizen Of The World|7777|1938-03-05|||false");
        System.out.println(client.toString());
        
        
    }

    /**
     * fill dump info 
     */
    public void autogenerateContent() {
        
        title = generateGender();
        name = "Kostosiki";
        surname = "Memasiki";
        dateOfBirth = generateDate();
        street = "nklsfnlkf";
        street2 = "Oaskcnaklscnle";
        zip = "11111";
        city = "NNMM";
        country = "USA";
        email = "dump@thewhitehouse.gov";
        phone = "+1234";
        phone2 = "+9876";
        fax = "0101010";
        //subscript = generateLogic(); test boolean parcing
        some = "facebook.com";
        comments = "gluten free breakfast";
        nationality = "Citizen Of The World";
        passportNo = "7777";
        //loyality = generateLogic(); test boolean parcing
        
    }


       
    /**
     * Assign a uniqe number to the client.
     * @return new number
     * @example
     * <pre name="test">
     *   Client kim = new Client();
     *   kim.getRegisterNro() === 0;
     *   kim.register();
     *   Client chen = new Client();
     *   chen.register();
     *   int n1 = kim.getRegisterNro();
     *   int n2 = chen.getRegisterNro();
     *   n1 === n2-1;
     * </pre>
     */
     public int register() {
        registerNo = nextNo;
        nextNo ++;
        return registerNo;
        
    }
     
     /**
     * @return clients number
     */
    public int getRegisterNro() {
         return registerNo;
     }
    
    /**
    * @return clients name
    */
   public String getName() {
        return name ;
    }    
    
   
   
   
    
    /**
     * @param out print info
     */
    public void printing(PrintStream out){
        out.println(String.format("%03d", registerNo) + " " + " " + title + " " 
                + name + " " + surname + " " + dateOfBirth);
        out.println(" " + street + " " + street2 + " " + zip + " " + city
                + " " + country + " " + language);
        out.println("  email: " + email +
                "  main phone: " + phone +
                " second phone: " + phone2 +
                " fax: " + fax + " " + otherContact);
        out.println("" + subscript + " " + " " + some + " " + " " + comments );
        out.println("   Nationality: " + nationality + " " + passportNo + " "  + 
                 " " + socialSecNo + " " + account + " " + loyality );
        
    }
    
    /*
     * Set register number when parsing
     * and check if it's bigger than next biggest
     */
    private void setRegisterNro(int nr) {
        registerNo = nr;
        if (registerNo >= nextNo) nextNo = registerNo + 1;
    }
    
    
    @Override
    public String toString() {
        return "" +
                getRegisterNro() + "|" +
                title + "|" +
                name + "|" +
                surname + "|" +
                street + "|" +
                street2 + "|" +
                zip + "|" +
                city + "|" +
                country + "|" +
                email + "|" +
                phone + "|" +
                phone2 + "|" +
                fax + "|" +
                subscript + "|" +
                otherContact + "|" +
                some + "|" +
                language + "|" +
                comments + "|" +
                nationality + "|" +
                passportNo + "|" +
                dateOfBirth + "|" +
                socialSecNo + "|" +
                account + "|" +
                loyality;
                        
    }
    
    /**
     * Parse data from string separated by "|"
     * @param line string line to parse
     * @example
     * <pre name="test">
     *   Client client = new Client();
     *   client.parse(" 1 |Mr.|Donald| Trump|||||||||||||||||||");
     *   client.getRegisterNro() === 1;
     *   client.toString().startsWith("1|Mr.|Donald|Trump||||||||||false||||||||||false") === true; 
     *
     *   client.register();
     *   int n = client.getRegisterNro();
     *   client.parse(""+(n+20));      
     *   client.register();          
     *   client.getRegisterNro() === n+20+1;
     *     
     * </pre>
     */
    public void parse(String line) {
        StringBuffer sb = new StringBuffer(line);
        setRegisterNro(Mjonot.erota(sb, '|', getRegisterNro()));
        title = Mjonot.erota(sb, '|', title);
        name = Mjonot.erota(sb, '|', name);
        surname = Mjonot.erota(sb, '|', surname);
        street = Mjonot.erota(sb, '|', street);
        street2 = Mjonot.erota(sb, '|', street2);
        zip = Mjonot.erota(sb, '|', zip);
        city = Mjonot.erota(sb, '|', city);
        country = Mjonot.erota(sb, '|', country);
        email = Mjonot.erota(sb, '|', email);
        phone = Mjonot.erota(sb, '|', phone);
        phone2 = Mjonot.erota(sb, '|', phone2);
        fax = Mjonot.erota(sb, '|', fax);
        subscript = Boolean.parseBoolean(Mjonot.erota(sb, '|', subscript));
        otherContact = Mjonot.erota(sb, '|', otherContact);
        some = Mjonot.erota(sb, '|', some);
        language = Mjonot.erota(sb, '|', language);
        comments = Mjonot.erota(sb, '|', comments);
        nationality = Mjonot.erota(sb, '|', nationality);
        passportNo = Mjonot.erota(sb, '|', passportNo);
        dateOfBirth = Mjonot.erota(sb, '|', dateOfBirth);
        socialSecNo = Mjonot.erota(sb, '|', socialSecNo);
        account = Mjonot.erota(sb, '|', account);
        loyality = Boolean.parseBoolean(Mjonot.erota(sb, '|', loyality));
        
    }
    
    
    @Override
    public boolean equals(Object client) {
        if ( client == null ) return false;
        return this.toString().equals(client.toString());
    }
    
    
    @Override
    public int hashCode() {
        return registerNo;
    }

    /**
     * @return Surname
     */
    public String getSurame() {
        
        return surname;
    }
    
    /**
     * @return Street
     */
    public String getStreet() {
        
        return street;
    }
    
    /**
     * @return Street2
     */
    public String getStreet2() {
        
        return street2;
    }
    
    /**
     * @return ZIP
     */
    public String getZIP() {
        
        return zip;
    }
    
    /**
     * @return City
     */
    public String getCity() {
        
        return city;
    }
    
    /**
     * @return Country
     */
    public String getCountry() {

        return country;
    }
    
    /**
     * @return Email
     */
    public String getEmail() {
        
        return email;
    }
    
    /**
     * @return Phone
     */
    public String getPhone() {
        
        return phone;
    }

    /**
     * @return Second Phone
     */
    public String getPhone2() {
        
        return phone2;
    }

    /**
     * @return Fax
     */
    public String getFax() {
       
        return fax;
    }

    /**
     * @return Subscription
     */
    public String getSubscript() {
        
        return "false"; //TODO: make boolean to string
    }

    /**
     * @return Other type of contact
     */
    public String getOtherContact() {
        
        return otherContact;
    }

    /**
     * @return Social media
     */
    public String getSome() {
        
        return some;
    }

    /**
     * @return Language
     */
    public String getLanguage() {
        
        return language;
    }

    /**
     * @return Comments
     */
    public String getComments() {
        
        return comments;
    }

    /**
     * @return Nationality
     */
    public String getNationality() {
        
        return nationality;
    }

    /**
     * @return Passport number
     */
    public String getPassportNo() {
        
        return passportNo;
    }

    /**
     * @return Date of birth
     */
    public String getDateOfBirt() {
       
        return dateOfBirth;
    }

    /**
     * @return Social security number
     */
    public String getSocialSecNo() {
        
        return socialSecNo;
    }

    /**
     * @return Account number
     */
    public String getAccount() {
        
        return account;
    }

    /**
     * @return Loyality program
     */
    public String getLoyality() {
      
        return "false"; //TODO: make boolean to string
    }

    /**
     * @return Title
     */
    public String getTitle() {
    
        return title;
    }
    


    
    
    /**
     * return attribut's name by switcher
     * @param k key switcher
     * @return attrubut's name
     */
    public String getQuest(int k) {
        switch ( k ) {
        case 0: return  "resgisterNo";
        case 1: return  "title"   ;
        case 2: return  "name"   ;
        case 3: return  "surname" ;
        case 4: return  "street"  ;
        case 5: return  "street2" ;
        case 6: return  "zip"     ;
        case 7: return  "city"    ;
        case 8: return  "country" ;
        case 9: return  "email"       ;
        case 10: return  "phone"        ;
        case 11: return  "phone2"       ;
        case 12: return  "fax"          ;
        case 13: return  "subscript"    ;
        case 14: return  "otherContact" ;
        case 15: return  "some"         ;
        case 16: return  "language"     ;
        case 17: return  "comments"     ;
        case 18: return  "nationality" ;
        case 19: return  "passportNo"  ;
        case 20: return  "dateOfBirth" ;
        case 21: return  "socialSecNo" ;
        case 22: return  "account"    ; 
        case 23: return  "loyality"    ; 
  
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
        case 0: return  "" +  registerNo   ;
        case 1: return  "" +  title   ;
        case 2: return  "" +  name   ;
        case 3: return  "" +  surname ;
        case 4: return  "" +  street  ;
        case 5: return  "" +  street2;
        case 6: return  "" +  zip   ;
        case 7: return  "" +  city    ;
        case 8: return  "" +  country      ;
        case 9: return  "" +  email        ;
        case 10: return  "" + phone        ;
        case 11: return  "" + phone2       ;
        case 12: return  "" + fax          ;
        case 13: return  "" + subscript    ;
        case 14: return  "" + otherContact ;
        case 15: return  "" + some         ;
        case 16: return  "" + language     ;
        case 17: return  "" + comments     ;
        case 18: return  "" + nationality  ;
        case 19: return  "" + passportNo   ;
        case 20: return  "" + dateOfBirth  ;
        case 21: return  "" + socialSecNo  ;
        case 22: return  "" + account      ; 
        case 23: return  "" + loyality     ; 
  
        
        default: return "";
        }
    }

    /**
     * @param s input string
     * @return Name
     */
    public String setName(String s) {
        
        name = s;
        return null;
    }

    /**
     * @param s input string
     * @return Surname
     */
    public String setSurname(String s) {
        surname = s;
        return null;
    }

    /**
     * @param s input string
     * @return Street
     */
    public String setStreet(String s) {
        street = s;
        return null;
    }

    /**
     * @param s input string
     * @return Second street
     */
    public String setStreet2(String s) {
        street2 = s;
        return null;
    }

    /**
     * @param s input string
     * @return ZIP code
     */
    public String setZIP(String s) {
        zip = s;
        return null;
    }

    /**
     * @param s input string
     * @return City
     */
    public String setCity(String s) {
        city = s;
        return null;
    }
    
    /**
     * @param s input string
     * @return Country
     */
    public String setCountry(String s) {
        country = s;
        return null;
    }

    /**
     * @param s input string
     * @return email
     */
    public String setEmail(String s) {
        email = s;
        return null;
    }

    /**
     * @param s input string
     * @return Phone
     */
    public String setPhone(String s) {
        phone = s;
        return null;
    }

    /**
     * @param s input string
     * @return Second phone
     */
    public String setPhone2(String s) {
        phone2 = s;
        return null;
    }

    /**
     * @param s input string
     * @return Fax
     */
    public String setFax(String s) {
        fax = s;
        return null;
    }

    /**
     * @param s input string
     * @return Subscription status
     */
    public String setSubscript(String s) {
        subscript = Boolean.parseBoolean(s); 
        return null;
    }

    /**
     * @param s input string
     * @return Other contact
     */
    public String setOtherConta(String s) {
        otherContact = s;
        return null;
    }

    /**
     * @param s input string
     * @return Social media
     */
    public String setSome(String s) {
        some = s;
        return null;
    }

    /**
     * @param s input string
     * @return Language
     */
    public String setLanguage(String s) {
        language = s;
        return null;
    }

    /**
     * @param s input string
     * @return Comments
     */
    public String setComments(String s) {
        comments = s;
        return null;
    }

    /**
     * @param s input string
     * @return Nationality
     */
    public String setNationalit(String s) {
        nationality = s;
        return null;
    }

    /**
     * @param s input string
     * @return Date of birth
     */
    public String setDateOfBirt(String s) {
        dateOfBirth = s;
        return null;
    }

    /**
     * @param s input string
     * @return Passport number
     */
    public String setPassportNo(String s) {
        passportNo = s;
        return null;
    }

    /**
     * @param s input string
     * @return Social security number
     */
    public String setSocialSecN(String s) {
        socialSecNo = s;
        return null;
    }

    /**
     * @param s input string
     * @return Account 
     */
    public String setAccount(String s) {
        account = s;
        return null;
    }

    /**
     * @param s input string
     * @return Loyality status
     */
    public String setLoyality(String s) {
        loyality = Boolean.parseBoolean(s); 
        return null;
    }

    /**
     * @param s input string
     * @return Title
     */
    public String setTitle(String s) {
        title = s;
        return null;
    }
    
    
    
    @Override
    public Client clone() throws CloneNotSupportedException{
        Client client;
        client = (Client) super.clone();
        return client;
    }

    /**
     * Antaa tietokannan luontilausekkeen jäsentaululle
     * @return jäsentaulun luontilauseke
     */
    public String annaLuontilauseke() {
        return "CREATE TABLE Clients (" +
                "resgisterNo INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "title VARCHAR(11) , " +
                "name VARCHAR(100), " +
                "surname VARCHAR(100) " +


                
                // "PRIMARY KEY (jasenID)" + 
                ")";
    }
    
    
    /**
     * Antaa jäsenen lisäyslausekkeen
     * @param con tietokantayhteys
     * @return jäsenen lisäyslauseke
     * @throws SQLException Jos lausekkeen luonnissa on ongelmia
     */
    public PreparedStatement annaLisayslauseke(Connection con)
            throws SQLException {
        PreparedStatement sql = con.prepareStatement("INSERT INTO Clients" +
                "(resgisterNo, title, name, surname) " +
                "VALUES (?, ?, ?, ?)");
        
        // Syötetään kentät näin välttääksemme SQL injektiot.
        // Käyttäjän syötteitä ei ikinä vain kirjoiteta kysely
        // merkkijonoon tarkistamatta niitä SQL injektioiden varalta!
        if ( registerNo != 0 ) sql.setInt(1, registerNo); else sql.setString(1, null);
        sql.setString(2, title);
        sql.setString(3, name);
        sql.setString(4, surname);

        
        return sql;
    }
    

    /**
     * Tarkistetaan onko id muuttunut lisäyksessä
     * @param rs lisäyslauseen ResultSet
     * @throws SQLException jos tulee jotakin vikaa
     */
    public void tarkistaId(ResultSet rs) throws SQLException {
        if ( !rs.next() ) return;
        int id = rs.getInt(1);
        if ( id == registerNo ) return;
        setRegisterNro(id);
    }
    
    
    /** 
     * Ottaa jäsenen tiedot ResultSetistä
     * @param tulokset mistä tiedot otetaan
     * @throws SQLException jos jokin menee väärin
     */
    public void parse(ResultSet tulokset) throws SQLException {
        setRegisterNro(tulokset.getInt("resgisterNo"));
        title = tulokset.getString("title");
        name = tulokset.getString("name");
        surname = tulokset.getString("surname");

    }


    




    
   
}