/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.main;

import android.framework.utilities.Toolbar;
import android.framework.utilities.Button;
import android.framework.sdk.CodeGenerator;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

/**
 * This is the main class of the application.
 * 
 * @author shoaib ahmed
 */
public class frmAndroidFramework extends JInternalFrame {

    public frmAndroidFramework() {
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
        JButton addLabel = toolbar.addToolbarButton("Add Text", "Add new text", 100, 100);
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MobileScreen selectedMobileScreen = scene.getSelectedScreen();
                if(selectedMobileScreen == null){
                    JOptionPane.showMessageDialog(null, "Please Select a Screen First!","Select a Screen", JOptionPane.ERROR_MESSAGE);
                } else {
                    String buttonText = JOptionPane.showInputDialog("Please Enter Button Text: ");
                    while(buttonText.isEmpty()){
                        buttonText = JOptionPane.showInputDialog("Please Enter Button Text: ");
                    }
                    Button newButton = selectedMobileScreen.addButton(buttonText);
                    MobileScreen newScreen = new MobileScreen(buttonText, scene);
                   
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                          scene.addMobileScreen(newScreen,newButton);
                          scene.validate();
                        }
                    }).start();
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
                    while(labelText.isEmpty()){
                        labelText = JOptionPane.showInputDialog("Please Enter Label Text: ");
                    }
                    selectedMobileScreen.addLabel(labelText);
                  
                }
            }
        });
        
        buildAPK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MobileScreen selectedMobileScreen = scene.getMobileScreenByButton(null);
                CodeGenerator.manifestGenerate(scene.getMobileScreenTitles());
                CodeGenerator.javaFileGenerate(selectedMobileScreen.getComponents());
                CodeGenerator.layoutGenerate(selectedMobileScreen.getComponents());
                CodeGenerator.resourceGenerate(selectedMobileScreen.getComponents(),scene.getMobileScreenTitles());
                CodeGenerator.generateAPK();
            }
        });
        
        add(toolbar, BorderLayout.EAST);
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                  CodeGenerator.createNewAndroidProject();
              }
        }).start();
      
        
    }
}