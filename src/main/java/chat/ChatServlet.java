package chat;

import com.company.models.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

@MultipartConfig
public class ChatServlet extends HttpServlet {
    ArrayList<Message> messages = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm a, dd MMM", Locale.ENGLISH);

    private Socket socket = null;
    private ServerSocket servSocket = null;

    private ObjectInputStream in;
    private ObjectOutputStream out;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("messages", messages);
        req.getRequestDispatcher("jsp/chat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part file = req.getPart("file");
        String text = req.getParameter("textInput");

        System.out.println(file);
        System.out.println(text);

        if (servSocket == null) {
            start();
        }

        String action = req.getParameter("action");
        switch (action) {
            case "disconnect":
                closeConnection();
                break;
            case "refresh":
                messages.add(serverGet());
                break;
            case "send":
                serverSend(text, file, dateFormat.format(Calendar.getInstance().getTime()));
                messages.add(serverGet());
                break;
        }

        req.setAttribute("messages", messages);
        System.out.println(messages);
        req.getRequestDispatcher("jsp/chat.jsp").forward(req, resp);
    }

    public void start() {
        try {
         //   socket = new Socket();
            servSocket = new ServerSocket(12345);
            System.out.println("Сервер запущен!");

            socket = servSocket.accept();
            // accept() будет ждать пока кто-нибудь не захочет подключиться

            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
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
            servSocket.close();
            in.close();
            out.close();
            System.out.println("Сервер закрыт!");
            socket.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
/*date
SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm a, dd MMM", Locale.ENGLISH);
req.setAttribute("time", dateFormat.format(Calendar.getInstance().getTime()));
 */
// String fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
// InputStream fileContent = file.getInputStream();
// String from = req.getParameter("from");

/*
        if (from.equals("server")) {
            servCon(text,file);
        } else {
            clientCon(text,file);
        }
        */
//messages.add(new Message(text, file, dateFormat.format(Calendar.getInstance().getTime())));