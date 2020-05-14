package function;

import java.util.Arrays;
import java.util.function.Function;

public class LinearRegressionFunction implements Function<Double[], Double> {
    private final double[] thetaVector;

    LinearRegressionFunction(double[] thetaVector) {
        this.thetaVector = Arrays.copyOf(thetaVector, thetaVector.length);
    }

    public Double apply(Double[] featureVector) {
        // The first element must be set to 1.0 for computational purposes
        assert featureVector[0] == 1.0;

        // h(x) = theta0*1 + theta1*x1 + theta2*x2...
        double prediction = 0;
        for (int j = 0; j < thetaVector.length; j++) {
            prediction += thetaVector[j] * featureVector[j];
        }
        return prediction;
    }

    public double[] getThetas() {
        return Arrays.copyOf(thetaVector, thetaVector.length);
    }
}
