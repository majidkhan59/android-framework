package org.arp.android.framework;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.netbeans.api.visual.graph.GraphScene;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author shoaibahmed
 */
public class VisLibDemo extends JPanel {

    public VisLibDemo() {
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
       
        //   add(Lookups.singleton(PaletteSupport.createPalette())); 
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setSize(1500, 1400);
                frame.setMinimumSize(new Dimension(500, 400));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new VisLibDemo());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

}
