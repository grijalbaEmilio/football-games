package model;

import loadFile.FileManager;

public class SummaryGame {

    public void calIndex(Alignment alignment,String path){

        List<Player> players = alignment.getPlayers();
        double index = 0;
        String datos = "";

        for (Player player:players) {

            index = (player.numPassSucc()-player.numPassFail())/(player.numPassSucc()+player.numPassFail());
            String.valueOf(price);
            datos += datos+player.getName()+player.getNumber()+String.valueOf(index)+\n;
        }
        FileManager file = new FileManager();
        file.writeFile(datos,path);

    }

}
