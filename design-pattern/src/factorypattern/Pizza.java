package factorypattern;

import factorypattern.ingredient.*;

import java.awt.datatransfer.MimeTypeParseException;
import java.lang.reflect.GenericArrayType;

public abstract class Pizza {

    String name;

    Dough dough;
    Sauce sauce;
    Veggies[] veggies;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;


    abstract void prepare();

    void bake() {

    }

    void cut() {

    }

    void box() {

    }
}
