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
public class busP extends JPanel {
    private Button btn,btn2,btn3,btn4,btn5,btn6,btn7;
    
    public busP(){
        btn = new Button("List Business");
        btn2 = new Button("Print Bills\n(all at once)");
        btn3 = new Button("Pay Bills\n(all at once)");
        btn4 = new Button("Save");
        btn5 = new Button("Open");
        btn6 = new Button("Search by Name");
        btn7 = new Button ("Print Labels(all List)");
        setUp();
        
    }
    private void setUp(){
        setLayout(new GridLayout(0,3));
        add(btn);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn7);
        Listener listen = new Listener();
        btn.addActionListener(listen);
        btn2.addActionListener(listen);
        btn3.addActionListener(listen);
        btn4.addActionListener(listen);
        btn5.addActionListener(listen);
        btn6.addActionListener(listen);
        btn7.addActionListener(listen);
    }
    private class Listener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Object source =  event.getSource();
            if(source == btn){
                listBusiness list = new listBusiness();
            }
            else if(source == btn2){
                if(Business.isSet == false)
                {
                    JOptionPane.showMessageDialog(null, "Must setup owner before continuing");
                }
                else
                {
                    printBills bills = new printBills();
                }
            }
            else if(source == btn3){
                payBills pay = new payBills();
            }
            else if(source == btn4){
                save s = new save();
                windowFrame.setSaved(false);
                
            }
            else if(source == btn5) {
                read r = new read();
                windowFrame.setSaved(false);
            }
            else if(source == btn6)
            {
                NewSearchFrame sr = new NewSearchFrame();
            }
            else
            {
                printAllLabels pAL = new printAllLabels();
            }
           
        }
    }
}
