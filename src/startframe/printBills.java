/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author miguelhuerta
 */
public class printBills {
    
    Customer c;
    public printBills(){
       if(Business.business.isEmpty()){
          JOptionPane.showMessageDialog(null, "No customers"); 
       }
       else{
         String date = JOptionPane.showInputDialog("Date: ");
         String year = JOptionPane.showInputDialog("20/ ");
         String month = JOptionPane.showInputDialog("Enter Months of Service: ");
         int i=0; 
         while(i < Business.business.size()){
         c = (Customer)Business.business.get(i);
          windowFrame.area.setText("Customer being looked at\n"+"\n"+c);
          //print = new printF(c);
          int check;
          String cus = "Next Customer:\n"+ c.getPropA();
          check = JOptionPane.showConfirmDialog(null, cus,"Alert!",JOptionPane.YES_NO_CANCEL_OPTION);
          if(check == JOptionPane.YES_OPTION){
           
          String area="";
          String xtr = "";
          printBill bill = new printBill(c,date,year,month,area,xtr,c.getPrice());
          bill.printbill();
          }
          else if (check == JOptionPane.CANCEL_OPTION)
          {
              break;
          }
          i++;
         }
        
    
}
       }
    }
           
    
    

