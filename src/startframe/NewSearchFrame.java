/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author miguelhuerta
 */
public class NewSearchFrame implements ListSelectionListener {

    private JList list;
    private DefaultListModel listModel;
    private JButton search;
    private JTextField searchField;
    ArrayList<Customer> array = new ArrayList();
    JFrame frame;
    JPanel panel;
    JScrollPane scroll;
   public NewSearchFrame()
   {
      
       for(int i=0; i< Business.business.size(); i++)
       {
           Customer temp = (Customer)Business.business.get(i);
           array.add(temp);
       }
       
       frame = new JFrame("New Seach Frame");
       frame.setBackground(new Color(138,138,131));
       frame.setPreferredSize(new Dimension(600,500));
       
       panel = new JPanel();
       panel.setLayout(null);
       panel.setSize(400,400);
       
       
      //set up the JtextField and Button
       searchField = new JTextField(15);
       search = new JButton ("Search");
       Listener buttonListen = new Listener();
       search.addActionListener(buttonListen);
       
       listModel = new DefaultListModel();
       listModel.addElement("Empty");  
       list = new JList(listModel);
       list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       list.addListSelectionListener(this);
       list.setVisibleRowCount(5);
       scroll = new JScrollPane(list);
       panel.add(scroll);
       scroll.setLocation(10,20);
       scroll.setSize(500, 300);
       
       //add button and field to the panel
       panel.add(searchField);
       searchField.setLocation(10, 350);
       searchField.setSize(150,30);
       panel.add(search);
       search.setLocation(190,350);
       search.setSize(65, 30);
       
      
       frame.getContentPane().add(panel);
       frame.pack();
       frame.setVisible(true);
   }
   public void valueChanged(ListSelectionEvent e){
      if (e.getValueIsAdjusting() == false) {

            if (list.getSelectedIndex() != -1) {
                int index = list.getSelectedIndex();
                //System.out.println(listModel.getElementAt(index));
                String temp = (String)listModel.getElementAt(index);
                String []result = temp.split("\\:");
                for(int i=0;i<Business.business.size();i++){
                Customer cus = (Customer)Business.business.get(i);
                if(result[1].equals(cus.getPropA()))
                {
                    CusPanel.i = i;
                    windowFrame.area.setText("Customer being looked at\n\n"+cus);
                    showCustomer show = new showCustomer(cus);
                    break;
                }
                
            }
   
            }
            frame.dispose();
      }
   }
   private class Listener implements ActionListener{
       public void actionPerformed(ActionEvent e){
           String textStr = searchField.getText();
           //System.out.println("The search is searching for:"+ textStr);
           Pattern pattern = Pattern.compile(textStr, Pattern.CASE_INSENSITIVE);
           Matcher match;
           //listModel = new DefaultListModel();
           listModel.remove(0);
           for(int i=0;i<array.size();i++)
           {
               match = pattern.matcher(array.get(i).getName());
               if(match.find())
               {
                   String temp = array.get(i).getName()+ ":"+array.get(i).getPropA();
                   listModel.addElement(temp);
                   
               }
           }
           if(listModel.isEmpty())
               listModel.addElement("Search Failed");
           
       }
   }
}
