package strategy;

import java.util.Date;

public class Response {
    Date time;
    String text;

    public Response(Date time, String text) {
        this.time = time;
        this.text = text;
        if (text == null || text.trim().equals("")) {
            throw new IllegalArgumentException("No empty logging allowed!");
        }
    }

    @Override
    public String toString() {
        return time + ": " + text + '\n';
    }
}
