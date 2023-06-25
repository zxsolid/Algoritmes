package Seminar4;

public class Main {
    public static void main(String[] args) {
        LeftRedBlackTree<Integer> tree = new LeftRedBlackTree<>();
        tree.add(24);
        tree.printTree();
        tree.add(5);
        tree.printTree();
        tree.add(1);
        tree.printTree();
        tree.add(15);
        tree.printTree();
        tree.add(3);
        tree.printTree();
        tree.add(8);
        tree.printTree();
    }
}