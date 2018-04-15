package android.framework;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import org.openide.nodes.Index;

/**
 *
 * @author shoaibahmed
 */
public class ControlChildren extends Index.ArrayChildren {

    private Category category;

    private String[][] items = new String[][]{
        {"0", "Shapes", "org/netbeans/shapesample/palette/image1.png"},
        {"1", "Shapes", "org/netbeans/shapesample/palette/image2.png"},
        {"2", "Shapes", "org/netbeans/shapesample/palette/image3.png"},};

    public ControlChildren(Category Category) {
        this.category = Category;
    }

    protected java.util.List initCollection() {
        ArrayList childrenNodes = new ArrayList(items.length);
        for (int i = 0; i < items.length; i++) {
            if (category.getName().equals(items[i][1])) {
                Control item = new Control();
                item.setNumber(new Integer(items[i][0]));
                item.setCategory(items[i][1]);
                item.setImage(items[i][2]);
                childrenNodes.add(new ControlNode(item));
            }
        }
        return childrenNodes;
    }
}
