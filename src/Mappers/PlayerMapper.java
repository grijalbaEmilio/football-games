package Mappers;

import model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerMapper {

    public List<Player> createPlayes(List<String> playersString){

        List<Player> players = new ArrayList<>();

        for (String playerString: playersString) {
            String[] playerArray = playerString.split(",");

            int number = Integer.parseInt(playerArray[0]);
            String name = playerArray[1];

            players.add(new Player(number, name));
        }

        return players;
    }

    public List<String> createPlayesString(List<Player> players){

        List<String> playersString = new ArrayList<>();

        for (Player player: players){
            String playerString = player.getNumber()+","+player.getName();
            playersString.add(playerString);
        }

        return playersString;
    }
}
