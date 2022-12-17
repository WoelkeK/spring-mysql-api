package pl.woelke.springmysqlserver.util;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ClientHandler extends Thread {

    private static final Logger LOGGER = Logger.getLogger(ClientHandler.class.getName());

    private ArrayList<ClientHandler> clients;
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private Message message;

    public ClientHandler(ArrayList<ClientHandler> clients, Socket socket, ObjectInputStream inputStream, ObjectOutputStream outputStream) {

        this.clients = clients;
        this.socket = socket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        LOGGER.info("run()");

        try {
            while (true) {

                message = (Message) inputStream.readObject();
                LOGGER.info("readObject()" + message.getMessage());
                if (message.getMessage().equalsIgnoreCase("exit")) {
                    break;
                }
                LOGGER.info("Klient :" + clients + "Błąd : " + message.getFailCode() + message.getMessage());
            }
        } catch (EOFException eofe) {
            LOGGER.info("End of message data reached ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                inputStream.close();
                outputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
