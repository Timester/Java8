package net.talqum.learning.patterns.factories.factory;

import net.talqum.learning.patterns.factories.Circle;
import net.talqum.learning.patterns.factories.Rectangle;
import net.talqum.learning.patterns.factories.Shape;

public class ShapeFactory {

    public Shape getShape(String type) {
        if("CIRCLE".equalsIgnoreCase(type)) {
            return new Circle();
        } else if("RECTANGLE".equalsIgnoreCase(type)) {
            return new Rectangle();
        } else {
            return null;
        }
    }
}
