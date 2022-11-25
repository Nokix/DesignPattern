package Visitor.records;

import Visitor.exporter.Exportable;
import Visitor.exporter.Exporter;

import java.util.Date;

public class BankRecord implements Record, Exportable {

    private final long amount;
    private final Date date;

    public BankRecord(long amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    @Override
    public long getAmount() {
        return this.amount;
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return "BankRecord{" +
                "amount=" + amount +
                ", date=" + date +
                '}';
    }

    @Override
    public String export(Exporter exporter) {
        return exporter.exportBankRecord(this);
    }
}
