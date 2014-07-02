/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.NumberFormat;
/**
 *
 * @author miguelhuerta
 */
public class listBusiness {
    JFrame frame;
    JTextArea area;
    Button ok;
    public listBusiness(){
        frame = new JFrame("Listing Business");
        frame.setPreferredSize(new Dimension(700,750));
        frame.setBackground(new Color(138,138,131));
        
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(400,400);
        area = new JTextArea(20,20);
        area.setEditable(false);
        JScrollPane pane = new JScrollPane(area);
        JLabel label = new JLabel("Listing Business");
        label.setFont(new Font("Times New Roman",Font.BOLD,20));
        
        panel.add(label);
        panel.add(pane);
        label.setLocation(10,10);
        label.setSize(200, 100);//200,100
        pane.setLocation(10, 80);
        pane.setSize(500, 600);
        
        //ok,cancel;
        ok = new Button("Ok");
        Listener listen = new Listener();
        ok.addActionListener(listen);
        //cancel = new Button("Cancel");
        panel.add(ok);
        ok.setLocation(560,600);
        ok.setSize(45,30);
        
        frame.getContentPane().add(panel);
        initPane();
        
        frame.pack();
        frame.setVisible(true);
        
    }
    public void initPane(){
        if(Business.business.isEmpty()){
            area.setText("No Customers in List");
            area.setFont(new Font("Times New Roman",Font.BOLD,20));
        }
        else{
            String lines;
            double tAmt;
            NumberFormat fmt = NumberFormat.getCurrencyInstance();
            for(int i = 0;i < Business.business.size();i++){
               area.append("Name: "+Business.business.get(i).getName());
               area.setFont(new Font("Times New Roman",Font.ITALIC,13));
               area.append("\n\tProperty Address: "+Business.business.get(i).getPropA());
               area.append("\n\tAdress: "+Business.business.get(i).getAddress());
               //format price
               tAmt= Double.parseDouble(Business.business.get(i).getPrice());
               area.append("\n\tPrice:"+fmt.format(tAmt));
               area.append("\n\tLast Payment: "+Business.business.get(i).getLstMonth());
               
               tAmt = Double.parseDouble(Business.business.get(i).getLstAmount());
               
               area.append("\n\tAmount of: "+fmt.format(tAmt) +"\n\n");
               //area.append("\n\tAmount of: "+StartFrame.business.get(i).getLstAmount()+"\n\n");
               
            }
          
        
        }
    }
    private class Listener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Object source = event.getSource();
            frame.dispose();
            
        }
    }
    
}
