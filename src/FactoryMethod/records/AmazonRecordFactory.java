package FactoryMethod.records;

import java.util.Date;

public class AmazonRecordFactory implements RecordFactory {
    @Override
    public AmazonRecord createRecord(String[] values) {
        long points = getAmount(values[9]);
        long amount = getAmount(values[8]);

        Date date = getDate(values[1]);

        return new AmazonRecord(amount, date, points);
    }

}
