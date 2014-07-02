/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;



/**
 *
 * @author miguelhuerta
 */

public class StartFrame {
    static boolean hasSaved = false;
    public static void main(String[] args){
        // TODO code application logic here
        //set up main frame
        //StartFrame f = new StartFrame();
        windowFrame window = new windowFrame("Wlecome to the Gradening Program");
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }
    

}