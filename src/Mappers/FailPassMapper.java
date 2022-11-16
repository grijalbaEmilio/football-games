package Mappers;

import Exceptions.PlayerNotInAlignment;
import model.Alignment;
import model.FailPass;
import model.Player;

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

           return new FailPass(passer, receiver, numberPasses);

        }).toList();



    }
}
