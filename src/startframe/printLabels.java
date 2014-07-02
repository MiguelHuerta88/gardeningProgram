/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
import java.awt.font.*;
import java.text.*;
/**
 *
 * @author miguelhuerta
 */
public class printLabels implements Printable {
    Customer temp;
    
    public printLabels(Customer c)
    {
      temp = c;  
    }
    public void printLabel(){   
    PrinterJob job = PrinterJob.getPrinterJob();
       job.setPrintable(this);
       boolean ok = job.printDialog();
       if(ok){
           try{
               job.print();
           }
           catch(PrinterException ex){
               
           }
       }
    }
    
     public int print(Graphics g,PageFormat pf,int pageIndex){
       if(pageIndex > 0){
           return NO_SUCH_PAGE;
       }
       
       Font font = new Font("Serif",Font.PLAIN,10);
       FontMetrics metric = g.getFontMetrics(font);
       int lineHeight = metric.getHeight();
       g.setFont(font);
       
       String name,address,city,state,zip;
       name = temp.getName();
       address = temp.getAddress();
       city = temp.getCity();
       state = temp.getState();
       zip = temp.getZip();
       String csz = city+","+state+","+zip; 
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(),pf.getImageableY());
        
        int y =35;
        int x=10;
        int gap = 5;
        for(int i=0; i<10;i++)
        {
        g.drawString(name, x, y);
        g.drawString(address, x, y+lineHeight+gap);
        g.drawString(csz, x, y+(gap*2)+(lineHeight*2));
        x = 200;
        g.drawString(name, x, y);
        g.drawString(address, x, y+lineHeight+gap);
        g.drawString(csz, x, y+(gap*2)+(lineHeight*2));
        x = 400;
        g.drawString(name, x, y);
        g.drawString(address, x, y+lineHeight+gap);
        g.drawString(csz, x, y+(gap*2)+(lineHeight*2));
        
        //System.out.println(y);
        y+=72;
        x = 10;
        }
        //y = 110;
        //g.drawString(name, x, y);
        
        
        return PAGE_EXISTS;

   } 
}
