package prototype.withJavaInterface;

import prototype.withOwnInterface.Prototype;

public class InnerClass implements Prototype {
    private int y;
    private String str;

    public InnerClass(int y, String str) {
        this.y = y;
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "InnerClass{" +
                "y=" + y +
                ", str='" + str + '\'' +
                '}';
    }

    @Override
    public InnerClass clone() {
        try {
            InnerClass clone = (InnerClass) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
