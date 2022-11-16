package model;

import java.util.List;

public class AbstactGame {

    private Game game;
    private List<Pass> passes;


    public AbstactGame(Game game, List<Pass> passes) {
        this.game = game;
        this.passes = passes;
    }

    public Game getGame() {
        return game;
    }

    public List<Pass> getPasses() {
        return passes;
    }

    @Override
    public String toString() {
        return "AbstactGame{" +
                "game=" + game +
                ", passes=" + passes +
                '}';
    }
}
