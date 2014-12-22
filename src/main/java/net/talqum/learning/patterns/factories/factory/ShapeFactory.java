package net.talqum.learning.patterns.factories.factory;

import net.talqum.learning.patterns.factories.Circle;
import net.talqum.learning.patterns.factories.Rectangle;
import net.talqum.learning.patterns.factories.Shape;

/**
 * Created by Tömösvári Imre on 2014.12.22..
 */
public class ShapeFactory {

    public Shape getShape(String type){
        if(type == null){
            return null;
        }

        if(type.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(type.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else{
            return null;
        }
    }
}
