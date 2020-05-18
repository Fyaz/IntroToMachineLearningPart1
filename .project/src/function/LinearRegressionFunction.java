package function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class LinearRegressionFunction implements Function<Double[], Double> {
    private final double[] thetaVector;

    public LinearRegressionFunction(double[] thetaVector) {
        this.thetaVector = Arrays.copyOf(thetaVector, thetaVector.length);
    }

    /* NOTE: the first element of the feature vector (featureVector[0]) must be 1.0 for computational reasons. */
    public Double apply(Double[] featureVector) {
        double output = 0.0;
        if(featureVector != null && featureVector.length > 0 && featureVector[0] == 1.0) {
            for(int i = 0; i < featureVector.length; i++) {
                output += thetaVector[i]*featureVector[i];
            }
        }
        return output;
    }

    public double[] getThetas() {
        return Arrays.copyOf(thetaVector, thetaVector.length);
    }

    /** Calculate the cost of the function using sum squared mean.  */
    public static double cost(Function<Double[], Double> target, List<Double[]> dataset, List<Double> labels) {
        int m = dataset.size();
        double sum_squared_error = 0;

        for(int i = 0; i < m; i++) {
            double predicted = target.apply(dataset.get(i));
            double gap = predicted - labels.get(i);  // The difference between the actual and predicted value
            sum_squared_error += Math.pow(gap, 2);
        }

        return (1.0/(2*m)) * sum_squared_error;
    }

    /** Use Gradient descent to minimize the cost function and train the theta values. */
    public static LinearRegressionFunction train(LinearRegressionFunction target, List<Double[]> dataset, List<Double> labels, double alpha) {
        int m = dataset.size();
        double[] old_theta_vector = target.getThetas();
        double[] new_theta_vector = new double[old_theta_vector.length];

        // summation(h(x) - y)(x[i])
        for(int i = 0; i < new_theta_vector.length; i++) {
            double sum_errors = 0;
            for(int j = 0; j < m; j++) {
                double error = target.apply(dataset.get(j)) - labels.get(j);
                sum_errors += error * dataset.get(j)[i];
            }

            double gradient = (1.0/m) * sum_errors;
            new_theta_vector[i] = old_theta_vector[i] - alpha * gradient;
        }

        return new LinearRegressionFunction(new_theta_vector);
    }
}
