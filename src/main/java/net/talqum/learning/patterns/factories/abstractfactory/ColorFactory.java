package net.talqum.learning.patterns.factories.abstractfactory;

import net.talqum.learning.patterns.factories.Shape;

public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    Color getColor(String color) {
        if("RED".equalsIgnoreCase(color)) {
            return new Red();
        } else if("GREEN".equalsIgnoreCase(color)) {
            return new Green();
        } else {
            return null;
        }
    }
}
