/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.utilities;

import java.awt.Dimension;
import java.awt.Point;
import org.netbeans.api.visual.action.MoveStrategy;
import org.netbeans.api.visual.widget.Widget;

/**
 * This class implements move strategy to move a control within a frame.
 *
 * @author shoaibahmed
 */
public class MoveWithinFrameStrategy implements MoveStrategy{

    Dimension frameSize;
    Point frameLocation;
    public MoveWithinFrameStrategy(Dimension size, Point location) {
        this.frameSize = size;
        this.frameLocation = location;
    }
    

    @Override
    public Point locationSuggested(Widget widget, Point point, Point point1) { // SELECT LOCATION THING
        System.out.println("Or " + point.toString());
        System.out.println("Lo " + point1.toString());
        System.out.println("fb " + frameLocation.toString());
        System.out.println("wi " + widget.getBounds().toString());
        
        if(point1.x < 60 || point1.x > (widget.getBounds().width) ){
          return new Point(60, point.y);
         }
        
        if(point1.y < 55){
            return point; // CHECK FOR BUTTONS AND ADD AS NEXT BUTTON
        }
       /* if(point1.x > frameLocation.x + (frameSize.width - widget.getBounds().width)){
            return point;
        }*/
      // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return point1;
    }
    
}
