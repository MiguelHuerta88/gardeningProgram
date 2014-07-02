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
public class CusUpdate extends JPanel{
    JFrame frame = new JFrame("Customer Update");
    Button btn,btn1;
    JLabel nameL,propL,addL,priceL,cityL,zipL,stateL;
    JTextField nameF,propF,addF,priceF,cityF,zipF,stateF;
    static Customer temp;
    public CusUpdate(Customer c) {
        
        frame.setSize(new Dimension(350,200));
        temp = c;
        
        
        
        JPanel panel,panelF;
        
        //set up the labels and fields
        JPanel nameP,propP,addP,priceP,btnP,monthP;
        
        nameL = new JLabel("Name: ");
        propL = new JLabel("Property Address: ");
        addL = new JLabel("Billing Address: ");
        priceL = new JLabel("Price: $");
        
        nameF = new JTextField(c.getName(),30);
        propF = new JTextField(c.getPropA(),50);
        addF = new JTextField(c.getAddress(),50);
        priceF = new JTextField(c.getPrice(),10);
        
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
        cityF = new JTextField(c.getCity(),10);
        stateF = new JTextField(c.getState(),3);
        zipF = new JTextField(c.getZip(),15);
        
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
//        CusListener listener = new CusListener();
        //set up the button panel
        btnP = new JPanel(); 
        //Button btn,btn1;                //add the actionlistener
        btn = new Button("Submit");
        btn1 = new Button("Cancel");
        
        buttonListener listen = new buttonListener();
        btn.addActionListener(listen);
        btn1.addActionListener(listen);
        btnP.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnP.add(btn);
        btnP.add(btn1);
  //      btn.addActionListener(listener);
  //      btn1.addActionListener(listener);
        
        
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
   private class buttonListener implements ActionListener{
           
       public void actionPerformed(ActionEvent event){
           Object source = event.getSource();
           if(source == btn)
           {
              
              if(!priceF.getText().isEmpty())
             {
                try
                {
                Double amt = Double.parseDouble(priceF.getText());
                }
                catch(NumberFormatException e)
                {
                 JOptionPane.showMessageDialog(null, "Error the price inserted is not a number value");
                 
                }
             }
              if(nameF.getText().isEmpty() || addF.getText().isEmpty() ||
                      propF.getText().isEmpty() || cityF.getText().isEmpty()||
                      priceF.getText().isEmpty() || stateF.getText().isEmpty()||
                      zipF.getText().isEmpty())
             {
                 JOptionPane.showMessageDialog(null, "Some Fields were left blank");
                 
             }
             else
             {
              temp.changeName(nameF.getText());
              temp.changeAddr(addF.getText());
              temp.changePropA(propF.getText());
              temp.changeCity(cityF.getText());
              temp.changePrice(priceF.getText());
              temp.changeState(stateF.getText());
              temp.changeZip(zipF.getText());
              frame.dispose();
              Business.list.add(temp.getPropA());
              windowFrame.area.setText("Customer being looked at\n"+"\n"+temp);
              windowFrame.setSaved(false);
             }
           }
           else{
               frame.dispose();
           }
       }
   }

    
}
