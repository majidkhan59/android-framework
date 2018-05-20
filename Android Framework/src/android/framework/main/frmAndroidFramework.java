/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.main;

import android.framework.forms.buttonInput;
import android.framework.forms.labelInput;
import android.framework.utilities.Toolbar;
import android.framework.utilities.Button;
import android.framework.sdk.CodeGenerator;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
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

                if (selectedMobileScreen == null) {
                    JOptionPane.showMessageDialog(null, "Please Select a Screen First!", "Select a Screen", JOptionPane.ERROR_MESSAGE);
                } else {
                    buttonInput form = new buttonInput(null, true);
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    form.setLocation(screenSize.width / 3, screenSize.height / 3);

                    form.show();
                    String[] text = form.getValue();
                    String buttonText = text[0];
                    String screenTitle = (text[1].isEmpty()) ? buttonText : text[1];

                    System.out.println("TEXT " + text.toString() + " BT " + buttonText + " ST " + screenTitle);
                    Button newButton = selectedMobileScreen.addButton(buttonText);
                    MobileScreen newScreen = new MobileScreen(screenTitle, scene);

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            scene.addMobileScreen(newScreen, newButton);
                            scene.validate();
                        }
                    }).start();

                    /*
                if (selectedMobileScreen == null) {
                    JOptionPane.showMessageDialog(null, "Please Select a Screen First!", "Select a Screen", JOptionPane.ERROR_MESSAGE);
                } else {
                    String buttonText = JOptionPane.showInputDialog("Please Enter Button Text: ");
                    while (buttonText == null || buttonText.isEmpty()) {
                        buttonText = JOptionPane.showInputDialog("Please Enter Button Text: ");
                    }
                    Button newButton = selectedMobileScreen.addButton(buttonText);
                    MobileScreen newScreen = new MobileScreen(buttonText, scene);

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            scene.addMobileScreen(newScreen, newButton);
                            scene.validate();
                        }
                    }).start();
                }*/
                }
            }
        });

        addLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MobileScreen selectedMobileScreen = scene.getSelectedScreen();
                    
                if (selectedMobileScreen == null) {
                    JOptionPane.showMessageDialog(null, "Please Select a Screen First!", "Select a Screen", JOptionPane.ERROR_MESSAGE);
                } else {
                    labelInput form = new labelInput(null, true);
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    form.setLocation(screenSize.width / 3, screenSize.height / 3);

                    form.show();
                    String labelText = form.getText();
                    selectedMobileScreen.addLabel(labelText);

                
                  /*  String labelText = JOptionPane.showInputDialog("Please Enter Label Text: ");
                    while(labelText == null || labelText.isEmpty()){
                        labelText = JOptionPane.showInputDialog("Please Enter Label Text: ");
                    }
                    selectedMobileScreen.addLabel(labelText);
                  
                }*/
                }
            }
        });

        buildAPK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Generates Android Manifest File along with java classes.
                CodeGenerator.manifestGenerate(scene.getMobileScreenTitles());

                // Generates required Layout files and updates scene map with the activity number.
                CodeGenerator.layoutGenerate(scene.getSceneMap());

                // Generates required Resource files.
                CodeGenerator.resourceGenerate(scene.getSceneMap());

                // Generates required Activity files.
                CodeGenerator.javaFileGenerate(scene.getSceneMap());

                // Generates APK using above generated files.
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
