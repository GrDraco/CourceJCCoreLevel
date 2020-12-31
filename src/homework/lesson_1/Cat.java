package homework.lesson_1;

import java.util.Dictionary;
import java.util.Random;

public class Cat implements IAthlete {
    private String name;
    private Dictionary<EAction, Integer> ActionLimits;
    private boolean retirement;

    public Cat(String name, int bound) {
        this.name = name;
        init(bound);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setActionLimits(Dictionary<EAction, Integer> value) {
        ActionLimits = value;
    }

    @Override
    public Dictionary<EAction, Integer> getActionLimits() {
        return ActionLimits;
    }

    @Override
    public void setRetirement(boolean value) {
        retirement = value;
    }

    @Override
    public boolean getRetirement() {
        return retirement;
    }
}
