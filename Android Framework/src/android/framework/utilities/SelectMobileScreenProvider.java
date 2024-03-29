/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.utilities;

import android.framework.main.MainScene;
import android.framework.main.MobileScreen;
import java.awt.Point;
import org.netbeans.api.visual.action.SelectProvider;
import org.netbeans.api.visual.widget.Widget;

/**
 * Provides the capability to select a Mobile Screen on UI.
 * 
 * @author shoaibahmed
 */
public class SelectMobileScreenProvider implements SelectProvider {
    
    MobileScreen screenToBeSelected;
    MainScene sceneOfScreen;

    public SelectMobileScreenProvider(MobileScreen screen, MainScene scene) {
        screenToBeSelected = screen;
        sceneOfScreen = scene;
    }
    
    @Override
    public boolean isAimingAllowed(Widget widget, Point point, boolean bln) {
        return false;
    }

    @Override
    public boolean isSelectionAllowed(Widget widget, Point point, boolean bln) {
        return true;
    }

    @Override
    public void select(Widget widget, Point point, boolean bln) {        
        sceneOfScreen.setSelectedScreen(screenToBeSelected);
    }

}
