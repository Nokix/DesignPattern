package template_method.LetterCreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AdvertisementLetterCreator extends LetterCreator<File> {
    String fileAdress;

    public AdvertisementLetterCreator(String fileAdress) {
        this.fileAdress = fileAdress;
    }

    @Override
    String setHeader() {
        return "You want belive our cheap Prices";
    }

    @Override
    String setAdress() {
        return "To the inhibitance of this lovely Household";
    }

    @Override
    String setText() {
        return "We have a lot of stuff, you should buy from us!";
    }

    @Override
    File saveToMedium(Letter letter) {
        File file = new File(fileAdress);
        try (FileWriter fw = new FileWriter(file,false)){
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(letter.address);
            bw.newLine();
            bw.newLine();
            bw.write(letter.header);
            bw.newLine();
            bw.newLine();
            bw.write(letter.text);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return file;
    }
}
