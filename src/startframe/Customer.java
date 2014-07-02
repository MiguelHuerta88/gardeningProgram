/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.*;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author miguelhuerta
 */
public class Customer implements Serializable{
    private String name,address,propAddr,city,state,zip,price;
    //private Double price;
    private ArrayList<String> paymentHis;//stores the dates for payments
    private ArrayList<String>paymentMade;//stores the amount paid
    //both paymentHis and paymentMade must be added at same time so we can we on same index on size
    
    
    public Customer(String propA,String name,String addr,String cty,String ste,String zp,String prce)
    {
        this.propAddr = propA;
        this.name = name;
        this.address = addr;
        this.city = cty;
        this.state = ste;
        this.zip = zp;
        this.price = prce;
        paymentHis = new ArrayList<String>();
        paymentMade = new ArrayList<String>();
    }
    public void changeName(String nme){
        this.name = nme;
    }
    public void changeCity(String cty){
        this.city = cty;
    }
    public void changeAddr(String addr){
        this.address = addr;
    }
    public void changePropA(String propA){
        this.propAddr = propA;
    }
    public void changeState(String ste){
        this.state = ste;
    }
    public void changeZip(String zp){
        this.zip = zp;
    }
    public void changePrice(String amt){
        this.price = amt;
    }
    public String getName()
    {
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public String getPropA(){
        return this.propAddr;
        
    }
    public String getCity(){
        return this.city;
    }
    public String getState(){
        return this.state;
    }
    public String getZip(){
        return this.zip;
    }
    public String getPrice(){
        return this.price;
    }
    public void payBill(String month,String amt){
        //must split the string when we output the info in the frames
        SimpleDateFormat ft = new SimpleDateFormat("MM/yyyy");
        Date date = new Date();
        //ft.format(date);
        
        paymentHis.add("("+ft.format(date)+")"+month);
        
        //add a timestamp to the payment in parenthenses
        
        paymentMade.add(amt);
    }
    public String toString(){
        double tAmt = Double.parseDouble(this.getPrice());
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String message = "";
        message+= "Property Address: "+this.getPropA()+
                "\nName: "+this.getName()+
                "\nAddress: "+this.getAddress()+
                "\nCity: "+this.getCity()+
                "\nState: "+this.getState()+
                "\nZip: "+this.getZip()+
                "\nPrice:"+ fmt.format(tAmt);
        
        return message;
    }
    public String listPayment(){
        String line="Payment History\n\n";
        
        double tAmt;
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        line+=String.format("%-30s %15s %n","Month","Amount Paid");
        
        for(int i = 0;i<paymentHis.size();i++)
        {
           
            double amt =Double.parseDouble(paymentMade.get(i));
            //String[] result = paymentHis.get(i).split("\\:");
        
                line += String.format("%-30s"+ "%15s"+"%n",paymentHis.get(i) ,fmt.format(amt));
            
           
            //line += String.format("%-45s    %15d %n", paymentHis.get(i),"$"+paymentMade.get(i));
            //line += paymentHis.get(i) + "\t" + paymentMade.get(i) + "\n";
        }
        return line;
    }
    public String getLstAmount(){
        if(paymentMade.isEmpty()){
            return "0";
        }
        else{
            return paymentMade.get(paymentMade.size()-1);
        }
    }
    public String getLstMonth(){
        if(paymentHis.isEmpty())
        {
            return "Customer has not yet paid";
        }
        else{
            return paymentHis.get(paymentHis.size()-1);
        }
    }
            
}
