package homework.lesson_5;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {
    private static final int SIZE = 10000000;
    private static final int H = SIZE / 2;

    public static void main(String[] args) {
        Float[] data = getTestArray();
        System.out.println(String.format("slowCalculate: %s", slowCalculate(data)));
        System.out.println(String.format("fastCalculate: %s", fastCalculate(data)));
    }

    private static Float[] getTestArray() {
        ArrayList<Float> values = new ArrayList<>();
        for (int i =0; i < SIZE; i++) {
            values.add(1f);
        }
        return values.stream().toArray(Float[]::new);
    }

    private static void calculate(Float[] data) {
        IntStream.range(0, data.length).forEach(i -> data[i] = (float)(data[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)));
    }

    public static long slowCalculate(Float[] data) {
        long start = System.currentTimeMillis();
        //
        calculate(data);
        //
        return System.currentTimeMillis() - start;
    }

    public static long fastCalculate(Float[] data) {
        long start = System.currentTimeMillis();
        //
        Float[] data_1 = new Float[H];
        Float[] data_2 = new Float[H];
        System.arraycopy(data, 0, data_1, 0, H);
        System.arraycopy(data, H, data_2, 0, H);
        //
        Thread part_1 = new Thread(() -> calculate(data_1));
        Thread part_2 = new Thread(() -> calculate(data_2));
        part_1.start();
        part_2.start();
        try {
            part_1.join();
            part_2.join();
        } catch (InterruptedException e) {
            return -1;
        }
        //
        System.arraycopy(data_1, 0, data, 0, H);
        System.arraycopy(data_2, 0, data, H, H);
        //
        return System.currentTimeMillis() - start;
    }
}
