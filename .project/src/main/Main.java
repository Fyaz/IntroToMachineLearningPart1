package main;

import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        // The Double[] is the input to the function, and the Double is the output of the function
        Function<Double[], Double> h = x -> {
            return 0.0;
        };

        Double[] x = new Double[] {101.0, 3.0};
        double y = h.apply(x);
    }

}
