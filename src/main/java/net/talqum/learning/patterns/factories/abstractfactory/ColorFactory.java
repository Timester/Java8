package net.talqum.learning.patterns.factories.abstractfactory;

import net.talqum.learning.patterns.factories.Shape;

/**
 * Created by Tömösvári Imre on 2014.12.22..
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else {
            return null;
        }
    }
}
