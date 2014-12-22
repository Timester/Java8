package net.talqum.learning.patterns.factories.factory;

import net.talqum.learning.patterns.factories.Shape;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeFactoryTest {

    @Test
    public void testGetShape() throws Exception {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape("CIRCLE");
        assertEquals("Circle::whatAmI()", circle.whatAmI());

        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        assertEquals("Rectangle::whatAmI()", rectangle.whatAmI());

        Shape error = shapeFactory.getShape("SQUARE");
        assertNull(error);
    }
}