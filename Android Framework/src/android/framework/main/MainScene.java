/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.main;

import android.framework.utilities.Constants;
import android.framework.utilities.ControlPopupMenu;
import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.netbeans.api.visual.action.ActionFactory;
import org.netbeans.api.visual.action.ConnectProvider;
import org.netbeans.api.visual.action.ConnectorState;
import org.netbeans.api.visual.anchor.AnchorFactory;
import org.netbeans.api.visual.anchor.AnchorShape;
import org.netbeans.api.visual.border.BorderFactory;
import org.netbeans.api.visual.graph.GraphScene;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;
import org.netbeans.api.visual.widget.general.IconNodeWidget;

/**
 * This class manages the main scene of the application.
 *
 * @author shoaib ahmed
 */
public class MainScene extends GraphScene<String, String> {

    private static MainScene mainScene;
    private LayerWidget mainLayer;
    private LayerWidget connectionLayer;
    private LayerWidget interactionLayer;
    private Map<Button, MobileScreen> mobileScreens = new HashMap<>();

    private MainScene() {
        mainLayer = new LayerWidget(this);
        connectionLayer = new LayerWidget(this);
        interactionLayer = new LayerWidget(this);
        addChild(mainLayer);
        addChild(connectionLayer);
        addChild(interactionLayer);

        MobileScreen mainScreen = new MobileScreen(Constants.PROJECT_NAME, this);
        mainScreen.setScreenPosition(50, 50);
        mainScreen.getWidget().bringToBack();

        addMobileScreen(mainScreen, null);
        getActions().addAction(ActionFactory.createZoomAction());

    }

    public static MainScene getMainScene() {
        if (mainScene == null) {
            mainScene = new MainScene();
        }

        return mainScene;
    }

    /**
     * This function finds and returns selected mobile screen.
     *
     * @return The mobile screen selected by user.
     */
    public MobileScreen getSelectedScreen() {
        Iterator<MobileScreen> screenIter = mobileScreens.values().iterator();
        while (screenIter.hasNext()) {
            MobileScreen nextScreen = screenIter.next();
            if (nextScreen.isSelected()) {
                return nextScreen;
            }
        }
        return null;
    }

    /**
     * Sets selected screen in the scene.
     *
     * @param selectedScreen The screen to be selected.
     */
    public void setSelectedScreen(MobileScreen selectedScreen) {
        Iterator<MobileScreen> screenIter = mobileScreens.values().iterator();
        while (screenIter.hasNext()) {
            MobileScreen nextScreen = screenIter.next();
            if (nextScreen.equals(selectedScreen)) {
                nextScreen.setSelectionStatus(true);
                nextScreen.getWidget().setBorder(BorderFactory.createLineBorder(2, Color.RED));
            } else {
                nextScreen.setSelectionStatus(false);
                nextScreen.getWidget().setBorder(BorderFactory.createLineBorder());
            }
        }

    }

    /**
     * Gets Mobile Screen which is connected to given button.
     *
     * @param button The button to search screen for.
     * @return The screen found using button.
     */
    public MobileScreen getMobileScreenByButton(Button button) {
        return mobileScreens.get(button);
    }

    /**
     * Gets Mobile Screen which is connected to given widget.
     * 
     * @param screenWidget The widget to search for.
     * @return The screen found using widget.
     */
    public MobileScreen getMobileScreenByWidget(Widget screenWidget) {
        Iterator<MobileScreen> screenIter = mobileScreens.values().iterator();
        while (screenIter.hasNext()) {
            MobileScreen nextScreen = screenIter.next();
            if (nextScreen.getWidget().equals(screenWidget)) {
                return nextScreen;
            }
        }
        return null;
    }

    /**
     * Adds the mobile screen in the main scene.
     *
     * @param screenToAdd The mobile screen to add.
     * @param buttonToConnect The button which is connected to the mobile
     * screen.
     */
    public void addMobileScreen(MobileScreen screenToAdd, Button buttonToConnect) {
        int totalScreens = mobileScreens.size();
        ConnectionWidget conn = new ConnectionWidget(this);
        if (totalScreens > 0) {
            MobileScreen lastScreen = (MobileScreen) mobileScreens.values().toArray()[totalScreens - 1];
            Point lastScreenPosition = lastScreen.getScreenPosition();
            screenToAdd.setScreenPosition(lastScreenPosition.x + 300, lastScreenPosition.y);
        }
        if (buttonToConnect != null) {
            conn.setTargetAnchorShape(AnchorShape.TRIANGLE_FILLED);
            conn.setTargetAnchor(AnchorFactory.createRectangularAnchor(screenToAdd.getWidget()));
            conn.setSourceAnchor(AnchorFactory.createRectangularAnchor(buttonToConnect));
            connectionLayer.addChild(conn);

            buttonToConnect.setConnector(conn);
            buttonToConnect.getActions().addAction(ActionFactory.createPopupMenuAction(new ControlPopupMenu(screenToAdd, true)));
        }

        mainLayer.addChild(screenToAdd.getWidget());
        mobileScreens.put(buttonToConnect, screenToAdd);
    }

    /**
     * Removes Mobile Screen from the List.
     *
     * @param screenToRemove The screen to remove.
     */
    public void removeMobileScreen(MobileScreen screenToRemove) {
        Iterator<Map.Entry<Button, MobileScreen>> iter = mobileScreens.entrySet().iterator();
        while (iter.hasNext()) {
            MobileScreen value = iter.next().getValue();
            if (screenToRemove.equals(value)) {
                iter.remove();
                break;
            }
        }
    }

    @Override
    protected Widget attachNodeWidget(String arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected Widget attachEdgeWidget(String arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void attachEdgeSourceAnchor(String arg0, String arg1, String arg2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void attachEdgeTargetAnchor(String arg0, String arg1, String arg2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    class MyConnectProvider implements ConnectProvider {

        public boolean isSourceWidget(Widget source) {
            return source instanceof IconNodeWidget && source != null ? true : false;
        }

        public ConnectorState isTargetWidget(Widget src, Widget trg) {
            return src != trg && trg instanceof IconNodeWidget ? ConnectorState.ACCEPT : ConnectorState.REJECT;
        }

        public boolean hasCustomTargetWidgetResolver(Scene arg0) {
            return false;
        }

        public Widget resolveTargetWidget(Scene arg0, Point arg1) {
            return null;
        }

        public void createConnection(Widget source, Widget target) {
            ConnectionWidget conn = new ConnectionWidget(MainScene.this);
            conn.setTargetAnchorShape(AnchorShape.TRIANGLE_FILLED);
            conn.setTargetAnchor(AnchorFactory.createRectangularAnchor(target));
            conn.setSourceAnchor(AnchorFactory.createRectangularAnchor(source));
            connectionLayer.addChild(conn);
        }
    }
}
