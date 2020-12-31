package homework.lesson_2;

import javax.swing.text.Position;
import java.util.Arrays;

public class MyArrayDataException extends Exception {
    private final String UNKNOWN = "unknown";
    private final String FORMAT = "[%s]";

    private int[] position;

    public MyArrayDataException(int[] position) {
        this.position = position;
    }

    public String getPosition() {
        if(position == null || position.length == 0)
            return UNKNOWN;
        String result = "";
        for (int pos: position) {
            result += String.format(FORMAT, pos);
        }
        return result;
    }
}
