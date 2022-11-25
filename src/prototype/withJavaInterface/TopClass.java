package prototype.withJavaInterface;

public class TopClass implements Cloneable{
    private int x;
    private InnerClass innerClass;

    public TopClass(int x, InnerClass innerClass) {
        this.x = x;
        this.innerClass = innerClass;
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
        try {
            TopClass clone = (TopClass) super.clone();
            clone.innerClass = this.innerClass.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}