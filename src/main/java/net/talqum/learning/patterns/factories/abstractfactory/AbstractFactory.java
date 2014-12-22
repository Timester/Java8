package net.talqum.learning.patterns.factories.abstractfactory;

import net.talqum.learning.patterns.factories.Shape;

/**
 * Created by Tömösvári Imre on 2014.12.22..
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape) ;
}
