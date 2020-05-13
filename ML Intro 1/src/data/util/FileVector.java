package data.util;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* Retrieves a Feature Vector from a file. It can either be set, or
* the file path can be passed into a function to get the file. */
public class FileVector<T> implements FeatureVector<T> {

    public String path_to_file;

    // Constructors ============================================

    public FileVector() {
        path_to_file = "";
    }

    public FileVector(String _path_to_file) {
        path_to_file = _path_to_file;
    }

    // FeatureVector Methods =======================================

    @Override
    public FeatureVector<T>[] getData() {
        return null;
    }

    @Override
    public T getFeatureVector() {
        return null;
    }

    // Iterator Methods ============================================

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

}
