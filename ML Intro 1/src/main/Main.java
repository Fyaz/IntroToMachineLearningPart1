package main;

import java.util.Arrays;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        // The Double[] is the input to the function, and the Double is the output of the function
        Function<Double[], Double> h = input -> {
            Double sum = (double) 0;
            for(Double d: input)
                sum += d;
            return sum;
        };

        Double[] input = {(double)10, (double)20, (double)3};
        Double result = h.apply(input);

        System.out.println("The sum of " + Arrays.toString(input) + " is " + result);
    }

}
