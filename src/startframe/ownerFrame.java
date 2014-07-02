/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author miguelhuerta
 */
public class ownerFrame {
  JFrame frame = new JFrame("Owner Setup");
  Button btn,btn1;
  JLabel nameL,addL,cityL,zipL,stateL;
  JTextField nameF,addF,cityF,zipF,stateF;
  
  public ownerFrame(){
      frame.setSize(new Dimension(350,200));
        
        
        
        
        JPanel panel,panelF;
        
        //set up the labels and fields
        JPanel nameP,propP,addP,priceP,btnP,monthP;
        
        nameL = new JLabel("Name: ");
        addL = new JLabel("Billing Address: ");
        nameF = new JTextField(30); 
        addF = new JTextField(50);
      
        
        //set up the name panel
        nameP = new JPanel();
        nameP.setLayout(new BoxLayout(nameP,BoxLayout.X_AXIS));
        nameP.add(nameL);
        nameP.add(nameF);
        
        //property panel
        propP = new JPanel();
        propP.setLayout(new BoxLayout(propP,BoxLayout.X_AXIS));
       
        
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
         if (source == btn)
         {
             frame.dispose();
             String name,add,city,state,zip;
             
             
             name = nameF.getText();
             add = addF.getText();
             city = cityF.getText();
             state = stateF.getText();
             zip = zipF.getText();
             
             if(name.isEmpty() || add.isEmpty()|| city.isEmpty() 
                     || state.isEmpty() || zip.isEmpty())
             {
                 JOptionPane.showMessageDialog(null, "Some Fields were left blank");
                     
             }
             Business.setOwner(name, add, city, state, zip);
             Business.isSet = true;
         }
         else
             frame.dispose();
                 
      }
     }
}
     
