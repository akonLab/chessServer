package chat;

import com.company.models.Message;

import javax.servlet.http.Part;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat extends Thread {
    private static Socket clientSocket;
    private static ServerSocket server;
    private String chatServer = "92.49.213.97";

    private static ObjectInputStream in;
    private static ObjectOutputStream out;

    boolean runCon = false;

    public ServerChat() {
        if (!runCon) {
            start();
            runCon=true;
        }
    }

    @Override
    public void run() {
        try {
            server = new ServerSocket(12345);
            System.out.println("Сервер запущен!");

            clientSocket = server.accept();
            // accept() будет ждать пока кто-нибудь не захочет подключиться

            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
            // теперь мы можем принимать сообщения и отправлять

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Message serverGet() {
        try {
            return (Message) in.readObject();
            // ждём пока клиент что-нибудь нам напишет

        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void serverSend(String text, Part fie, String date) {
        try {
            out.writeObject(new Message("server", text, fie, date));
            out.flush();
            // выталкиваем все из буфера
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            clientSocket.close();
            in.close();
            out.close();
            System.out.println("Сервер закрыт!");
            server.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}