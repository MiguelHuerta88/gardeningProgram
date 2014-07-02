/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JOptionPane;
/**
 *
 * @author miguelhuerta
 */
public class save {
    String filename;
    public save(){
        if(Business.business.isEmpty()){
           JOptionPane.showMessageDialog(null, "No Customers Available");             
          }
        else{
          int status;
          File file2;
          JFileChooser chooser = new JFileChooser();
          
          status = chooser.showSaveDialog (null);
      if (status == JFileChooser.APPROVE_OPTION)
      {
          File file = chooser.getSelectedFile();
          filename = file.getPath();
      }
          
          try
		{
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fos);
                        
                        out.writeBytes(Business.getName()+"\n");
                        //out.writeChars(Business.getName()+"\n");
                        out.writeBytes(Business.getAddress()+"\n");
                        out.writeBytes(Business.getCity()+"\n");
                        out.writeBytes(Business.getState()+"\n");
                        out.writeBytes(Business.getZip()+"\n");
                        
                        out.writeObject(Business.business);
                        out.close();
                        
                      
                      
                        JOptionPane.showMessageDialog(null, "Choose another file add TEXT after name");
                        chooser = new JFileChooser();
                        status = chooser.showSaveDialog (null);
                        if (status == JFileChooser.APPROVE_OPTION)
                        {
                            file2 = chooser.getSelectedFile();
                            filename = file2.getPath();
                        }
                        PrintWriter output2 = new PrintWriter(new FileOutputStream(filename));
                        output2.println(Business.outputinFo());
                        for(int i = 0; i< Business.business.size();i++)
                        {
                        output2.println(Business.business.get(i)+"\n");
                        }
                        output2.close();
                        JOptionPane.showMessageDialog(null, "Program Saved SuccessFully");
                        

		}
	catch(IOException e)
                {
                     System.out.println(e);
                }

   }
    }

        
    }
    


