/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.NumberFormat;
/**
 *
 * @author miguelhuerta
 */
public class showCustomer {
    private JFrame frame;
    private JPanel textAreaP,scrollP,tableP;
    private Button ok_b,cancel_b;
    
    public showCustomer(Customer c){
        frame = new JFrame("Customer File");
        frame.setBackground(new Color(138,138,131));
        frame.setPreferredSize(new Dimension(900,430));
        
        
        //set up the text are panel
        textAreaP = new JPanel();
        textAreaP.setSize(new Dimension(100,100));
        textAreaP.setLayout(null); // allows you to set up the components how you want
        
        JTextArea t_area = new JTextArea(20,20);
        t_area.setEditable(false);
        JLabel nameL = new JLabel("Customer File for: ");
        nameL.setFont(new Font("Times New Roman",Font.BOLD,18));
        t_area.setFont(new Font("Times New Roman",Font.BOLD,13));
        t_area.setText(c.toString());
        
        
        //set up scroll and add to the textAreaP
        JLabel scrollL = new JLabel("Payment History" );
        scrollL.setFont(new Font("Times New Roman",Font.BOLD,18));
        JTextArea scrollArea = new JTextArea(20,20);
        scrollArea.setEditable(false);
        //scrollArea.setFont(new Font("Times New Roman",Font.BOLD,13));
        scrollArea.setFont(new Font("Monospaced",Font.PLAIN,13));
        JScrollPane pane = new JScrollPane(scrollArea);
        scrollArea.setText(c.listPayment());
        
        //set up the button
        ok_b = new Button("Done");
        cancel_b = new Button("Cancel");
        //set up the button listener
        buttonListener listen = new buttonListener();
        ok_b.addActionListener(listen);
        cancel_b.addActionListener(listen);
        //set up the labels that show last payment made
        JLabel payL = new JLabel("Last Payment for: ");
        payL.setFont(new Font("Times New Roman",Font.BOLD,16));
        JLabel amtL = new JLabel("Amount of:");
        amtL.setFont(new Font("Times New Roman",Font.BOLD,16));
        double aTm = Double.parseDouble(c.getLstAmount());
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        JLabel amtF = new JLabel(fmt.format(aTm));
        JLabel payF = new JLabel(c.getLstMonth());
        
        
        textAreaP.add(nameL);
        textAreaP.add(t_area);
        nameL.setLocation(15,10);
        nameL.setSize(200,100);
        t_area.setLocation(15,80); //must add these lines if your layout is null
        t_area.setSize(350,150);  //must add this
        textAreaP.add(scrollL);
        textAreaP.add(pane);
        scrollL.setLocation(15, 200);
        scrollL.setSize(200,100);
        pane.setLocation(15,270);
        pane.setSize(350,100 );
        textAreaP.add(ok_b);
        textAreaP.add(cancel_b);
        ok_b.setLocation(500,350);
        ok_b.setSize(60,30);
        cancel_b.setLocation(600,350);
        cancel_b.setSize(70,30);
        textAreaP.add(payL);
        textAreaP.add(amtL);
        textAreaP.add(amtF);
        textAreaP.add(payF);
        payL.setLocation(500, 50);
        payL.setSize(200,100);
        amtL.setLocation(500, 90);
        amtL.setSize(200,100);
        amtF.setLocation(600, 90);
        amtF.setSize(400, 100);
        payF.setLocation(630,50);
        payF.setSize(400, 100);
        
        frame.getContentPane().add(textAreaP);
 
        frame.pack();
        frame.setVisible(true);
        
        
    }
    private class buttonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            frame.dispose();
        }
}
    
}
