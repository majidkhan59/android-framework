package android.framework.forms;

import android.framework.utilities.FileUtilities;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import android.framework.utilities.Constants;
import javax.swing.*;

import javax.swing.border.BevelBorder;
import android.framework.utilities.Database;

/**
 * 
 * @author majidkhan
 */
public class GUI extends javax.swing.JFrame {

    JMenuBar menuBar = new JMenuBar();
    FileUtilities user = new FileUtilities();
   
    
    public GUI() {
        initComponents();
        Database.setMenuItems();
        this.generateMenuItems();
        menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));
        this.setTitle("Android Framework");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane()
        ;
        lblMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Diagnostic Centre Management System");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                WindowClosing(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        desktopPane.setBackground(new java.awt.Color(Constants.RED , Constants.GREEN , Constants.BLACK));
        desktopPane.setAutoscrolls(true);
        desktopPane.setName("frmMDIJDesktop"); // NOI18N
        desktopPane.setLayout(null);

        lblMessage.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(0, 0, 51));
        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        desktopPane.add(lblMessage);
        lblMessage.setBounds(40, 460, 770, 180);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowDeactivated

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowClosing

    private void WindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_WindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_WindowClosing

    public int closeApplication() {
        JOptionPane.showMessageDialog(null, "Going to close Application");
        return 1;
    }

    public static void main(String[] args) {
        
         java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                GUI gui = new GUI();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();            
                gui.setSize(screenSize.width, screenSize.height);
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //frame.setContentPane(new AndroidFramework());
                gui.setVisible(true);
            }
        });
        
    }
    
    
    
    private void generateMenuItems() {
     
        generateMenu();
        this.setJMenuBar(menuBar);
     
    }

    public void generateMenu() {
            //set a general menu with File and Exit
            JMenu menu = new JMenu();
            menu.setText("File");
            menu.setName("File");
            menu.setMnemonic('F');
            JMenuItem item = new JMenuItem();
            
            
            //Adding more menu menuItems 
            HashMap menuItems = Constants.MENU_ITEMS_NAMES; 
            for (int j = 0; j < menuItems.size(); j++) {
                item = new JMenuItem();
                String menuName = (String) menuItems.get(j);
                
                item.setText(menuName);
                item.setName(menuName);          

//                if (menu.getText().equalsIgnoreCase("File") &&
//                        item.getText().equalsIgnoreCase("Exit")) {
//                }
                item.addActionListener(new DetectComp(item.getName(), 
                        Constants.MENU_ITEMS_FORMS.get(j)));
                menu.add(item);
                System.out.println(j + " " +item.getName() + "  "+ Constants.MENU_ITEMS_FORMS.get(j));
                 
            }
            menuBar.add(menu);
            //Add Exit Button
            item = new JMenuItem();
            item.setText("Exit");
            item.setName("Exit");
            item.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                    //DAOFile.closeConnection();
                    System.exit(0);
                }
            });
            menu.add(item);
             
            menuBar.add(menu);
            
            
    }
        class DetectComp implements ActionListener {

        String compName;
        String link;
        

        DetectComp(String temp, String link) {
            compName = temp;
            this.link = link;
        }

        public void actionPerformed(ActionEvent e) {
             
            try {
                //this.link = "Form.General.frmUserPreferences";
                Class c = Class.forName(this.link);
                
                    JInternalFrame jf = (JInternalFrame) c.newInstance();
                    desktopPane.add(jf);
                    jf.moveToFront();
                    Dimension desktopSize = desktopPane.getSize();
                    Dimension fmSize = jf.getSize();
                    jf.setLocation((desktopSize.width - fmSize.width) / 2,
                            (desktopSize.height - fmSize.height) / 2);
                    jf.setVisible(true);
                

            } catch (Exception ex) {
                System.out.println("Error ");
                ex.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel lblMessage;
    // End of variables declaration//GEN-END:variables
}