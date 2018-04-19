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
 *
 * @author shoaibahmed
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
        JButton button = new JButton("Build APK");
        button.setPreferredSize(new Dimension(100, 100));

        toolbar.add(button, BorderLayout.NORTH);
        toolbar.setFloatable(false);
        toolbar.addSeparator();
        add(toolbar, BorderLayout.EAST);
       
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int height = screenSize.height;
                int width = screenSize.width;
                frame.setSize(width / 2, height / 2);
                frame.setLocationRelativeTo(null);
                frame.setMinimumSize(new Dimension(800, 500));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new AndroidFramework());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
