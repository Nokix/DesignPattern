package template_method.LetterCreator;

public abstract class LetterCreator<M> {

    public M create() {
        if (checkLetterNecessity()) {
            Letter letter = new Letter(setAdress(), setHeader(), setText());
            // send letter copy to Database
            return saveToMedium(letter);
        }
        return returnWhenFail();
    }

    boolean checkLetterNecessity() {
        return true;
    }

    M returnWhenFail() {
        return null;
    }

    abstract String setHeader();

    abstract String setAdress();

    abstract String setText();

    abstract M saveToMedium(Letter letter);
}
