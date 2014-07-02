/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package startframe;
import javax.swing.JOptionPane;
/**
 *
 * @author miguelhuerta
 */
public class payBills {
    public payBills(){
        if(Business.business.isEmpty()){
           JOptionPane.showMessageDialog(null, "No customers available"); 
        }
        else{
            String month = JOptionPane.showInputDialog("Month Paying: ");
            for(int i=0; i< Business.business.size(); i++){
                Customer c = (Customer)Business.business.get(i);
                windowFrame.area.setText("Customer being looked at\n"+"\n"+c);
                int check;
                String cus = "Next Customer:\n"+ c.getPropA();
                check = JOptionPane.showConfirmDialog(null, cus,"Alert!",JOptionPane.YES_NO_CANCEL_OPTION);
                if(check == JOptionPane.YES_OPTION)
                {
                    c.payBill(month, c.getPrice());
                }
                else if(check == JOptionPane.CANCEL_OPTION)
                    break;
        }
       windowFrame.setSaved(false);
    }
    
}
}
