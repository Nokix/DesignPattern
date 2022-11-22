package State.Tamagotschi;

public class DeadState implements State{
    @Override
    public String makeDance() {
        return "(x _ x)";
    }

    @Override
    public String feed() {
        return "(x _ x)  <*)))<";
    }

    @Override
    public String getState() {
        return "(x _ x)";
    }

}
