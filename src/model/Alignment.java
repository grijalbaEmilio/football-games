package model;

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

    public Player findByNumber(int number){
        List<Player> findPlayer = players.stream()
                .filter(x -> x.getNumber() == number)
                .toList();

        if (findPlayer.isEmpty()) return null;

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
