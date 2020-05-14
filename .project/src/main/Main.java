package main;

import data.HouseRecords;
import data.util.FeatureVector;
import data.util.HouseRecordsVector;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        // The Double[] is the input to the function, and the Double is the output of the function
        Function<HouseRecords, Double> h = input -> {
            return (double) 0;
        };

        // Train the function
        String file_to_open = "lib/HouseRecords/input.txt";
        try {
            FeatureVector<HouseRecords> x = new HouseRecordsVector(file_to_open);
            HouseRecords data = x.next();
            while (data != null) {
                // TODO: Apply our function here
                data = x.next();
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found: " + file_to_open);
        }
    }

}
