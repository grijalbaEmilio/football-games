package Mappers;

import Exceptions.PlayerNotInAlignment;
import model.Alignment;
import model.FailPass;
import model.Player;
import model.SuccessPass;
import reports.AbastractGameReport;


import java.util.ArrayList;
import java.util.List;

public class SuccessPassMapper {

    public List<SuccessPass> createPasses(List<String> passesString, Alignment alignment) {

        List<SuccessPass> successPasses = new ArrayList<>();

        for (String x : passesString) {
            String[] passArray = x.split(",");

            int passerNumber = Integer.parseInt(passArray[0]);
            int receiverNumber = Integer.parseInt(passArray[1]);
            int numberPasses = Integer.parseInt(passArray[2]);


            Player passer = null;
            Player receiver = null;

            try {
                passer = alignment.findByNumber(passerNumber);
                receiver = alignment.findByNumber(receiverNumber);
                successPasses.add(new SuccessPass(passer, receiver, numberPasses));
            } catch (PlayerNotInAlignment e) {
                new AbastractGameReport().addIregularityReport(e.getMessage());
            }
        }

        return successPasses;
    }
}