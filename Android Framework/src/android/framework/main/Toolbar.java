/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 * This class manages toolbar of the application.
 * 
 * @author shoaibahmed
 */
public class Toolbar extends JToolBar {
    
    private ArrayList<JButton> buttons = new ArrayList<>();
  
    /**
     * This constructor generates a toolbar with given information.
     * 
     * @param name The name of the toolbar.
     * @param orientation The default orientation of the toolbar.
     */
    public Toolbar(String name, int orientation) {
        super(name, orientation);
        this.setLayout(new FlowLayout());
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(150,150));
        this.setFloatable(false);
    }
    
    /**
     * This function adds a button with specified information in the toolbar.
     * 
     * @param text The text of the button to be displayed.
     * @param tooltip The tooltip text of the button to be displayed.
     * @param height The height of the button.
     * @param width The width of the button.
     * @return The button added to the toolbar.
     */
    public final JButton addToolbarButton(String text, String tooltip, int width, int height){
        JButton buttonToAdd = new JButton(text);
        buttonToAdd.setToolTipText(tooltip);
        buttonToAdd.setPreferredSize(new Dimension(width, height));
        buttons.add(buttonToAdd);
        add(buttonToAdd);
        return buttonToAdd;
    }
}
