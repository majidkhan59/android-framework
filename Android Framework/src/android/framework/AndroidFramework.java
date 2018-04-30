/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import org.netbeans.api.visual.widget.Widget;

/**
 * This is the main class of the application.
 * 
 * @author shoaib ahmed
 */
public class AndroidFramework extends JPanel {

    public AndroidFramework() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);
        
        //Create the MainScene:
        MainScene scene = MainScene.getMainScene();
        //Add it to the JScrollPane:
        scrollPane.setViewportView(scene.createView());
        //Add the SatellitView to the scene:
        add(scene.createSatelliteView(), BorderLayout.WEST);
        
        Toolbar toolbar = new Toolbar("Controls", JToolBar.VERTICAL);
        JButton buildAPK = toolbar.addToolbarButton("Build APK", "Generate APK", 100, 100);
        JButton addButton = toolbar.addToolbarButton("Add Button", "Add new button", 100, 100);
        JButton addLabel = toolbar.addToolbarButton("Add Label", "Add new label", 100, 100);
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MobileScreen selectedMobileScreen = scene.getSelectedScreen();
                if(selectedMobileScreen == null){
                    JOptionPane.showMessageDialog(null, "Please Select a Screen First!","Select a Screen", JOptionPane.ERROR_MESSAGE);
                } else {
                    String buttonText = JOptionPane.showInputDialog("Please Enter Button Text: ");
                    Widget newButton = selectedMobileScreen.addButton(buttonText);
                    MobileScreen newScreen = new MobileScreen(buttonText, scene);
                   
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                          scene.addMobileScreen(newScreen,newButton);
                        }
                    }).run();
                    
                    scene.validate();
                }
            }
        });
        
        addLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MobileScreen selectedMobileScreen = scene.getSelectedScreen();
                if(selectedMobileScreen == null){
                    JOptionPane.showMessageDialog(null, "Please Select a Screen First!","Select a Screen", JOptionPane.ERROR_MESSAGE);
                } else {
                    String labelText = JOptionPane.showInputDialog("Please Enter Label Text: ");
                    selectedMobileScreen.addLabel(labelText);
                  
                }
            }
        });
        
        add(toolbar, BorderLayout.EAST);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();            
                frame.setSize(screenSize.width, screenSize.height);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new AndroidFramework());
                frame.setVisible(true);
            }
        });
    }
}