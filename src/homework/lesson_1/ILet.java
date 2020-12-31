package homework.lesson_1;

import java.util.Random;

public interface ILet {
    void setSize(int value);
    int getSize();
    EAction getActionType();

    default void init(int bound) {
        setSize(new Random().nextInt(bound));
    }
}
