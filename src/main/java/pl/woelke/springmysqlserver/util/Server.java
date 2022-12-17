package pl.woelke.springmysqlserver.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Server {

    private static final Logger LOGGER = Logger.getLogger(Server.class.getName());
    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static final int PORT = 14001;

    public void connect() throws IOException {
        LOGGER.info("Socket server ready for clients...");
        ServerSocket ss = new ServerSocket(PORT);

        while (true) {
            Socket socket = null;

            try {
                socket = ss.accept();
                LOGGER.info("A new Client is connected : " + socket);

                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

                LOGGER.info("Assigning new thread for this client");
                ClientHandler clientThread = new ClientHandler(clients, socket, inputStream, outputStream);
                clients.add(clientThread);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
