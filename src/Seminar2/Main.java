package Seminar2;

import lib.RandomArrayGenerator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = RandomArrayGenerator.getIntArray(30, -10, 10); // генерируем массив
        System.out.println("Исходный массив:      " + Arrays.toString(array));
        HeapSort.sort(array); // сортируем
        System.out.println("Сортированный массив: " + Arrays.toString(array));
    }
}