package homework.lesson_6;

public interface IMessageListener extends java.util.EventListener {
    void onNewMessage(Message message);
}