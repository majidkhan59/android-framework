/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import org.netbeans.api.visual.graph.GraphScene;

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
        
        //Create the GraphSceneImpl:
        GraphScene scene = new GraphSceneImpl();
        //Add it to the JScrollPane:
        scrollPane.setViewportView(scene.createView());
        //Add the SatellitView to the scene:
        add(scene.createSatelliteView(), BorderLayout.WEST);
        
        JToolBar toolbar = new JToolBar("Controls", JToolBar.VERTICAL);
        toolbar.setLayout(new FlowLayout());
        toolbar.setBackground(Color.white);
        toolbar.setPreferredSize(new Dimension(150,150));
        
        JButton button = new JButton("Build APK");
        button.setPreferredSize(new Dimension(100, 100));
        button.setToolTipText("Generate APK");
        toolbar.add(button);
        
        JButton button2 = new JButton("Add Button");
        button2.setPreferredSize(new Dimension(100, 100));
        toolbar.add(button2);
        
        JButton button3 = new JButton("Add Label");
        button3.setPreferredSize(new Dimension(100, 100));
        toolbar.add(button3);
        
        toolbar.setFloatable(false);
     //   toolbar.addSeparator();
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