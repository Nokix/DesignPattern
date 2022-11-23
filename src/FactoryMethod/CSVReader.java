package FactoryMethod;

import FactoryMethod.records.AmazonRecordFactory;
import FactoryMethod.records.Record;
import FactoryMethod.records.RecordFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private static final String COMMA_DELIMITER = ";";

    public static void main(String[] args) {
        List<Record> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("csvInput/amazon.csv"))) {
            br.readLine();
            br.readLine();
            RecordFactory recordFactory = new AmazonRecordFactory();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                Record record = recordFactory.createRecord(values);
                System.out.println(record);
                records.add(record);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
