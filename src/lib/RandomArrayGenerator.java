package lib;

import java.util.Random;

public class RandomArrayGenerator {
    private static Random random = new Random();

    public static int[] getIntArray(int size, int min, int max) {
        int[] result_array = new int[size];
        for (int i = 0; i < size; i++) {
            result_array[i] = random.nextInt(max - min + 1) + min;
        }
        return result_array;
    }
}