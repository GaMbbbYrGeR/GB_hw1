package GeekBrains.Level2.Lesson6.Homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static Thread input;
    private static Thread output;
    static final int PORT = 8189;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started");

            try (Socket socket = server.accept()) {
                System.out.println("Client connected");

                input = inputThread(socket);
                output = outputThread(socket);

                try {
                    input.start();
                    output.start();
                    input.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Thread inputThread(Socket socket) {
        return new Thread(() -> {
            try {
                Scanner sc = new Scanner(socket.getInputStream());
                while (true) {
                    String str = sc.nextLine();

                    if (str.equals("/end")) {
                        System.out.println("client disconnected");
                        break;
                    }

                    System.out.println("Client: " + str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static Thread outputThread(Socket socket) {
        return new Thread(() -> {
            try {
                Scanner sc = new Scanner(System.in);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    String msg = sc.nextLine();
                    out.println(msg);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }

}