package javaDesignPatterns.singletonCreational;

import java.io.Serializable;
import java.util.Arrays;

public class Foo implements Serializable {
    public static final Foo INSTANCE = new Foo();
    private Foo() {}
    private final String[] favouriteMovies = {"3 idiots", "Krish", "Tare Zameen Par"};
    public void printFavourites() {
        System.out.println(Arrays.asList(favouriteMovies));
    }
    private Object readResolve() {
        return INSTANCE;
    }
}
