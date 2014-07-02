/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author miguelhuerta
 */
public class printAllLabels {
    
    
    public printAllLabels()
    {
        int check;
        String info;
        ArrayList<Customer> newList = new ArrayList<Customer>();
        boolean duplicate = false;
        
        for(int i=0; i<Business.business.size(); i++)
        {
            Customer c = (Customer)Business.business.get(i);
            for(int j =0; j<newList.size(); j++)
            {
                if(c.getName().equals(newList.get(j).getName()))
                {
                    duplicate = true;
                    break;
                }
                duplicate = false;
            }
            if(duplicate == false)
                newList.add(c);
            
        }
        
     
        for(int i =0; i< newList.size();i++)
        {
            Customer temp = (Customer)newList.get(i);
            info = "Print Labels for:\n"+"Name:"+temp.getName()+"\nAddress:"+temp.getAddress();
            check = JOptionPane.showConfirmDialog(null, info,"Alert!",JOptionPane.YES_NO_CANCEL_OPTION);
            if(check == JOptionPane.YES_OPTION)
            {
                printLabels label = new printLabels(temp);
                label.printLabel();
            }
            else if(check == JOptionPane.CANCEL_OPTION)
                break;
        }
    }
    
}
