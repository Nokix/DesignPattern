package strategy;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;

public class Logger {

    String fileName;
    ResponseHandler responseHandler = (r,e) -> {};

    public void setResponseHandler(ResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }

    public Logger(String fileName, boolean resetFile, ResponseHandler responseHandler) throws IOException {
        this.fileName = fileName;
        if (responseHandler != null) this.responseHandler = responseHandler;
        if (resetFile) new FileWriter(fileName).close();
    }

    public void log(String s) {
        log(s, this.responseHandler);
    }

    public void log(String s, ResponseHandler handler) {
        Exception e = null;
        Response r = null;
        try (FileWriter writer = new FileWriter(fileName, true)){
            r = new Response(Date.from(Instant.now()), s);
            writer.write(r.toString());
        } catch (IOException | IllegalArgumentException ex) {
            r = null;
            e = ex;
        } finally {
            handler.handle(r, e);
        }
    }


    public static void main(String[] args) throws IOException{

        Logger logger = new Logger("out/filename.txt", true, null);

        ResponseHandler responseHandler = (response, e) -> {
            if (e != null) System.out.println(e.getMessage());
        };
        logger.setResponseHandler(responseHandler);
        logger.log("hi");
        logger.log("");
        logger.log("how are you?");

        ResponseHandler responseHandler2 = (response, e) -> {
            if (e != null) System.out.println(e.getMessage());
            else System.out.println("Logging successfull!");
        };
        logger.setResponseHandler(responseHandler2);

        logger.log(null);
        logger.log("who are you?");
        logger.log("  ");
    }
}
