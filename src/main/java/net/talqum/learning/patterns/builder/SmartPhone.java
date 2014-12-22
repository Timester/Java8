package net.talqum.learning.patterns.builder;

/**
 * Created by Tömösvári Imre on 2014.12.22.
 *
 * Builder pattern for initializing classes.
 *
 * SmartPhone - immutable example class,
 */
public class SmartPhone {
    private final long id;
    private final String manufacturer;
    private final String name;
    private final float screenSize;
    private final double price;

    public static class Builder{
        // mandatory parameter
        private final long id;

        // optional parameters with optional default values
        private String manufacturer = "LG";
        private String name = "Nexus 5";
        private float screenSize = 5.0f;
        private double price = 200;

        public Builder(long id){
            this.id = id;
        }

        public Builder manufacturer(String manufacturer){
            this.manufacturer = manufacturer;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder screenSize(float screenSize){
            this.screenSize = screenSize;
            return this;
        }

        public Builder price(double price){
            this.price = price;
            return this;
        }

        public SmartPhone build(){
            return new SmartPhone(this);
        }
    }

    private SmartPhone(Builder b){
        id = b.id;
        manufacturer = b.manufacturer;
        name = b.name;
        screenSize = b.screenSize;
        price = b.price;
    }

    public long getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getName() {
        return name;
    }

    public float getScreenSize() {
        return screenSize;
    }

    public double getPrice() {
        return price;
    }
}
