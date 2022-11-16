package model;

public class Pass {

    private Player passer;
    private  Player receiver;
    private  int numPasses;

    public Pass(Player passer, Player receiver, int numPasses) {
        this.passer = passer;
        this.receiver = receiver;
        this.numPasses = numPasses;
    }

    public Player getPasser() {
        return passer;
    }

    public void setPasser(Player passer) {
        this.passer = passer;
    }

    public Player getReceiver() {
        return receiver;
    }

    public int getNumPasses() {
        return numPasses;
    }

    public void setNumPasses(int numPasses) {
        this.numPasses = numPasses;
    }

    public void setReceiver(Player receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Pass{" +
                "passer=" + passer +
                ", receiver=" + receiver +
                ", numPasses=" + numPasses +
                '}';
    }
}
