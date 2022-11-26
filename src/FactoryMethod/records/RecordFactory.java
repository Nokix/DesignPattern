package FactoryMethod.records;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface RecordFactory {
    Record createRecord(String[] values);

    default Date getDate(String value) {
        Date date;
        try {
            date = new SimpleDateFormat("dd.MM.yyyy").parse(value);
        } catch (ParseException e) {
            date = null;
        }
        return date;
    }

    default long getAmount(String value) {
        String valueString = value.replaceFirst(",", "");
        return valueString.isBlank() ? 0L : Long.parseLong(valueString);
    }

}
