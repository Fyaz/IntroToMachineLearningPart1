package data.util;

import java.util.Iterator;

public interface FeatureVector<T> extends Iterator<T> {

    /* Returns the full matrix of Feature Vectors.
     * AKA. The entire data set. */
    T[] getData();

    /* Return the values of the features given. */
    T getFeatureVector();

}
