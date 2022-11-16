package Mappers;

import model.Alignment;
import model.Player;
import model.SuccessPass;


import java.util.List;

public class SuccessPassMapper {

    public List<SuccessPass> createPasses(List<String> passesString, Alignment alignment){

        return passesString.stream().map(x -> {
            String[] passArray = x.split(",");

            int passerNumber = Integer.parseInt(passArray[0]);
            int receiverNumber = Integer.parseInt(passArray[1]);
            int numberPasses = Integer.parseInt(passArray[2]);

            Player passer = alignment.findByNumber(passerNumber);
            Player receiver = alignment.findByNumber(receiverNumber);

            SuccessPass pass = new SuccessPass(passer, receiver, numberPasses);

            passer.addPassSucc(pass);

           return pass;

        }).toList();
    }
}
