package prototype.withOwnInterface;

public class InnerClass implements Prototype{
    private int y;
    private String str;

    public InnerClass(InnerClass org){
        this.y = org.y;
        this.str = org.str;
    }

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
        return new InnerClass(this);
    }
}
