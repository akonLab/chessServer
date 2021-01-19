package chat;

import com.company.models.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

@MultipartConfig
public class ChatServlet extends HttpServlet {
    ArrayList<Message> messages = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("messages", messages);
        req.getRequestDispatcher("jsp/chat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part file = req.getPart("file");
        // String fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        // InputStream fileContent = file.getInputStream();

        String from = req.getParameter("from");

        String text = req.getParameter("textInput");
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm a, dd MMM", Locale.ENGLISH);

        System.out.println(file);
        System.out.println(text);

        if (from.equals("server")) {
            ServerChat serverChat = new ServerChat();
            serverChat.start();

            serverChat.serverSend(text, file, dateFormat.format(Calendar.getInstance().getTime()));
            messages.add(serverChat.serverGet());
        }else {
            ClientChat clientChat=new ClientChat();
            clientChat.start();

            clientChat.clientSend(text, file, dateFormat.format(Calendar.getInstance().getTime()));
            messages.add(clientChat.clientGet());
        }
        //messages.add(new Message(text, file, dateFormat.format(Calendar.getInstance().getTime())));

        req.setAttribute("messages", messages);
        req.getRequestDispatcher("jsp/chat.jsp").forward(req, resp);
    }

}
/*date
SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm a, dd MMM", Locale.ENGLISH);
req.setAttribute("time", dateFormat.format(Calendar.getInstance().getTime()));
 */
