/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.utilities;

import java.awt.Point;
import java.awt.Rectangle;
import org.netbeans.api.visual.action.MoveStrategy;
import org.netbeans.api.visual.widget.Widget;

/**
 * This class implements move strategy to move a control within a frame.
 *
 * @author shoaibahmed
 */
public class MoveWithinFrameStrategy implements MoveStrategy{

    Rectangle frameBounds;
    public MoveWithinFrameStrategy(Rectangle frameBounds) {
        this.frameBounds = frameBounds;
    }
    

    @Override
    public Point locationSuggested(Widget widget, Point point, Point point1) { // SELECT LOCATION THING
        System.out.println("Or " + point.toString());
        System.out.println("Lo " + point1.toString());
        System.out.println("fb " + frameBounds.toString());
        
        if(point1.x < 0 || point1.y < 0){
          return point;
        }
     /*   if(point1.x > frameBounds.x + frameBounds.width){
            return point;
        }*/
      // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return point1;
    }
    
}
