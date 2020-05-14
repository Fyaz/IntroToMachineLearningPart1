package data.util;

import data.HouseRecords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Consumer;

/* Retrieves a Feature Vector from a file. It can either be set, or
* the file path can be passed into a function to get the file. */
public class HouseRecordsVector implements FeatureVector<HouseRecords> {

    /* There are three parameters for all the data in the HouseRecords class. */
    private int number_of_parameters = 3;

    /* The path to the file containing the House Record data. */
    public String path_to_file;

    /* The Scanner used to read from the file containing the House Record data. */
    private Scanner file_reader;

    /* This stores the most recent HouseRecords. */
    private HouseRecords current;

    // Constructors ============================================

    public HouseRecordsVector() throws FileNotFoundException {
        this("");
    }

    public HouseRecordsVector(String _path_to_file) throws FileNotFoundException {
        path_to_file = _path_to_file;
        openFile(path_to_file);
        current = null;
    }

    // FeatureVector Methods =======================================

    @Override
    public HouseRecords[] getData() {
        try {
            Scanner file = new Scanner(new File(path_to_file));
            List<HouseRecords> list = new LinkedList<HouseRecords>();
            while(file.hasNextDouble()) {
                list.add(readHouseRecords(file));
            }
            HouseRecords[] output = new HouseRecords[list.size()];
            return list.toArray(output);
        }
        catch(FileNotFoundException e) {
            System.out.println("(getData) File = " + path_to_file + "not found.");
            return null;
        }
    }

    @Override
    public HouseRecords getFeatureVector() {
        return current;
    }

    // Iterator Methods ============================================

    @Override
    public boolean hasNext() {
        return file_reader.hasNextDouble();
    }

    @Override
    public HouseRecords next() {
        return readHouseRecords(file_reader);
    }

    // Private Methods =============================================

    private void openFile(String path) throws FileNotFoundException {
        file_reader = new Scanner(new File(path));
    }

    private HouseRecords readHouseRecords(Scanner file) {
        HouseRecords output = new HouseRecords();
        for(int i = 0; i < number_of_parameters; i++) {
            if(file.hasNextDouble()) {
                output.house_size = file.nextDouble();
                output.number_of_rooms = file.nextDouble();
                output.age_of_house = file.nextDouble();
            }
        }
        return output;
    }

}
