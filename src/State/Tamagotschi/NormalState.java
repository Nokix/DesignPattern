package State.Tamagotschi;

public class NormalState implements State{
    private Tamagotchi tamagotchi;


    public NormalState(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    @Override
    public String makeDance() {
        tamagotchi.changeEnergy(-1);
        if(tamagotchi.getEnergy() < 3) tamagotchi.setState(new HungryState(tamagotchi));
        return "~(^ _^ ~)";
    }

    @Override
    public String feed() {
        return "(^_^ ) no  <*)))<";
    }

    @Override
    public String getState() {
        return "( ^_^ )";
    }
}
