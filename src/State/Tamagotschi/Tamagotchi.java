package State.Tamagotschi;

public class Tamagotchi {
    private State state = new NormalState(this);
    private int energy = 3;

    public void setState(State newState) {
        this.state = newState;
    }

    public String makeDance() {
        return state.makeDance();
    }

    public String feed() {
        return state.feed();
    }

    int getEnergy() {
        return energy;
    }

    void changeEnergy(int energyDelta) {
        this.energy += energyDelta;
    }

    public String getState() {
        return this.state.getState();
    }
}
