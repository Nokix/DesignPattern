package Visitor;

import Visitor.exporter.CSVExporter;
import Visitor.exporter.Exportable;
import Visitor.exporter.XMLExporter;
import Visitor.records.AmazonRecord;
import Visitor.records.BankRecord;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Exportable> records = new ArrayList<>();
        records.add(new AmazonRecord(30, new Date(100000), 10));
        records.add(new AmazonRecord(60, new Date(200000), 20));
        records.add(new BankRecord(65, new Date(300000)));
        records.add(new BankRecord(55, new Date(400000)));

        XMLExporter xmlExporter = new XMLExporter();
        xmlExporter.export(new File("out/records.xml"), records);

        CSVExporter csvExporter = new CSVExporter();
        csvExporter.export(new File("out/record.csv"), records);


    }
}
