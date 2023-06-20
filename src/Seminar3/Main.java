package Seminar3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < rnd.nextInt(8)+3; i++) {
            linkedList.add(rnd.nextInt(10));
        }
        System.out.println("Размер списка: "+linkedList.getSize());
        System.out.println("Исходный:      "+linkedList);
        linkedList.revers();
        System.out.println("После реверса: "+linkedList);
    }
}