/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author miguelhuerta
 */
public class paymentF {
   JFrame payF = new JFrame("Make A Payment");
   Button btn,btn2;
   JTextArea xtrA;
   JTextField monthF,paymentF,xtrAmF;
   Customer temp;
   public paymentF(Customer c){
       temp = c;
       payF.setPreferredSize(new Dimension(900,320));
       
       //set up the text pane to list the PAyment history
       JTextArea area = new JTextArea(30,30);
       area.setEditable(false);
       JScrollPane pane = new JScrollPane(area);
       area.setFont(new Font("Monospaced",Font.PLAIN,13));
       pane.setSize(new Dimension(450,290));
       JPanel panel = new JPanel();
       panel.setSize(new Dimension(450,290));
       String n = "Listing Customer by the name of: \n";
       
       //JLabel nameL = new JLabel("Listing Customer by the name of: ");
       JTextArea nameArea = new JTextArea(5,20);
       nameArea.setEditable(false);
       //nameArea.setText(n);
       nameArea.setFont(new Font("Times New Roman\n",Font.BOLD,18));
       nameArea.setEditable(false);
       nameArea.setLineWrap(true);
       
       panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
       //panel.add(nameL);
       panel.add(nameArea);
       panel.add(pane);
       
       JPanel field = new JPanel();
       field.setLayout(new FlowLayout(BoxLayout.X_AXIS));
       
       JPanel field2 = new JPanel();
       field2.setLayout(new FlowLayout(BoxLayout.X_AXIS));
       JLabel monthL = new JLabel("Month paying: ");
       JLabel paymentL = new JLabel("Amount Paid: $");
       paymentF = new JTextField(5);
       monthF = new JTextField(10);
       
       field.add(monthL);
       field.add(monthF);
       field2.add(paymentL);
       field2.add(paymentF);
       
       JPanel p = new JPanel();
       p.setLayout(new FlowLayout(FlowLayout.RIGHT));
       p.add(field);
       p.add(field2);
       
       paymentListener listen = new paymentListener();
       btn = new Button("PAY");
       btn2 = new Button("CANCEL");
       btn.addActionListener(listen);
       btn2.addActionListener(listen);
       JPanel buttonP = new JPanel();
       buttonP.setLayout(new FlowLayout(FlowLayout.RIGHT));
       buttonP.add(btn);
       buttonP.add(btn2);
       
       JPanel xtr = new JPanel();
       xtr.setLayout(new FlowLayout(FlowLayout.RIGHT));
       xtrA = new JTextArea(2,10);
       xtrA.setLineWrap(true);
       JLabel xtraL = new JLabel("Extra Charges: ");
       JLabel xtrAm = new JLabel("Amount: $");
       xtrAmF = new JTextField(5);
       xtr.add(xtraL);
       xtr.add(xtrA);
       xtr.add(xtrAm);
       xtr.add(xtrAmF);
       
       p.add(buttonP);
           
       
       JPanel btnF = new JPanel();
       btnF.setLayout(new BoxLayout(btnF,BoxLayout.Y_AXIS));
       btnF.add(p);
      // btnF.add(xtr);
       btnF.add(buttonP);
       
      //put all the pieces back together in the frame
       payF.add(panel);
       payF.add(btnF);
       payF.setBackground(new Color(139,139,131));
       payF.pack();
       payF.setLocation(1000, 10);
       payF.setVisible(true);
       
        if(Business.business.isEmpty()){
           nameArea.setText("No Customers Available");
           btn.setVisible(false);
           
       }
       else{//fix this because when they search for a customer then want to add it wont work like this
           //must have a static variable i to keep track of what element we are at.
       //Customer c = (Customer)StartFrame.business.get(CusPanel.i);
       String temp1 =nameArea.getText();
       nameArea.setText(n+"\n"+c);
       area.setText(c.listPayment());
       
        }
   }
   private class paymentListener implements ActionListener{
       public void actionPerformed(ActionEvent event){
           Object source = event.getSource();
           if(source == btn){
              Customer temp = Business.business.get(CusPanel.i);
              String month,amt;
              month = monthF.getText();
              amt = paymentF.getText();
              
              if(month.isEmpty() || amt.isEmpty())
              {
                  JOptionPane.showMessageDialog(null, "Error: Empty fields");
              }
              else
              {
                
                   temp.payBill(monthF.getText(),paymentF.getText());
                   payF.dispose();  
                 
              }
           }
              else 
              {
              payF.dispose();
               }
             }
           }
           
       }
   
    

