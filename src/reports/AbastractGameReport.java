package reports;

import Exceptions.PlayerNotInAlignment;
import loadFile.FileManager;
import model.AbstractGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbastractGameReport {

    public void generateReportIndexPassGame(AbstractGame abstractGame)  {
        try {
            List<Map<String, Object>> indexPassAllPlayers = abstractGame.calcEffectPassAllPlayers();
            List<String> indexPassPlayersString =  new ArrayList<>();
            indexPassPlayersString.add("INDICE PASES EN PARTIDO CONTRA: "+abstractGame.getGame().getRivalTeam());
            indexPassPlayersString.addAll(generateStringReport((indexPassAllPlayers)));


            new FileManager().writeFile(indexPassPlayersString, "src/reportFiles/indicePases.dat");
        } catch (PlayerNotInAlignment e) {
            throw new RuntimeException(e);
        }catch (IOException e){

        }
    }

    private List<String> generateStringReport(List<Map<String, Object>> indexPassAllPlayers){
        return indexPassAllPlayers.stream().map(x ->{
            int number = (int)x.get("number");
            String name = (String) x.get("name");
            double index = (double) x.get("indexPass");

            return number+", "+name+", "+index;
        }).toList();
    }

    public void addIregularityReport(String irregularity){
        try {
            new FileManager().writeOneLine(irregularity, "src/reportFiles/irregularities.dat");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
