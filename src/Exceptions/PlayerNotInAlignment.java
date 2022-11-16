package Exceptions;

import java.io.IOException;

public class PlayerNotInAlignment extends IOException {

    public PlayerNotInAlignment(String message){
        super("Player not in alignment: "+message);
    }
}
