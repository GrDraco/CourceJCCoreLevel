package homework.lesson_6;

import java.util.UUID;

// Модель обмена данными между сервером и клиентом
public class Message {
    private String id;
    private String nickName;
    private String text;

    Message(String nickName, String text) {
        id = UUID.randomUUID().toString();
        this.nickName = nickName;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return String.format("%s (%s): %s", nickName, id, text);
    }
}
