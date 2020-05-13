package main;

import data.HouseRecords;
import data.util.FeatureVector;
import data.util.FileVector;

import java.util.Arrays;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        // The Double[] is the input to the function, and the Double is the output of the function
        Function<HouseRecords, Double> h = input -> {
            return (double) 0;
        };

        // Train the function
        FeatureVector<HouseRecords> x = new FileVector<>();
        HouseRecords data = x.next();
        while(data != null) {
            // TODO: Apply our function here
            data = x.next();
        }
    }

}
