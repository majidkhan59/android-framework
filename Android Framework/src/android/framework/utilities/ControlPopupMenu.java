/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.utilities;

import android.framework.Button;
import android.framework.MobileScreen;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import org.netbeans.api.visual.action.PopupMenuProvider;
import org.netbeans.api.visual.widget.Widget;

/**
 * This class manages popup menu of a control which has remove action.
 *
 * @author shoaibahmed
 */
public class ControlPopupMenu implements PopupMenuProvider {

    MobileScreen screenToRemove;
    boolean removeScreen;

    public ControlPopupMenu() {
        this.screenToRemove = null;
    }

    public ControlPopupMenu(MobileScreen screenToRemove,boolean removeScreen) {

        this.screenToRemove = screenToRemove;
        this.removeScreen = removeScreen;
    }

    @Override
    public JPopupMenu getPopupMenu(Widget widget, Point point) {
        JPopupMenu menu = new JPopupMenu();
        JMenuItem removeItem = menu.add("Remove");
        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (widget instanceof Button) {
                    Button toRemove = (Button) widget;
                    toRemove.getConnector().removeFromParent();
                } else {
                  screenToRemove.removeLabel(widget);
                }
                if (removeScreen) {
                    screenToRemove.setSelectionStatus(false);
                    screenToRemove.removeScreen();
                }
                widget.removeFromParent();
            }
        });

        return menu;
    }

}
