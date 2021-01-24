package homework.lesson_6;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

// Класс чтения данных из сокета
public class ReaderSocket  extends Thread {
    private final Socket socket;
    private final IMessageListener messageListener;
    private final ILogListener logListener;
    private Message message;

    public ReaderSocket(Socket socket, IMessageListener messageListener, ILogListener logListener) throws Exception {
        if (socket == null || messageListener == null || logListener == null)
            throw new Exception("Params of ReaderSocket is null");
        this.socket = socket;
        this.messageListener = messageListener;
        this.logListener = logListener;
    }

    @Override
    public void run() {
        try (DataInputStream dataInputStream = new DataInputStream(socket.getInputStream())) {
            do {
                if (socket.isClosed())
                    break;
                message = new Gson().fromJson(dataInputStream.readUTF(), Message.class);
                if (messageListener != null)
                    messageListener.onNewMessage(message);
            } while (!"\\finish".equals(message.getText()));
            socket.close();
        } catch (IOException e) {
            if(socket.isClosed())
                return;
            logListener.onSetLog(e.toString());
        }
    }

    public Message getMessage() {
        return message;
    }
}
