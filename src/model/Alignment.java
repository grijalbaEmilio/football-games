package model;

import Exceptions.PlayerNotInAlignment;

import java.util.Arrays;
import java.util.List;

public class Alignment {

    private List<Player> players;

    public Alignment(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean constainsPlayer(int number){
        for (Player player: players) {
            if(player.getNumber() == number) return true;
        }

        return false;
    }

    public Player findByNumber(int number) throws PlayerNotInAlignment {
        List<Player> findPlayer = players.stream()
                .filter(x -> x.getNumber() == number)
                .toList();

        if (findPlayer.isEmpty()) throw new PlayerNotInAlignment("payer with number "+number+" not aligned for the game");;

        return  findPlayer.get(0);

    }

    public void addPlayers(Player... players){
        this.players.addAll(Arrays.asList(players));
    }

    public void deletePlayer(Player player){
        this.players.remove(player);
    }


    @Override
    public String toString() {
        return "Alignment{" +
                "players=" + players +
                '}';
    }
}
