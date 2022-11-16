package Mappers;

import Exceptions.PlayerNotInAlignment;
import model.Alignment;
import model.FailPass;
import model.Player;
import model.SuccessPass;

import java.util.List;

public class FailPassMapper {

    public List<FailPass> createPasses(List<String> passesString, Alignment alignment) {

        return passesString.stream().map(x -> {
            String[] passArray = x.split(",");

            int passerNumber = Integer.parseInt(passArray[0]);
            int receiverNumber = Integer.parseInt(passArray[1]);
            int numberPasses = Integer.parseInt(passArray[2]);

            Player passer = alignment.findByNumber(passerNumber);
            Player receiver = alignment.findByNumber(receiverNumber);

            FailPass pass = new FailPass(passer, receiver, numberPasses);
            passer.addPassFail(pass);

           return pass;

        }).toList();



    }
}
