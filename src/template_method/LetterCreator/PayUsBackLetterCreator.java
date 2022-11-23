package template_method.LetterCreator;

public class PayUsBackLetterCreator extends LetterCreator<String>{
    Customer customer;

    public PayUsBackLetterCreator(Customer customer) {
        this.customer = customer;
    }

    @Override
    boolean checkLetterNecessity() {
        return customer.money < 0;
    }

    @Override
    String setHeader() {
        return "We want our money, NOW!";
    }

    @Override
    String setAdress() {
        return customer.adress;
    }

    @Override
    String setText() {
        return "This is our last warning " + customer.firstName + " " + customer.secondName + ".\n" +
                "You owe us " + (-customer.money) + ".\n" +
                "We know where your house lives.";
    }

    @Override
    String saveToMedium(Letter letter) {
        return letter.address + "\n\n" + letter.header + "\n\n" + letter.text;
    }
}
