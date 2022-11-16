package model;

public class Player {

    private int number;
    private String name;
    private List<SuccessPass> passFail;
    private List<FailPass> passSucc;

    public Player(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPassFail(FailPass successFail){
        this.passFail.add(successFail);

    }

    public void addPassSucc(SuccessPass successPass){
        this.passSucc.add(successPass);
    }

    public double numPassSucc(){
        double cant=0;
        for (SuccessPass pass: passSucc) {
            cant += pass.getNumPasses();

        }
        return cant;
    }

    public double numPassFail(){
        double cant=0;
        for (FailPass pass: passFail) {
            cant += pass.getNumPasses();

        }
        return cant;
    }

    @Override
    public String toString() {
        return "Player{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
