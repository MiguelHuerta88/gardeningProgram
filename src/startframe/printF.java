package startframe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguelhuerta
 */
public class printF {
    Button skip,print;
    JFrame frame;
    Customer temp;
    static JTextField dateF,yearF,monthA,xtrF,totalF,jarea2;
    //static JTextArea jarea2;
    
   //make all the buttons and fields private here so they can be accessed by the action listener
    public printF(Customer c){
        temp = c;
        
        JLabel date = new JLabel("Date:");
        JLabel year = new JLabel("Year: 20/ ");
        dateF = new JTextField(5);
        yearF = new JTextField(3);
        
       //date panel
        JPanel dateP = new JPanel();
        dateP.setPreferredSize(new Dimension(50,20));
        dateP.setLayout(new FlowLayout(FlowLayout.RIGHT));
        dateP.add(date);
        dateP.add(dateF);
        dateP.add(year);
        dateP.add(yearF);
        //date.setVerticalAlignment(SwingConstants.TOP);
        //date.setHorizontalAlignment(SwingConstants.RIGHT);
        
        //namePanel
        JPanel nameP = new JPanel();
        nameP.setPreferredSize(new Dimension(50,20));
        nameP.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel nameL = new JLabel("INVOICE: ");
        nameL.setHorizontalAlignment(SwingConstants.LEFT);
       
        
        JTextArea jarea = new JTextArea(2,10);
        jarea.setEditable(false);
        jarea.setText(c.getName()+"\n"+c.getPropA());
        jarea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        nameP.add(nameL);
        nameP.add(jarea);
        
        //service for month panel 
        JLabel month = new JLabel("Service for ");
        monthA = new JTextField(10);
        JPanel monthP = new JPanel(new FlowLayout(FlowLayout.CENTER));
        monthP.add(month);
        monthP.add(monthA);
        //extra charge panel
        JPanel xtra = new JPanel();
        xtra.setPreferredSize(new Dimension(600,60));
        //xtra.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel xtrL = new JLabel("Extra Charges: ");
        JLabel charL = new JLabel("$ ");
        charL.setHorizontalAlignment(SwingConstants.RIGHT);
        xtrF = new JTextField(7);
        xtrF.setHorizontalAlignment(JTextField.RIGHT);
        jarea2 = new JTextField(13);
        
        
        jarea2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        xtra.add(xtrL);
        xtra.add(jarea2);
        JPanel xtP = new JPanel();
        xtP.setLayout(new FlowLayout(FlowLayout.RIGHT));
        xtP.add(charL);
        xtP.add(xtrF);
        xtra.setLayout(new FlowLayout(FlowLayout.RIGHT));
        xtra.add(xtP);
        
        //total panel
        JPanel totalP = new JPanel();
        totalP.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel total = new JLabel("Total: $ ");
        totalF = new JTextField(7);
        totalF.setText(c.getPrice());
        totalP.add(total);
        totalP.add(totalF);
        
        //gardener panel
        JPanel gard = new JPanel();
        gard.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel gardener = new JLabel("Gardener  ");
        gardener.setSize(20, 20);
        JTextArea jarea3 = new JTextArea(2,10);
        jarea3.setEditable(false);
        jarea3.setBorder(BorderFactory.createLineBorder(Color.black));
        //jarea3.setText("Salvador Huerta\n 139 E 235th st\n Carson,CA,90745");
        jarea3.setText(Business.getName()+"\n"+Business.getAddress()+"\n"+Business.getCSZ());
        gard.add(gardener);
        gard.add(jarea3);
        
        //buttons
        print = new Button("Print");
        //skip = new Button ("Skip");
        Listener listen = new Listener();
        print.addActionListener(listen);
        //skip.addActionListener(listen);
        //Button cancel = new Button("Cancel");
        JPanel buttonP = new JPanel();
        buttonP.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonP.add(print);
        //buttonP.add(cancel);
        //buttonP.add(skip);
        
       
        
        JPanel addP = new JPanel();
       

        addP.setLayout(new BoxLayout(addP,BoxLayout.Y_AXIS));
        addP.add(dateP);
        addP.add(nameP);
        addP.add(monthP);
        addP.add(xtra);
        addP.add(totalP);
        addP.add(gard);
        addP.add(buttonP);
        
        frame = new JFrame();
        frame.setBackground(Color.PINK);
        frame.setPreferredSize(new Dimension(400,725));
        
        frame.add(addP);
        frame.pack();
        frame.setLocation(1000, 10);
        frame.setVisible(true);
        
        
    }
   private class Listener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Object source = event.getSource();
            //printBills.setbills = false;
            if(source == print){
              String date,year,month,area,xtr,total;
              date = dateF.getText();
              year = yearF.getText();
              month = monthA.getText();
              area = jarea2.getText();
              xtr = xtrF.getText();
              total = totalF.getText();
              printBill print = new printBill(temp,date,year,month,area,xtr,total); 
              print.printbill();
              frame.dispose(); 
              windowFrame.setSaved(false);
            }
            else{
             frame.dispose();   
            }
        }
    }
  
}
