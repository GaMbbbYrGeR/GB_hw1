package GeekBrains.Level2.Lesson6.Homework;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Socket socket;
    private static String ip = "localhost";
    private static int port = 8189;
    private static Thread output;
    private static Thread input;

    public static void main(String[] args) {
        try {
            socket = new Socket(ip, port);

            input = inputThread(socket);
            output = outputThread(socket);

            try {
                input.start();
                output.start();
                input.join();
                output.join();
            } catch (InterruptedException e) {
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
                    String msg = sc.nextLine();
                    System.out.println("Server: " + msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static Thread outputThread(Socket socket) {
        return new Thread(() -> {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner sc = new Scanner(System.in);
                while (true) {
                    String msg = sc.nextLine();
                    System.out.println("You: " + msg);
                    out.println(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        );
    }
}
