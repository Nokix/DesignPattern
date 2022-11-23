package template_method;

import template_method.LetterCreator.AdvertisementLetterCreator;
import template_method.LetterCreator.Customer;
import template_method.LetterCreator.PayUsBackLetterCreator;

public class Demo {
    public static void main(String[] args) {
        Customer customerBad = new Customer("Viktor", "Reichert", "Lange Straße, Kiel", -100);
        Customer customerGood = new Customer("Franzi", "Fräulich", "Schickes Straße, Hamburg", 20);

        System.out.println("Letter 1:");
        System.out.println(new PayUsBackLetterCreator(customerBad).create());

        System.out.println("-----------------------");
        System.out.println("Letter 2:");
        System.out.println(new PayUsBackLetterCreator(customerGood).create());

        new AdvertisementLetterCreator("out/advertisementletter.txt").create();
    }
}
