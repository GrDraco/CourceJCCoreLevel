package homework.lesson_2;

import java.util.Arrays;

public class Calculation {
    public static int sum(String[][] values) throws Exception {
        // Проверка входных данных
        if(values == null
           || values.length != 4
           || Arrays.stream(values).anyMatch(value -> value != null ? value.length != 4 : true))
            throw new MyArraySizeException();
        // Расчет
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                try {
                    result += Integer.valueOf(values[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(new int[] {i, j});
                }
            }
        }
        return result;
    }
}
