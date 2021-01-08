package homework.lesson_2;

public class Main {
    private static final String ERROR_MESSAGE = "Расчет невозможен: %s";
    private static final String ERROR_DATA = "Не верный тип данных в ячейке %s";
    private static final String ERROR_SIZE = "Не верно указан размер массива";
    private static final String SUM = "Сумма массива: %s";

    public static void main(String[] args) throws Exception {
        int sum = 0;
        try {
            sum = Calculation.sum(new String[][]{
                    new String[]{"1", "2", "3", "4"},
                    new String[]{"1", "2", "3", "4"},
                    new String[]{"1", "2", "3", "w"},
                    new String[]{"1", "2", "3", "4"}
            });
        }
        catch (MyArraySizeException e) {
            System.out.println(String.format(ERROR_MESSAGE, ERROR_SIZE));
        }
        catch (MyArrayDataException e) {
            System.out.println(String.format(ERROR_MESSAGE, String.format(ERROR_DATA, e.getPosition())));
        }
        finally {
            System.out.println(String.format(SUM, sum));
        }
    }
}
