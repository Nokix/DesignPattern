package FactoryMethod.records;

import java.util.Date;

public class BankRecordFactory implements RecordFactory {
    @Override
    public BankRecord createRecord(String[] values) {
        long amount = getAmount(values[8]);
        Date date = getDate(values[1]);
        return new BankRecord(amount, date);
    }
}
