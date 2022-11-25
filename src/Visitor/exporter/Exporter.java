package Visitor.exporter;

import Visitor.records.AmazonRecord;
import Visitor.records.BankRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public interface Exporter {
    default void export(File file, Iterable<Exportable> records) {
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.write(documentStart());
            for (Exportable record : records) {
                pw.write(record.export(this));
                pw.println();
            }
            pw.write(documentEnd());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    default String documentEnd() {
        return "";
    }

    default String documentStart() {
        return "";
    }

    String exportBankRecord(BankRecord record);

    String exportAmazonRecord(AmazonRecord record);

}
