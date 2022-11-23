package FactoryMethod.records;

import java.util.Date;

public class AmazonRecord implements PointRecord {
    private final long amount;
    private final Date date;
    private final long points;

    public AmazonRecord(long amount, Date date, long points) {
        this.amount = amount;
        this.date = date;
        this.points = points;
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
    public long getPoints() {
        return this.points;
    }

    @Override
    public String toString() {
        return "AmazonRecord{" +
                "amount=" + amount +
                ", date=" + date +
                ", points=" + points +
                '}';
    }
}
