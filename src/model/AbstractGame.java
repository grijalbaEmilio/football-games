package model;

import Exceptions.PlayerNotInAlignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractGame {

    private Game game;
    private List<Pass> passes;


    public AbstractGame(Game game, List<Pass> passes) {
        this.game = game;
        this.passes = passes;
    }

    public Game getGame() {
        return game;
    }

    public List<Pass> getPasses() {
        return passes;
    }

    public List<Map<String, Object>> calcEffectPassAllPlayers() throws PlayerNotInAlignment {

        List<Map<String, Object>> effectPassPlayers = new ArrayList<>();
        List<Integer> numberPassers = getNumPassers();
        for (Integer numberPasser: numberPassers) {
            Map<String, Object> dataPasser = new HashMap<>();
            dataPasser.put("indexPass", calcEffectPassPlayer(numberPasser));
            dataPasser.put("name", game.namePlayerPlayed(numberPasser));
            dataPasser.put("number", numberPasser);
            effectPassPlayers.add(dataPasser);
        }

        return effectPassPlayers;
    }
    public double calcEffectPassPlayer(int numPlayer) {

        int successPass = 0;
        int failPass = 0;

        for (Pass pass: passes) {
            if(!pass.constainsPasser(numPlayer)) continue;

            if(pass instanceof SuccessPass){
                successPass += pass.getNumPasses();
            }
            if(pass instanceof  FailPass) {
                failPass += pass.getNumPasses();
            }

        }

        return  (double) (successPass - failPass) / (successPass + failPass);

    }

    public List<Integer> getNumPassers(){

        List<Integer> passersList = new ArrayList<>();

        for (Pass pass: passes) {
            passersList.add(pass.getPasserNumber());
        }

        return passersList.stream().distinct().toList();
    }

    @Override
    public String toString() {
        return "AbstractGame{" +
                "game=" + game +
                ", passes=" + passes +
                '}';
    }
}
