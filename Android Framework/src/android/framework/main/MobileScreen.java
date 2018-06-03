/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.main;

import android.framework.utilities.Button;
import android.framework.utilities.ControlPopupMenu;
import android.framework.utilities.FileUtilities;
import android.framework.utilities.SelectMobileScreenProvider;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXLabel;
import org.netbeans.api.visual.action.ActionFactory;
import org.netbeans.api.visual.border.BorderFactory;
import org.netbeans.api.visual.layout.LayoutFactory;
import org.netbeans.api.visual.widget.ComponentWidget;
import org.netbeans.api.visual.widget.ImageWidget;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.SeparatorWidget;
import org.netbeans.api.visual.widget.Widget;
import org.openide.util.Exceptions;

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
    private int activityNumber = 0;

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
        SeparatorWidget separator = new SeparatorWidget(scene, SeparatorWidget.Orientation.HORIZONTAL);
        separator.setThickness(3);
        separator.setPreferredSize(new Dimension(200, 2));
        widget.addChild(separator);
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
     * Gets the activity number of this screen,
     *
     * @return The activity number of the screen.
     */
    public int getActivityNumber() {
        return activityNumber;
    }

    /**
     * Sets the activity number of this screen,
     *
     * @param activityNumber The activity number to set.
     */
    public void setActivityNumber(int activityNumber) {
        this.activityNumber = activityNumber;
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
     * Returns the components of this screen.
     *
     * @return The components of this screen.
     */
    public ArrayList<Widget> getComponents() {
        return screenComponents;
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

        JXLabel label = new JXLabel(text);
        label.setLineWrap(true);
        label.setMaxLineSpan(180);
        label.setMinimumSize(new Dimension(0, 10));
        label.setFont(new Font("Arial Unicode MS", 0, 11));
        label.setTextAlignment(JXLabel.TextAlignment.JUSTIFY);
        ComponentWidget newLabel = new ComponentWidget(mainScene, label);

        newLabel.getActions().addAction(ActionFactory.createPopupMenuAction(new ControlPopupMenu(this, false)));

        widget.addChild(newLabel);
        screenComponents.add(newLabel);
        mainScene.validate();
    }

    /**
     * Adds an image on this screen.
     *
     * @param imagePath The path of the Image.
     * @return Returns the new widget made.
     */
    public ImageWidget addImage(String imagePath) {
        try {

            BufferedImage image = new BufferedImage(150, 100, BufferedImage.TYPE_INT_ARGB);
            BufferedImage resized = new BufferedImage(150, 100, BufferedImage.TYPE_INT_ARGB);
            
            image = ImageIO.read(new File(imagePath));
            Image tmp = image.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
            
            Graphics2D g2d = resized.createGraphics();
            g2d.drawImage(tmp, 0, 0, null);
            g2d.dispose();
            
            ImageIcon imageI = new ImageIcon(imagePath);
            ImageWidget imageW = new ImageWidget(mainScene, resized);
            imageW.setToolTipText(FileUtilities.copyIcon(imagePath));
            imageW.setPreferredSize(new Dimension(150, 100));
            imageW.getActions().addAction(ActionFactory.createPopupMenuAction(new ControlPopupMenu(this, false)));

            widget.addChild(imageW);
            screenComponents.add(imageW);
            mainScene.validate();
            return imageW;
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }

    /**
     * Removes this screen and its children from the scene.
     *
     */
    public void removeScreen() {
        // Removes each component from this screen.
        for (int i = 0; i < screenComponents.size(); i++) {
            Widget thisComponent = screenComponents.get(i);
            // Checks if this component is a button.
            if (thisComponent instanceof Button) {
                Button button = (Button) thisComponent;
                button.getConnector().removeFromParent();
                MobileScreen childScreen = mainScene.getMobileScreenByButton(button);
                childScreen.removeScreen();
            } // Else this component is text. 
            else {
                thisComponent.removeFromParent();
                screenComponents.remove(thisComponent);
                i--;
            }
        }

        // Removing this screen and their children.
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
     * Removes the given image from the screen.
     *
     * @param imageToRemove The label to remove.
     */
    public void removeImage(Widget imageToRemove) {
        screenComponents.remove(imageToRemove);
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
        return screenTitle + "Activity " + activityNumber;
    }
}
