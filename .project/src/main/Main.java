package main;

import function.LinearRegressionFunction;

import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        double[] theta = {0, 0};
        Function<Double[], Double> target = new LinearRegressionFunction(theta);

        Double[] x = new Double[] {1.0, 1330.0};
        double y = target.apply(x);

        System.out.println("y = " + y);
    }

}
