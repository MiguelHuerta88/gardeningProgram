/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;
import javax.swing.*;
import java.awt.*;
import java.awt.Event;
import java.awt.event.*;
import java.util.ArrayList;
/**
 *
 * @author miguelhuerta
 */
public class cusP extends JPanel{
    private Button btn,btn2,btn3,btn4,btn5,btn6,btn7;
    
    public cusP(){
        btn = new Button("Add Customer");
        btn2 = new Button("Delete Customer");
        btn3 = new Button("Show Customer File");
        btn4 = new Button("Print Bill");
        btn5 = new Button("Pay Bill");
        btn6 = new Button("Update Customer");
        btn7 = new Button("Print Labels");
        setUp();
    }
    private void setUp(){
//        btn.setBackground(Color.RED);
//        btn2.setBackground(Color.RED);
//        btn3.setBackground(Color.RED);
//        btn4.setBackground(Color.RED);
//        btn5.setBackground(Color.RED);
        
        setLayout(new GridLayout(0,3));
        add(btn);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn7);
        
        //set up the even listener
        EOptionListener listener = new EOptionListener();
        
       
         btn.addActionListener(listener); 
         btn2.addActionListener(listener); 
         btn3.addActionListener(listener);
         btn4.addActionListener(listener);
         btn5.addActionListener(listener);
         btn6.addActionListener(listener);
         btn7.addActionListener(listener);
    }
     private class EOptionListener implements ActionListener{
         //--------------------------------------------------------------
      //  Calls the method to process the option for which radio
      //  button was pressed.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event){
           Object source = event.getSource();

           if(source == btn){
              CusPanel cus = new CusPanel(); 
           }
           else if(source == btn2){
              if(Business.business.isEmpty())
              {
                  JOptionPane.showMessageDialog(null, "Must add customer before trying to delete");
              
              }
              else{
              int option = JOptionPane.showConfirmDialog(null,"Deleting customer with address"
                      + "\n\n"+Business.business.get(CusPanel.i) );
                      if(option ==  JOptionPane.OK_OPTION)
                      {
                          Customer temp = Business.business.get(CusPanel.i);
                          deletePropFromList(temp);
                          System.out.println("Size is"+ Business.business.size());
                          System.out.println("the i is"+ CusPanel.i);
                          Business.business.remove(CusPanel.i);
                          System.out.println("Size is"+ Business.business.size());
                          if(Business.business.isEmpty())
                              CusPanel.i = 0;
                          else
                              CusPanel.i = Business.business.size()-1;
                          System.out.println("the i is"+ CusPanel.i);
                      }
                      
              }
              if(!Business.business.isEmpty()){
                  windowFrame.area.setText("Customer being looked at\n\n"+
                                  Business.business.get(CusPanel.i));
              }
              else{
                  windowFrame.area.setText("Customer being looked at");
              }
              
                
              windowFrame.setSaved(false);
           }
           else if (source == btn3){
               if(Business.business.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Must add customer first");
               }
               else{
               Customer temp = Business.business.get(CusPanel.i);
               showCustomer show = new showCustomer(temp);
               }
           }
           else if ( source == btn4){
               if(Business.isSet == false)
               {
                   JOptionPane.showMessageDialog(null, "Must setup owner before continuing");
               }
               else if(Business.business.isEmpty())
               {
                   JOptionPane.showMessageDialog(null, "Currently not viewing any customer");
               }
               else
               {
                  
                  printF print = new printF(Business.business.get(CusPanel.i));
               }
           }
          else if(source == btn5){
              if(Business.business.isEmpty())
              {
                  JOptionPane.showMessageDialog(null, "There are no Customers Available ");
                  
              }
              else{
                  paymentF pay = new paymentF(Business.business.get(CusPanel.i)); 
                }   
          }
          else if(source == btn6){
              if(Business.business.isEmpty()){
                JOptionPane.showMessageDialog(null, "There are no Customers to update!!");  
              }
              else{
              CusUpdate update = new CusUpdate(Business.business.get(CusPanel.i));
              }
          }
           else
          {
               if(Business.business.isEmpty()){
                JOptionPane.showMessageDialog(null, "There are no Customers to update!!");  
              }
               else{
                 printLabels pLabel = new printLabels(Business.business.get(CusPanel.i));  
                 pLabel.printLabel();
               }
              
          }
     }
}
     public void deletePropFromList(Customer temp){
         String searchKey = temp.getPropA();
         for(int i=0;i< Business.list.size();i++){
             if(temp.getPropA().equals(Business.list.get(i))){
                 Business.list.remove(i);
             }
         }
         
     }
}
