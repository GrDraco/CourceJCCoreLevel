package homework.lesson_1;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;

public interface IAthlete {
    String SUCCESS = "%s успешно преодолел %s с размером %s";
    String FAIL = "%s сошел с дистанции, он не смог преодолеть %s с размером %s";

    String getName();
    void setActionLimits(Dictionary<EAction, Integer> value);
    Dictionary<EAction, Integer> getActionLimits();
    void setRetirement(boolean value);
    boolean getRetirement();

    default void init(int bound) {
        Dictionary<EAction, Integer> actionLimits = new Hashtable<>();
        actionLimits.put(EAction.Jump, new Random().nextInt(bound * 2));
        actionLimits.put(EAction.Run, new Random().nextInt(bound * 2));
        setActionLimits(actionLimits);
        setRetirement(false);
    }

    default void letsMake(ILet let) {
        if (getRetirement())
            return;
        Integer actionLimit = getActionLimits().get(let.getActionType());
        if(actionLimit == null)
            return;
        boolean retirement = actionLimit.intValue() <= let.getSize();
        setRetirement(retirement);
        if (retirement)
            System.out.println(String.format(FAIL, getName(), let.getActionType().toString(), let.getSize()));
        else
            System.out.println(String.format(SUCCESS, getName(), let.getActionType().toString(), let.getSize()));
    }

    default void printStatus() {
        System.out.println(String.format("%s %s", getName(), getRetirement() ? "выбыл" : "ПРЕОДОЛЕЛ ВСЕ"));
    }
}
