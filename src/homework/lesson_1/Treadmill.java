package homework.lesson_1;

import java.util.Random;

public class Treadmill implements ILet {
    private int distance;
    private EAction actionType;

    public Treadmill(EAction actionType, int bound) {
        this.actionType = actionType;
        init(bound);
    }

    @Override
    public void setSize(int value) {
        distance = value;
    }

    @Override
    public int getSize() {
        return distance;
    }

    @Override
    public EAction getActionType() {
        return actionType;
    }
}
