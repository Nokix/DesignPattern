package FactoryMethod.records;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AmazonRecordFactory implements RecordFactory{
    @Override
    public AmazonRecord createRecord(String[] values) {
        String pointsString = values[9].replaceFirst(",", "").replaceAll("\"", "");
        long points = pointsString.isBlank() ? 0L : Long.parseLong(pointsString);
        
        String valueString = values[8].replaceFirst(",", "").replaceAll("\"", "");
        long amount = valueString.isBlank() ?  0L: Long.parseLong(valueString);
        
        Date date;
        try {
            date = new SimpleDateFormat("dd.MM.yyyy").parse(values[1].replaceAll("\"", ""));
        } catch (ParseException e) {
            date = null;
        }
        
        return new AmazonRecord(amount, date, points);
    }
}
