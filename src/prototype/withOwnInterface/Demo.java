package prototype.withOwnInterface;

public class Demo {
    public static void main(String[] args) {
        InnerClass innen = new InnerClass(3, "innen");
        TopClass topClass = new TopClass(4, innen);
        TopClass topClassCopy = topClass.clone();
        topClassCopy.getInnerClass().setY(10);
        topClassCopy.getInnerClass().setStr("neuer String");
        System.out.println(topClass);
        System.out.println(topClassCopy);
    }
}
