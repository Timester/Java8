package net.talqum.learning.patterns.factories.abstractfactory;

import net.talqum.learning.patterns.factories.Shape;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractFactoryTest {

    @Test
    public void testAbstractFactory(){
        // get shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        Shape circle = shapeFactory.getShape("CIRCLE");
        assertEquals("Circle::whatAmI()", circle.whatAmI());

        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        assertEquals("Rectangle::whatAmI()", rectangle.whatAmI());

        Shape error = shapeFactory.getShape("SQUARE");
        assertNull(error);

        // get color factory
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        Color red = colorFactory.getColor("RED");
        assertEquals("Red::whatColorAmI()", red.whatColorAmI());

        Color green = colorFactory.getColor("GREEN");
        assertEquals("Green::whatColorAmI()", green.whatColorAmI());

        Color error2 = colorFactory.getColor("BLUE");
        assertNull(error);
    }

}