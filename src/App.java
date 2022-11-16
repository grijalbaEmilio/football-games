import Mappers.FailPassMapper;
import Mappers.GameMapper;
import Mappers.PlayerMapper;
import Mappers.SuccessPassMapper;
import loadFile.FileManager;
import model.*;
import reports.AbastractGameReport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        FileManager manager = new FileManager();
        PlayerMapper mapper = new PlayerMapper();
        SuccessPassMapper mapperPass = new SuccessPassMapper();
        FailPassMapper mapperFailPass = new FailPassMapper();
        GameMapper mapperGame = new GameMapper();
        AbastractGameReport report = new AbastractGameReport();

        try {
            List<String> playersListString = manager.readFileLineByLine("src/initialFiles/alineacionP01.dat");
            List<Player> players = mapper.createPlayes(playersListString);

            Alignment alignment = new Alignment(players);

            List<String> passString = manager.readFileLineByLine("src/initialFiles/PasesExitososP01.dat");
            List<SuccessPass> successPasses = mapperPass.createPasses(passString, alignment);

            List<String> passFailString = manager.readFileLineByLine("src/initialFiles/PasesErradosP01.dat");
            List<FailPass> failPasses = mapperFailPass.createPasses(passFailString, alignment);

            String gameString = manager.readFile("src/initialFiles/partidoP01.dat");
            Game game = mapperGame.createGame(gameString, alignment);

            List<Pass> passes = new ArrayList<>();
            passes.addAll(successPasses);
            passes.addAll(failPasses);
            AbstractGame abstactGame = new AbstractGame(game, passes);


            report.generateReportIndexPassGame(abstactGame);

        } catch (IOException e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }

    }
}
