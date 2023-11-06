package it.unibo.exceptions;

import java.io.IOException;

public class NetworkException extends IOException {
    public NetworkException(){
        super("New network: no response");
    }

    public NetworkException(final String messageSent){
        super("Network error while sending message: " + messageSent);
    }
}
