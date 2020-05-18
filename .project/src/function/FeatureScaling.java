package function;

import java.util.List;
import java.util.function.Function;

public class FeatureScaling {

    /** The dataset is a list of feature vectors that look like:
     * {1.0, feature1, feature2, feature3... }*/
    public Function<Double[], Double> createFunction(List<Double[]> dataset) {
        Double min = Double.MAX_VALUE;
        Double max = Double.MIN_VALUE;
        Double sum = 0.0;

        for(int i = 0; i < dataset.size(); i++) {
        }
        return null;
    }
}
