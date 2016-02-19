package net.talqum.learning.patterns.factories.abstractfactory;

import net.talqum.learning.patterns.factories.Circle;
import net.talqum.learning.patterns.factories.Rectangle;
import net.talqum.learning.patterns.factories.Shape;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        if("CIRCLE".equalsIgnoreCase(shapeType)) {
            return new Circle();
        } else if("RECTANGLE".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        } else {
            return null;
        }
    }

    @Override
    Color getColor(String color) {
        return null;
    }
}
