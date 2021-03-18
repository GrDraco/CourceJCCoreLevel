package homework.lesson_6;

// Интерфейс взаимодейтсвия с ViewModel приложения
public interface IChatViewModel extends IMessageListener, IMessageTextListener, ILogListener {

    @Override
    void onNewMessage(Message message);

    @Override
    String getMessageText();

    @Override
    void onSetLog(String message);

    String getHost();

    int getPort();

    String getNickName();

    void onStart();

    void onClose();
}
