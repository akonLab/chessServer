package chat;

import com.company.models.Message;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientChat extends Thread {
    private static Socket clientSocket;
    private static String chatServer = "92.49.213.97";

    private static ObjectInputStream in;
    private static ObjectOutputStream out;

    @Override
    public void run() {
        try {
                clientSocket = new Socket(InetAddress.getByName(chatServer), 12345);
                // этой строкой мы запрашиваем у сервера доступ на соединение

                out = new ObjectOutputStream(clientSocket.getOutputStream());
                in = new ObjectInputStream(clientSocket.getInputStream());
                // теперь мы можем принимать сообщения и отправлять

                System.out.println("you was connected to server");

        } catch (IOException e) {
            closeConnection();
            e.printStackTrace();
        }
    }

    public Message clientGet() {
        try {
            return (Message) in.readObject();
            // ждём пока клиент что-нибудь нам напишет

        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void clientSend(String text, Part fie, String date) {
        try {
            out.writeObject(new Message("client", text, fie, date));
            out.flush();
            // выталкиваем все из буфера
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    void closeConnection() {
        try {
            System.out.println("Клиент был закрыт...");
            clientSocket.close();
            in.close();
            out.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
