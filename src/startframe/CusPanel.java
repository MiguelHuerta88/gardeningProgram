/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
/**
 *
 * @author miguelhuerta
 */


public class CusPanel extends JPanel{
    JFrame frame = new JFrame("Customer Insert");
    static int i;
    Button btn,btn1;
    JLabel nameL,propL,addL,priceL,cityL,zipL,stateL;
    JTextField nameF,propF,addF,priceF,cityF,zipF,stateF;
    public CusPanel(){
        
        frame.setSize(new Dimension(350,200));
        
        
        
        
        JPanel panel,panelF;
        
        //set up the labels and fields
        JPanel nameP,propP,addP,priceP,btnP,monthP;
        
        nameL = new JLabel("Name: ");
        propL = new JLabel("Property Address: ");
        addL = new JLabel("Billing Address: ");
        priceL = new JLabel("Price: $");
        
        nameF = new JTextField(30); 
        propF = new JTextField(50);
        addF = new JTextField(50);
        priceF = new JTextField(10);
        
        //set up the name panel
        nameP = new JPanel();
        nameP.setLayout(new BoxLayout(nameP,BoxLayout.X_AXIS));
        nameP.add(nameL);
        nameP.add(nameF);
        
        //property panel
        propP = new JPanel();
        propP.setLayout(new BoxLayout(propP,BoxLayout.X_AXIS));
        propP.add(propL);
        propP.add(propF);
        
        //address panel
        addP = new JPanel();
        addP.setLayout(new BoxLayout(addP,BoxLayout.X_AXIS));
        addP.add(addL);
        addP.add(addF);
        
        //set up month panel
        monthP = new JPanel();
        monthP.setLayout(new BoxLayout(monthP,BoxLayout.X_AXIS));
        cityL = new JLabel("City: ");
        stateL = new JLabel("State: ");
        zipL = new JLabel("Zip: ");
        cityF = new JTextField(10);
        stateF = new JTextField(3);
        zipF = new JTextField(15);
        
        monthP.add(cityL);
        monthP.add(cityF);
        monthP.add(stateL);
        monthP.add(stateF);
        monthP.add(zipL);
        monthP.add(zipF);
        
        
        //price panel
        priceP = new JPanel();
        priceP.setLayout(new BoxLayout(priceP,BoxLayout.X_AXIS));
        priceP.add(priceL);
        priceP.add(priceF);
        //nameL.setLabelFor(nameF);
        CusListener listener = new CusListener();
        //set up the button panel
        btnP = new JPanel(); 
        //Button btn,btn1;                //add the actionlistener
        btn = new Button("Submit");
        btn1 = new Button("Cancel");
        btnP.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnP.add(btn);
        btnP.add(btn1);
        btn.addActionListener(listener);
        btn1.addActionListener(listener);
        
        
        //add the labels and fields to the panel
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        
        panel.add(nameP);
        panel.add(propP);
        panel.add(addP);
        panel.add(monthP);
        panel.add(priceP);
        panel.add(btnP);
       
        
        panelF = new JPanel();
        panelF.add(panel);
       
        
        frame.add(panelF,BorderLayout.NORTH);
        frame.pack();
        
        
        frame.setVisible(true);
        
    }
    
    private class CusListener implements ActionListener{
         //--------------------------------------------------------------
      //  Calls the method to process the option for which radio
      //  button was pressed.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event){
          
          Object source = event.getSource();
          boolean notExist = true;
          ownerFrame oF;
         if (source == btn)
         {
             //frame.dispose();
             String name,prop,add,price,city,state,zip;
             double amt;
             
             name = nameF.getText();
             prop = propF.getText();
             add = addF.getText();
             price = priceF.getText();
             city = cityF.getText();
             state = stateF.getText();
             zip = zipF.getText();
             
             Customer customer = new Customer(prop,name,add,city,state,zip,price);
             if(prop.isEmpty() || add.isEmpty() || price.isEmpty()
                     || city.isEmpty() || state.isEmpty() || zip.isEmpty())
             {
                 JOptionPane.showMessageDialog(null, "Some Fields were left blank");
                 notExist = false;
                 
                 //CusPanel cus = new CusPanel();
                 
             }
             
             else if(!price.isEmpty())
             {
                try
                {
                amt = Double.parseDouble(price);
                }
                catch(NumberFormatException e)
                {
                 JOptionPane.showMessageDialog(null, "Error the price inserted is not a number value");
                 notExist = false;
                 
                 //CusPanel cus = new CusPanel();
                }
             } 
             if(!Business.business.isEmpty()){
             i = Business.business.size();//added this
             System.out.println("size of i:"+i);
             }
             
             for(int i = 0;i<Business.business.size();i++){
                 if(customer.getPropA().toLowerCase().equals(Business.business.get(i).getPropA().toLowerCase())){
                     JOptionPane.showMessageDialog(null, "Customer Already exist");
                     notExist = false;
                 }
             }
             if(notExist)
             {
             Business.business.add(customer);
             frame.dispose();
             System.out.println("The sze is"+ Business.business.size());
             JOptionPane.showMessageDialog(null,"Customer Added");
            //use this technique to post infor on JTextArea
           
            windowFrame.area.setText("Customer being looked at\n"+"\n"+customer);
            
            //add the property to the suggestion field
            Business.list.add(customer.getPropA());
            
            //we check to see if the isSet boolean value is set for the Business class
            if(Business.isSet == false)
                //we open a new frame that has the values needed to insert
                oF = new ownerFrame();
             }
             windowFrame.setSaved(false);
            
         }
         else
         {
            frame.dispose();
         }
      } 
    }
    
}

