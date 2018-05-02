/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework;

import android.framework.utilities.ControlPopupMenu;
import android.framework.utilities.SelectMobileScreenProvider;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXLabel;
import org.netbeans.api.visual.action.ActionFactory;
import org.netbeans.api.visual.border.BorderFactory;
import org.netbeans.api.visual.layout.LayoutFactory;
import org.netbeans.api.visual.widget.ComponentWidget;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.Widget;

/**
 * This class manages a single screen which is initially generated as well as
 * generated by adding a button.
 *
 * @author shoaib ahmed
 */
public class MobileScreen {

    private JPanel screen;
    private String screenTitle;
    private ComponentWidget widget;
    private MainScene mainScene;
    private boolean isSelected;
    private ArrayList<Widget> screenComponents = new ArrayList<>();

    /**
     * This is the default constructor, which generates a Mobile Screen on UI.
     *
     * @param title The title of the Mobile Screen.
     * @param scene The scene in which screen is made.
     */
    public MobileScreen(String title, MainScene scene) {
        screen = new JPanel();
        screen.setPreferredSize(new Dimension(200, 400));

        isSelected = false;
        mainScene = scene;
        screenTitle = title;

        widget = new ComponentWidget(mainScene, screen);
        widget.setLayout(LayoutFactory.createVerticalFlowLayout(LayoutFactory.SerialAlignment.CENTER, 10));
        widget.setBorder(BorderFactory.createLineBorder());
        widget.getActions().addAction(ActionFactory.createSelectAction(new SelectMobileScreenProvider(this, scene)));
        widget.getActions().addAction(ActionFactory.createMoveAction());
        widget.addChild(new LabelWidget(scene));
        widget.addChild(new LabelWidget(scene, title));
    }

    /**
     * Sets the size of mobile screen.
     *
     * @param width Width of the screen.
     * @param height Height of the screen
     */
    public void setScreenSize(int width, int height) {
        screen.setPreferredSize(new Dimension(width, height));
    }

    /**
     * Set position of mobile screen.
     *
     * @param x Value of x-axis.
     * @param y Value of y-axis.
     */
    public void setScreenPosition(int x, int y) {
        widget.setPreferredLocation(new Point(x, y));
    }

    /**
     * Gets position of the mobile screen.
     *
     * @return The position as a Point object.
     */
    public Point getScreenPosition() {
        return widget.getPreferredLocation();
    }

    /**
     * Returns the Component Widget.
     *
     * @return Component Widget.
     */
    public ComponentWidget getWidget() {
        return widget;
    }

    /**
     * Returns the title of this screen.
     *
     * @return The title of this screen.
     */
    public String getScreenTitle() {
        return screenTitle;
    }

    /**
     * Adds a button on this screen.
     *
     * @param text The title of the button.
     * @return Returns the new widget made.
     */
    public Button addButton(String text) {
        Button newButton = new Button(mainScene, text);
        newButton.setFont(new Font("", 0, 14));
        newButton.setBorder(org.netbeans.api.visual.border.BorderFactory.createBevelBorder(true));
        widget.addChild(newButton);
        screenComponents.add(newButton);
        System.out.println("Screen " + screenTitle + " But " + screenComponents.toString());
        mainScene.validate();
        return newButton;
    }

    /**
     * Adds a label on this screen.
     *
     * @param text The text of the label
     *
     */
    public void addLabel(String text) {
        /*JTextArea label = new JTextArea(2,0);
        label.setEditable(false);
        label.setLineWrap(true);
        label.setWrapStyleWord(true);
        label.setOpaque(false);
        label.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        label.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
        label.setText(text);
        
        String labelText ="<html>";
        for(int i = 0; i < text.length();i+=10){
            labelText += text.substring(i, i+10);
            labelText += "<br>";
        }
        labelText += "</html>";
        JLabel label = new JLabel(labelText);*/
        JXLabel label = new JXLabel(text);
        label.setLineWrap(true);
        label.setMaxLineSpan(180);
        label.setMinimumSize(new Dimension(0, 10));
        JXLabel.MultiLineSupport.createView(label);
        
        ComponentWidget newLabel = new ComponentWidget(mainScene, label);
        
        //Widget newLabel = new LabelWidget(mainScene, text);
        newLabel.setFont(new Font("", 0, 14));
        newLabel.getActions().addAction(ActionFactory.createPopupMenuAction(new ControlPopupMenu(this, false)));
        //newLabel.setBorder(BorderFactory.createLineBorder(2, Color.yellow));

        widget.addChild(newLabel);
        screenComponents.add(newLabel);
        mainScene.validate();
    }

    /**
     * Removes this screen and its children from the scene.
     *
     */
    public void removeScreen() {
        Iterator<Widget> compIter = screenComponents.iterator();

        while (compIter.hasNext()) {
            Widget thisComponent = compIter.next();
            if (thisComponent instanceof Button) {
                Button button = (Button) thisComponent;
                button.getConnector().removeFromParent();
                MobileScreen childScreen = mainScene.getMobileScreenByButton(button);
                childScreen.removeScreen();
            } else {
                thisComponent.removeFromParent();
                screenComponents.remove(thisComponent);
            }

            //mainScene.removeMobileScreen(childScreen);
        }
        widget.removeChildren();
        widget.removeFromParent();
        mainScene.validate();
        mainScene.removeMobileScreen(this);
    }

    /**
     * Removes the given label from the screen.
     *
     * @param labelToRemove The label to remove.
     */
    public void removeLabel(Widget labelToRemove) {
        screenComponents.remove(labelToRemove);
    }

    /**
     * Removes the given button from the screen.
     *
     * @param buttonToRemove The button to remove.
     */
    public void removeButton(Button buttonToRemove) {
        screenComponents.remove(buttonToRemove);
    }

    /**
     * Returns if this screen is selected by user.
     *
     * @return The selection status of this screen.
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     * Sets the selection status of this screen.
     *
     * @param isSelected The selection status of this screen.
     */
    public void setSelectionStatus(boolean isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public String toString() {
        return screenTitle;
    }
}
