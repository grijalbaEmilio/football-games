package Mappers;

import model.Alignment;
import model.Game;

import java.time.LocalDateTime;
import java.util.List;

public class GameMapper {

    public Game createGame(List<String> gameString, Alignment alignment){
        String[] gameArray = gameString.get(0).split(",");

        String dateString = gameArray[0];
        String timeString = gameArray[1];
        String city = gameArray[2];
        String rival = gameArray[3];

        LocalDateTime time = LocalDateTime.parse(dateString + "T" + timeString);
        return new Game(alignment, time, city, rival);

    }

    public Game createGame(String gameString, Alignment alignment){
        String[] gameArray = gameString.split(",");

        String dateString = gameArray[0];
        String timeString = gameArray[1];
        String city = gameArray[2];
        String rival = gameArray[3];

        LocalDateTime time = LocalDateTime.parse(dateString + "T" + timeString);
        return new Game(alignment, time, city, rival);

    }
}
