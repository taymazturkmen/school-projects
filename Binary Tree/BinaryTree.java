public class Aufgabe5 {
/**
 * Ein Class für eine Binare Baum bauen
 *
 * @author Taymaz Türkmen
 */
    public static class Tree {
/**
 * 
 *Prüft ob alle Zahlen kleiner als 20 sind
 */
        interface MyInterface {
            boolean allSmallerTwenty();
        }

        private int value;
        private Tree lhs; // left child
        private Tree rhs; // right child

        Tree(int value) {
            this.value = value;
        }

        public void insert(Tree tree, int value) {
            if (value < tree.value) {
                if (tree.lhs != null) {
                    insert(tree.lhs, value);
                } else {
                    tree.lhs = new Tree(value);
                }
            } else if (value > tree.value) {
                if (tree.rhs != null) {
                    insert(tree.rhs, value);
                } else {
                    tree.rhs = new Tree(value);
                }
            }
        }

        public void traverseInOrder(Tree tree) {
            if (tree != null) {
                traverseInOrder(tree.lhs);
                System.out.print(" " + tree.value);
                traverseInOrder(tree.rhs);
            }
        }

        int leftHeight = 0, rightHeight = 0;

        public int height(Tree tree) {
            if (tree.lhs != null) {
                height(tree.lhs);
                leftHeight++;
            }
            if (tree.rhs != null) {
                height(tree.rhs);
                rightHeight++;
            }
            int max = (leftHeight > rightHeight) ? leftHeight : rightHeight;
            max++;
            return (max - 1);

        }

/**
 * 
 *Findet das grösstes Element
 * 
 */
        public void max(Tree tree) {
            if (tree.rhs == null) {
                System.out.println();
                System.out.println("Max Number is " + tree.value);
            } else {
                max(tree.rhs);
            }
        }
/**
 * 
 *Findet das kleinstes Element
 * 
 */
        public void min(Tree tree) {   
            if (tree.lhs == null) {
                System.out.println("Minimum number is " + tree.value);
            } else {
                min(tree.lhs);
            }
        }

/**
 * 
 *Prüft ob ein Element in Baum existiert oder nicht.
 * 
 */
        public void exists(Tree tree, int x) {
            if (x == tree.value) {
                System.out.println(" Number " + x + " Exists");
            } else {
                if (tree.rhs != null) {
                    if (x > tree.value) {
                        exists(tree.rhs, x);
                    }
                }
                if (tree.lhs != null) {
                    if (x < tree.value) {
                        exists(tree.lhs, x);
                    }
                } else {
                    System.out.println(x + " Does Not Exist");
                }
            }

        }

        public boolean forAll(Tree tree, int n) {
            if (tree != null) {
                if (tree.rhs != null) {
                    forAll(tree.rhs, n);
                } else {
                    if (tree.value < n) {
                        MyInterface myInterface = new MyInterface() {
                            @Override
                            public boolean allSmallerTwenty() {
                                return true;
                            }
                        };
                        return true;
                    }
                }
            }
            return false;
        }

/**
 * 
 *Prüft ob ein Element in Baum entartet ist
 * 
 */
        public void isDegenerate(Tree tree, int x) {
            if (x == tree.value) {
                if (tree.lhs != null & tree.rhs != null) {
                    System.out.println();
                    System.out.println( tree.value + " ist Entartet");
                } else {
                    System.out.println();
                    System.out.println(tree.value + " ist nicht Entartet");
                }
            } else {
                if (tree.rhs != null) {
                    if (x > tree.value) {
                        isDegenerate(tree.rhs, value);
                    }
                }
                if (tree.lhs != null) {
                    if (x < tree.value) {
                        isDegenerate(tree.lhs, value);
                    }
                } else {
                }
            }
        }

        public void toString(Tree tree) {
            if (tree != null) {
                System.out.print("(");
                toString(tree.lhs);
                System.out.print(tree.value);
                toString(tree.rhs);
                System.out.print(")");
            }
        }

    }
}





