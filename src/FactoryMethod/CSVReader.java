package FactoryMethod;

import FactoryMethod.records.BankRecordFactory;
import FactoryMethod.records.Record;
import FactoryMethod.records.RecordFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
    private static final String SEPERATOR = ";";

    public static List<Record> readCSVFile(String file, RecordFactory recordFactory) {
        ArrayList<Record> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(SEPERATOR);
                Arrays.setAll(values, i -> values[i].replaceAll("\"", ""));
                Record record = recordFactory.createRecord(values);
                result.add(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        List<Record> records = readCSVFile("csvInput/bank.csv", new BankRecordFactory());
        records.forEach(System.out::println);
    }
}
