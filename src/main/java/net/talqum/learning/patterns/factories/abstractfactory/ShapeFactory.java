package net.talqum.learning.patterns.factories.abstractfactory;

import net.talqum.learning.patterns.factories.Circle;
import net.talqum.learning.patterns.factories.Rectangle;
import net.talqum.learning.patterns.factories.Shape;

/**
 * Created by Tömösvári Imre on 2014.12.22..
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else{
            return null;
        }
    }

    @Override
    Color getColor(String color) {
        return null;
    }
}
