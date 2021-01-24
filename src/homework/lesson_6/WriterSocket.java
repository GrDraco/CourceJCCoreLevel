package homework.lesson_6;

import com.google.gson.Gson;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

// Класс передачи данных через сокет
public class WriterSocket extends Thread {
    private final String nickName;
    private final Socket socket;
    private final IMessageTextListener messageTextListener;
    private final ILogListener logListener;

    public WriterSocket(String nickName, Socket socket, IMessageTextListener messageTextListener, ILogListener logListener) throws Exception {
        if (nickName == null || nickName.isEmpty() || socket == null || messageTextListener == null || logListener == null)
            throw new Exception("Params of WriterSocket is null");
        this.nickName = nickName;
        this.socket = socket;
        this.messageTextListener = messageTextListener;
        this.logListener = logListener;
    }

    @Override
    public void run() {
        try (DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream())) {
            Message message;
            do {
                if(socket.isClosed())
                    break;
                message = new Message(nickName, messageTextListener.getMessageText());
                dataOutputStream.writeUTF(new Gson().toJson(message));
                dataOutputStream.flush();
            } while (!"\\finish".equals(message.getText()));
            socket.close();
        }
        catch (IOException e) {
            if(socket.isClosed())
                return;
            logListener.onSetLog(e.toString());
        }
    }
}
