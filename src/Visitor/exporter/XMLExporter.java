package Visitor.exporter;

import Visitor.records.AmazonRecord;
import Visitor.records.BankRecord;

import java.text.SimpleDateFormat;

public class XMLExporter implements Exporter {
    private final static String INLINE = "   ";

    @Override
    public String exportBankRecord(BankRecord record) {
        String date = new SimpleDateFormat("dd.MM.yyyy").format(record.getDate());

        return "<record type=\"bank\">\n"
                + INLINE + "<amount>" + record.getAmount() + "</amount>\n"
                + INLINE + "<date>" + date + "</date>\n"
                + "</record>";
    }

    @Override
    public String exportAmazonRecord(AmazonRecord record) {
        String date = new SimpleDateFormat("dd.MM.yyyy").format(record.getDate());

        return "<record type=\"amazon\">\n"
                + INLINE + "<amount>" + record.getAmount() + "</amount>\n"
                + INLINE + "<date>" + date + "</date>\n"
                + INLINE + "<points>" + record.getPoints() + "</points>\n"
                + "</record>";
    }

    @Override
    public String documentStart() {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n"
                + "<records>" + "\n";
    }

    @Override
    public String documentEnd() {
        return "</records>";
    }
}
