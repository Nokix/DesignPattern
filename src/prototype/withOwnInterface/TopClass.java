package prototype.withOwnInterface;

public class TopClass implements Prototype{
    private int x;
    private InnerClass innerClass;

    public TopClass(int x, InnerClass innerClass) {
        this.x = x;
        this.innerClass = innerClass;
    }

    public TopClass(TopClass org) {
        this.x = org.x;
        this.innerClass = org.innerClass.clone();
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public InnerClass getInnerClass() {
        return innerClass;
    }

    public void setInnerClass(InnerClass innerClass) {
        this.innerClass = innerClass;
    }

    @Override
    public String toString() {
        return "TopClass{" +
                "x=" + x +
                ", innerClass=" + innerClass +
                '}';
    }

    @Override
    public TopClass clone() {
        return new TopClass(this);
    }
}
