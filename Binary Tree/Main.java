public class Main {
    public static void main(String args[]) {
        BinaryTree.Tree t = new BinaryTree.Tree(7);
        t.insert(t, 4);
        t.insert(t, 2);
        t.insert(t, 6);
        t.insert(t, 15);
        t.insert(t, 9);
        t.insert(t, 19);
        t.insert(t, 8);
        t.traverseInOrder(t);
        t.isDegenerate(t,10);
        t.max(t);
        t.min(t);
        t.exists(t, 1);
        t.toString(t);
        t.forAll(t,20);
        System.out.println();
        System.out.println("Height is "+t.height(t));

    }
}
