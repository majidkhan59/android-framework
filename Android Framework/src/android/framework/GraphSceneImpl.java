/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework;

import java.awt.Point;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.netbeans.api.visual.action.ActionFactory;
import org.netbeans.api.visual.action.ConnectProvider;
import org.netbeans.api.visual.action.ConnectorState;
import org.netbeans.api.visual.anchor.AnchorFactory;
import org.netbeans.api.visual.anchor.AnchorShape;
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
public class GraphSceneImpl extends GraphScene<String, String> {

    private LayerWidget mainLayer;
    private LayerWidget connectionLayer;
    private LayerWidget interactionLayer;
    private Map<Widget, MobileScreen> mobileScreens = new HashMap<>();

    public GraphSceneImpl() {
        mainLayer = new LayerWidget(this);
        connectionLayer = new LayerWidget(this);
        interactionLayer = new LayerWidget(this);
        addChild(mainLayer);
        addChild(connectionLayer);
        addChild(interactionLayer);

        MobileScreen mainScreen = new MobileScreen("Main Screen", this);
        mainScreen.setScreenPosition(50, 50);
        mainScreen.getWidget().bringToBack();

        mainScreen.addButton("Button 1");
        mainScreen.addButton("Button 2");
        addMobileScreen(mainScreen, null);
        getActions().addAction(ActionFactory.createZoomAction());

    }

    /**
     * This function finds and returns selected mobile screen.
     *
     * @return The mobile screen selected by user.
     */
    public MobileScreen getSelectedScreen() {
        Iterator<MobileScreen> screenIter = mobileScreens.values().iterator();
        while(screenIter.hasNext()){
            MobileScreen nextScreen = screenIter.next();
            if (nextScreen.isSelected()) {
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
    public void addMobileScreen(MobileScreen screenToAdd, Widget buttonToConnect) {
        int totalScreens = mobileScreens.size();
        if (totalScreens > 0) {
            MobileScreen lastScreen = (MobileScreen)mobileScreens.values().toArray()[totalScreens - 1];
            Point lastScreenPosition = lastScreen.getScreenPosition();
            screenToAdd.setScreenPosition(lastScreenPosition.x + 300, lastScreenPosition.y);
        }
        if (buttonToConnect != null) {
            ConnectionWidget conn = new ConnectionWidget(this);
            conn.setTargetAnchorShape(AnchorShape.TRIANGLE_FILLED);
            conn.setTargetAnchor(AnchorFactory.createRectangularAnchor(screenToAdd.getWidget()));
            conn.setSourceAnchor(AnchorFactory.createRectangularAnchor(buttonToConnect));
            connectionLayer.addChild(conn);
        }
        mainLayer.addChild(screenToAdd.getWidget());
        mobileScreens.put(buttonToConnect, screenToAdd);
    }

    @Override
    protected Widget attachNodeWidget(String arg) {
        IconNodeWidget widget = new IconNodeWidget(this);

        widget.getActions().addAction(
                ActionFactory.createExtendedConnectAction(
                        connectionLayer, new MyConnectProvider()));
        widget.getActions().addAction(
                ActionFactory.createAlignWithMoveAction(
                        mainLayer, interactionLayer,
                        ActionFactory.createDefaultAlignWithMoveDecorator()));
        widget.setLabel(arg);
        mainLayer.addChild(widget);
        return widget;
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
            ConnectionWidget conn = new ConnectionWidget(GraphSceneImpl.this);
            conn.setTargetAnchorShape(AnchorShape.TRIANGLE_FILLED);
            conn.setTargetAnchor(AnchorFactory.createRectangularAnchor(target));
            conn.setSourceAnchor(AnchorFactory.createRectangularAnchor(source));
            connectionLayer.addChild(conn);
        }
    }
}
