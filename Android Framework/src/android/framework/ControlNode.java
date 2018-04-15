package android.framework;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author shoaibahmed
 */
public class ControlNode extends AbstractNode {
    private Control control;
    
    /** Creates a new instance of InstrumentNode */
    public ControlNode(Control key) {
        super(Children.LEAF, Lookups.fixed( new Object[] {key} ) );
        this.control = key;
        setIconBaseWithExtension(key.getImage());
    }
}
