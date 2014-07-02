
 
package startframe;

import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author miguelhuerta
 */
public class Business implements Serializable{
    static ArrayList <Customer> business; 
    static ArrayList<String> list;
     static String name, address, city, state, zip;
    static boolean isSet;
    
    public Business(){
        business = new ArrayList<Customer>();
        list = new ArrayList<String>();
        name = "";
        address = "";
        city = "";
        state = "";
        zip = "";
        isSet = false;
        
    }
    public static void setOwner(String nme,String addr,String cty,String ste,String zp){
        name = nme;
        address = addr;
        city = cty;
        state = ste;
        zip = zp;
        isSet = true;
    }
    public static String getName()
    {
        return name;
    }
    public static String getAddress(){
            return address;
    }
     public static String getCSZ(){
            return city + ", "+state+", "+zip;
    }
     public static String getCity()
     {
         return city;
     }
     public static String getState()
     {
         return state;
     }
     public static String getZip()
     {
         return zip;
     }
    public boolean getSet()
    {
        return isSet;
    }
    public void setSet(boolean setting)
    {
        isSet = setting;
    }
   public static String outputinFo(){
       String output = "";
       output+= "Owner Information\n"
               + "Owner Name:"+ name+
               "\nOwner Address:"+ address+
               "\nOwner City"+ city+
               "\nOwner State:"+ state+
               "\nOwner Zip:"+ zip+"\n\n";
       return output;
       
   }
    
}