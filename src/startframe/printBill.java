/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;
import java.awt.*;

import javax.swing.*;
import java.awt.print.*;
import java.awt.font.*;
import java.text.*;
import java.text.NumberFormat;
import java.net.URL;

import javax.print.attribute.*;
import javax.swing.UIManager;

/**
 *
 * @author miguelhuerta
 */

public class printBill implements Printable{
    Customer temp;
    JTextArea XtrArea;
    JTextField date,year,monthSer,total,xtrC;
    String d,ye,a,m,xt,t;
    URL url = getClass().getResource("/images/lawnBack.jpg");
    final Image img = new ImageIcon(url).getImage();
    public printBill(Customer c,String date,String year,String month,String area,String xtr,String total){
       temp = c;  
       d = date;
       ye = year;
       m = month;
       a = area;
       xt = xtr;
       t = total;
    }
    public void printbill(){   
    //PrinterJob job = PrinterJob.getPrinterJob();
   
        PrinterJob job = PrinterJob.getPrinterJob();
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        PageFormat pf = job.pageDialog(aset);
        job.setPrintable(this, pf);
        boolean ok = job.printDialog(aset);
    
    
    //job.setPrintable(this);
       //boolean ok = job.printDialog();
       if(ok){
           try{
               job.print(aset);
               //job.print();
           }
           catch(PrinterException ex){
               
           }
       }
    }
   public int print(Graphics g,PageFormat pf,int pageIndex){
       if(pageIndex > 0){
           return NO_SUCH_PAGE;
       }
       
        Font font = new Font("Serif",Font.PLAIN,12);
        FontMetrics metric = g.getFontMetrics(font);
        int lineHeight = metric.getHeight();
        
        
        //System.err.println("The height of paper is"+ pageHeight);
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(),pf.getImageableY());
        
        int y =0;
        int x=0;
        x+=20;
        
        AttributedString attribute = new AttributedString("INVOICE ");
        attribute.addAttribute(TextAttribute.FOREGROUND, Color.BLUE);
        g.drawString(attribute.getIterator(), 0, y+lineHeight);
        
        //font = new Font("Times New Roman",Font.PLAIN,12);
        attribute = new AttributedString("Date: ");
        attribute.addAttribute(TextAttribute.FOREGROUND, Color.BLUE);
        g.drawString(attribute.getIterator(), 160, y+lineHeight);
        g.drawString(d, 195, y+lineHeight);
        attribute = new AttributedString("20/");
        attribute.addAttribute(TextAttribute.FOREGROUND, Color.BLUE);
        g.drawString(attribute.getIterator(), 240,y+lineHeight);
        g.drawString(ye,265 ,y+lineHeight);
        y=lineHeight*3;
        
        g.drawImage(img,10,y+lineHeight,img.getWidth(null)/2,img.getHeight(null)/2,null);
        
        g.drawString("Address", 20, y+10);
        g.drawString(temp.getName(), 70, y);
        lineHeight+=lineHeight;
        g.drawString(temp.getPropA(),70, y+lineHeight);
        y +=(3*lineHeight);
        g.drawString("Service for:", 70,y);
        g.drawString(m, 70, y+lineHeight);
        y+=(2.5*lineHeight);
        
        int part = a.length()/23;
        int offset =0;
        int temp = y;
        int dist = 23;
        while(part >0)
        {
            g.drawString(a.substring(offset,dist ), 70, temp);
            temp+=lineHeight;
            offset+=23;
            dist+=23;
            part--;
        }
        //g.drawString(a, 70, y);
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        double tAmt;
        if(xt.isEmpty())
        {
            
            g.drawString(xt, 215, y);
            
        }
            
        else
        {
           tAmt = Double.parseDouble(xt);
           g.drawString(fmt.format(tAmt), 215, y);
        }
        y+=(5*lineHeight);
        g.drawString("Total: ", 180, y);
        
       
        
        tAmt = Double.parseDouble(t);
        //System.out.println("We are at"+ y);
        g.drawString(fmt.format(tAmt),215,y);
        //g.drawString("$"+t+".00",215,y);
        y+=(3*lineHeight);
        g.drawString(Business.getName(), 70, y);
        y+=15;
        g.drawString(Business.getAddress(),70,y);
        y+=15;
        g.drawString(Business.getCSZ(), 70, y);
        
        //printBills.setbills = true;
       
        return PAGE_EXISTS;

   } 
   
}

