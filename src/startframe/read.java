/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
/**
 *
 * @author miguelhuerta
 */
public class read {
    String filename;
    public read(){
      int confirm,status;
      JFileChooser chooser = new JFileChooser();  
      status = chooser.showOpenDialog (null);
      File file = chooser.getSelectedFile();
      filename = file.getPath();
      Customer temp;
      try
		{
			FileInputStream fis = new
			    FileInputStream(filename);
			ObjectInputStream in = new
				       ObjectInputStream(fis);
                        Business.name = in.readLine();
                        Business.address = in.readLine();
                        Business.city = in.readLine();
                        Business.state = in.readLine();
                        Business.zip = in.readLine();
                        
                        if(!Business.name.isEmpty())
                            Business.isSet = true;
                        else
                            Business.isSet = false;
                        
                        ArrayList<Customer> businessRead = new ArrayList<Customer>();
                        businessRead  = (ArrayList<Customer>)in.readObject();
                        in.close();
                        Business.business = businessRead;
                        CusPanel.i = Business.business.size()-1;
                        temp =(Customer)Business.business.get(CusPanel.i);
                        windowFrame.area.setText("Customer being looked at\n"+"\n"+temp);
                        JOptionPane.showMessageDialog(null, "File Successfully uploaded");
                        for(int i = 0; i < Business.business.size(); i++)
                            Business.list.add(Business.business.get(i).getPropA());
		}
                	catch(ClassNotFoundException e)
                 {
                     System.out.println(e);
                 }
                catch (IOException e)
                 {
                     System.out.println(e);
                 }
    }
    
}
