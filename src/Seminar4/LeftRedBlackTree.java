package Seminar4;

public class LeftRedBlackTree<T extends Comparable<T>> {

    // Внутренний класс Node для представления узла дерева
    private class Node {
        T value;             // Значение узла
        Color color;         // Цвет узла (красный или черный)
        Node left, right;    // Левый и правый потомки узла

        // Конструктор класса Node
        public Node(T value) {
            this.value = value;
            this.color = Color.RED;   // Новые узлы всегда красные
            this.left = null;
            this.right = null;
        }
    }

    // Перечисление Color для представления цвета узла
    private enum Color {
        RED, BLACK
    }

    private Node root;  // Корень дерева

    // Метод для добавления нового узла в дерево
    public void add(T value) {
        root = addNode(root, value);  // Добавляем новый узел, начиная от корня
        root.color = Color.BLACK;     // Корень всегда черный
    }

    // Рекурсивный метод для добавления нового узла в дерево
    private Node addNode(Node node, T value) {
        // Если узел пустой, то создаем новый узел
        if (node == null) {
            return new Node(value);
        }

        // Добавляем новый узел в левое поддерево
        if (value.compareTo(node.value) < 0) {
            node.left = addNode(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = addNode(node.right, value);
        }

        /* Проверяем, не нарушаются ли условия красно-черного дерева
        1. если правая нода красная и левая нода черная - левосторонний поворот
        2. если левая нода красная и левая нода левой ноды красная - правосторонний поворот
        3. если левая нода красная и правосторонняя нода красная - делаем свап цвета.
        */
        // 1
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        // 2
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        // 3
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    // Метод для проверки, является ли узел красным
    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == Color.RED;
    }

    // Метод для выполнения левого малого поворота
    private Node rotateLeft(Node node) {
//        System.out.print('L');
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = Color.RED;
        return x;
    }

    // Метод для выполнения правого малого поворота
    private Node rotateRight(Node node) {
//        System.out.print('R');
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = Color.RED;
        return x;
    }

    // Метод для выполнения смены цвета
    private void flipColors(Node node) {
        node.color = Color.RED;
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
    }

    // Метод для вывода на печать иерархической структуры дерева
    public void printTree() {
        printTree(root, "", false, 'r');
        System.out.println("\n");
    }

    // Рекурсивный служебный метод для вывода на печать иерархической структуры дерева
    private void printTree(Node node, String prefix, boolean isLeft, Character key) {
        if (node == null) {
            return;
        }
        System.out.println(prefix + (isLeft ? "├── " : "└── ") +
                key + " " + node.value + "(" + (node.color == Color.RED ? "R" : "B") + ")");
        printTree(node.left, prefix + (isLeft ? "│   " : "    "), true, 'L');
        printTree(node.right, prefix + (isLeft ? "│   " : "    "), false, 'R');
    }
}