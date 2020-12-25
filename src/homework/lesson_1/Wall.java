package homework.lesson_1;

import java.util.Random;

public class Wall implements ILet {
    private int height;
    private EAction actionType;

    public Wall(EAction actionType, int bound) {
        this.actionType = actionType;
        init(bound);
    }

    @Override
    public void setSize(int value) {
        height = value;
    }

    @Override
    public int getSize() {
        return height;
    }

    @Override
    public EAction getActionType() {
        return actionType;
    }
}
