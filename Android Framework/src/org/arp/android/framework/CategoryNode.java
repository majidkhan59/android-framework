package org.arp.android.framework;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.openide.nodes.AbstractNode;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author shoaibahmed
 */
public class CategoryNode extends AbstractNode{
    /** Creates a new instance of CategoryNode */
    public CategoryNode( Category category ) {
        super( new ControlChildren(category), Lookups.singleton(category) );
        setDisplayName(category.getName());
    }
}
