package FactoryMethod.records;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankRecordFactory implements RecordFactory {
    @Override
    public BankRecord createRecord(String[] values) {
        long amount = Long.parseLong(values[8].replaceFirst(",",""));
        Date date;
        try {
            date = new SimpleDateFormat("dd.MM.yyyy").parse(values[1]);
        } catch (ParseException e) {
            date = null;
        }
        return new BankRecord(amount, date);
    }
}
