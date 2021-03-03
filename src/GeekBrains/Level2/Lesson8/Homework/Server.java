package GeekBrains.Level2.Lesson7.Homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private ServerSocket server;
    private Socket socket;
    private final int PORT = 8189;
    private List<server.ClientHandler> clients;
    private AuthService authService;

    public Server() {
        clients = new CopyOnWriteArrayList<>();
        authService = new server.SimpleAuthService();

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");

            while (true) {
                socket = server.accept();
                System.out.println("Client connected");
                new server.ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcastMsg(server.ClientHandler clientHandler, String msg){
        String message = String.format("[ %s ]: %s", clientHandler.getNickname(), msg);
        for (server.ClientHandler c : clients) {
            c.sendMsg(message);
        }
    }

    public void broadcastPrivateMsg(server.ClientHandler clientHandler, String msg, String nickname){
        String message = String.format("[ %s ]: %s", clientHandler.getNickname(), msg);
        for (server.ClientHandler c : clients) {
            if(c.getNickname().equals(nickname) || c.getNickname().equals(clientHandler.getNickname())) {
                c.sendMsg(message);
            }
        }
    }

    void subscribe(server.ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    void unsubscribe(server.ClientHandler clientHandler){
        clients.remove(clientHandler);
    }

    public AuthService getAuthService() {
        return authService;
    }
}
