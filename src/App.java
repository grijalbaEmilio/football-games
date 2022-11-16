import Mappers.GameMapper;
import Mappers.PlayerMapper;
import Mappers.SuccessPassMapper;
import loadFile.FileManager;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        FileManager manager = new FileManager();
        PlayerMapper mapper = new PlayerMapper();
        SuccessPassMapper mapperPass = new SuccessPassMapper();
        GameMapper mapperGame = new GameMapper();

        try {
            List<String> playersListString = manager.readFileLineByLine("src/initialFiles/alineacionP01.dat");
            List<Player> players = mapper.createPlayes(playersListString);

            Alignment alignment = new Alignment(players);

            List<String> passString = manager.readFileLineByLine("src/initialFiles/PasesExitososP01.dat");
            List<SuccessPass> successPasses = mapperPass.createPasses(passString, alignment);

            List<String> passFailString = manager.readFileLineByLine("src/initialFiles/PasesErradosP01.dat");
            List<SuccessPass> failPasses = mapperPass.createPasses(passString, alignment);

            String gameString = manager.readFile("src/initialFiles/partidoP01.dat");
            Game game = mapperGame.createGame(gameString, alignment);

            List<Pass> passes = new ArrayList<>();
            passes.addAll(successPasses);
            passes.addAll(failPasses);
            AbstactGame abstactGame = new AbstactGame(game, passes);


            System.out.println(abstactGame);

        } catch (IOException e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }

    }
}
