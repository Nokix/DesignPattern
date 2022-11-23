package template_method.LetterCreator;

public class Customer {
    public String firstName;
    public String secondName;
    public String adress;
    public int money;

    public Customer(String firstName, String secondName, String adress, int money) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.adress = adress;
        this.money = money;
    }
}
