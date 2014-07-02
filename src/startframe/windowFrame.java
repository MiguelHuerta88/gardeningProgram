/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
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
public class windowFrame extends JFrame implements WindowListener{
    static JTextArea area;// has to be static so the other classes can use area to
    static boolean hasSaved = true;
    Button search;
   // static ArrayList<String> list = new ArrayList<String>();
    JTextField myField;
    static Business business = new Business();
    public windowFrame(String title)
    {
        super(title);
        setPreferredSize(new Dimension(800,770));
        setBackground(new Color(139,139,131));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        
        JMenuBar bar = new JMenuBar();
        MenuListener ml = new MenuListener();
        JMenu fileMenu = new JMenu("File");
        JMenuItem read = new JMenuItem("Open");
        read.addActionListener(ml);
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(ml);
       
        fileMenu.add(read);
        fileMenu.add(save);
        
        
        JMenu editMenu = new JMenu("Edit");
        JMenuItem change = new JMenuItem("Change Owner Info");
        change.addActionListener(ml);
        editMenu.add(change);
        
        JMenu ownerMenu = new JMenu("Owner");
        JMenuItem labels = new JMenuItem("Print Owner Label");
        labels.addActionListener(ml);
        ownerMenu.add(labels);
        
        bar.add(fileMenu);
        bar.add(editMenu);
        bar.add(ownerMenu);
        this.setJMenuBar(bar);
        
        
        //setup search bar
        boolean strictMatching = false;  
        
        myField = new JTextField(20);
        
        JLabel searchL = new JLabel("(Search by property address)");
        search = new Button("Search");
      
        listener listen = new listener();
        search.addActionListener(listen);
        AutoCompleteDecorator.decorate(myField,Business.list,strictMatching);
        
        JPanel searchP = new JPanel();
        searchP.setLayout(new FlowLayout(FlowLayout.RIGHT));
        searchP.add(myField);
        //searchP.add(searchL);
        searchP.add(search);
        
        
        //set up icon panel and add search panel
        URL url = getClass().getResource("/images/lawn.jpg");
        ImageIcon icon = new ImageIcon(url);
        JLabel label = new JLabel("Gardening Service",icon,SwingConstants.LEFT);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(820,350));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        //panel.setBackground(Color.CYAN);
        panel.add(label);
        panel.add(searchP);
        
        //set up the tabPane for the interface
        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(400,400));
        
        
        
      
       //set up the tab pane and text area  
        JTabbedPane tp = new JTabbedPane();
        
        tp.addTab("Customer",new cusP());
        tp.addTab("Business", new busP());
        
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setPreferredSize(new Dimension(500,200));
        
        JPanel ex = new JPanel();
        ex.setPreferredSize(new Dimension(400,400));
        ex.setLayout(new FlowLayout(FlowLayout.CENTER));
       // JTextArea area = new JTextArea(5,30);
        area = new JTextArea(15,30);
        area.setEditable(false);
        area.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        area.setEditable(false);
        area.setLineWrap(true);
        area.setRows(12);
        area.setText("Customer being looked at is: ");
        ex.add(area);
        panel.add(ex);
        panel2.add(tp);
        
        getContentPane().add(panel,BorderLayout.LINE_START);
        //frame.getContentPane().add(ex,BorderLayout.AFTER_LINE_ENDS);
        getContentPane().add(panel2,BorderLayout.SOUTH);
        
        addWindowListener(this);
    }
    public static boolean getSaved()
    {
        return hasSaved;
    }
    public static void setSaved(boolean save)
    {
       hasSaved =  save;
    }
    public void windowClosing(WindowEvent e) {
            //This will only be seen on standard output.
       int again;
       save file;
       if(hasSaved == false)
       {
         again = JOptionPane.showConfirmDialog(null,"Would you like to save:","Alert!",JOptionPane.YES_NO_OPTION);
         if(again == JOptionPane.YES_OPTION)
           file = new save();
       }
       System.out.println("WindowListener method called: windowClosed.");
       this.setVisible(false);
       System.exit(0);
    }

    public void windowClosed(WindowEvent e) {    }

    public void windowOpened(WindowEvent e) {    }

    public void windowIconified(WindowEvent e) {    }

    public void windowDeiconified(WindowEvent e) {    }

    public void windowActivated(WindowEvent e) {    }

    public void windowDeactivated(WindowEvent e) {    }


    private class MenuListener implements ActionListener
    {
      public void actionPerformed (ActionEvent event)
      {
         String source = event.getActionCommand();

         if (source.equals("Open"))
         {
            read readIn = new read();
            setSaved(true);
         }
         else if(source.equals("Save"))
         {
             save saveFile = new save();
             setSaved(true);
         }
         else if(source.equals("Change Owner Info"))
         {
             ownerFrame owner = new ownerFrame();
             setSaved(false);
         }
         else
         {
             Customer c = new Customer("",Business.name,Business.address,Business.city,Business.state,Business.zip,"");
             printLabels printL = new printLabels(c);
             printL.printLabel();
         }
         
      }
    }
    private class listener implements ActionListener{
         //--------------------------------------------------------------
      //  Calls the method to process the option for which radio
      //  button was pressed.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event){
          boolean notFound = true;
          Object source = event.getSource();
          if(source == search){
            //get the input from the field to search with  
            String searchKey = myField.getText();  
            //have to search business of customers for the given property addess
            //set the global i to the customer that is found.
            for(int i=0;i<Business.business.size();i++){
                Customer temp = (Customer)Business.business.get(i);
                if(searchKey.equals(temp.getPropA()))
                {
                    CusPanel.i = i;
                    JOptionPane.showMessageDialog(null, "Customer found");
                    windowFrame.area.setText("Customer being looked at\n\n"+temp);
                    notFound = false;
                    break;
                }
                
            }
            if(notFound){
            JOptionPane.showMessageDialog(null, "No such customer by that address");
            }
          }
        
    }
}
}
