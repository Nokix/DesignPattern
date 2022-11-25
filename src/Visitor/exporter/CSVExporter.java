package Visitor.exporter;

import Visitor.records.AmazonRecord;
import Visitor.records.BankRecord;

import java.text.SimpleDateFormat;

public class CSVExporter implements Exporter {
    private final String seperator;

    public CSVExporter() {
        this.seperator = ";";
    }

    public CSVExporter(String seperator) {
        this.seperator = seperator;
    }

    @Override
    public String exportBankRecord(BankRecord record) {
        String date = new SimpleDateFormat("dd.MM.yyyy").format(record.getDate());
        return date + seperator + record.getAmount();
    }

    @Override
    public String exportAmazonRecord(AmazonRecord record) {
        String date = new SimpleDateFormat("dd.MM.yyyy").format(record.getDate());
        return date + seperator + record.getAmount() + seperator + record.getPoints();
    }

    @Override
    public String documentStart() {
        return "Datum"+seperator+"Betrag"+seperator+"Punkte"+"\n";
    }
}
