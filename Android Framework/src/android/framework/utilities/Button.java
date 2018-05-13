/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.utilities;

import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.Scene;

/**
 * This class extends the functionalities of a widget and stores the connections from the button.
 * 
 * @author shoaibahmed
 */
public class Button extends LabelWidget{
    
    private ConnectionWidget connector;

    public Button(ConnectionWidget connector, Scene scene, String string) {
        super(scene, string);
        this.connector = connector;
    }

    public Button(Scene scene, String string) {
        super(scene,string);
    }
    
    public void setConnector(ConnectionWidget connector){
        this.connector = connector;
    }

    public ConnectionWidget getConnector() {
        return connector;
    }

    @Override
    public String toString() {
        return getLabel();
    }     
}
