package Data_Structure;

import java.util.ArrayList;

/**
 * @author 15304
 */

public class BinarySearchTree {
    public static void main(String[] args){
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        Tree tree2 = new Tree();
        tree2.insert(7);
        tree2.insert(4);
        tree2.insert(9);
        tree2.insert(1);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);

        System.out.println(tree.isBinarySearchTree());
        System.out.println(tree.getNodesAtDistance(0));
        System.out.println(tree.equals(tree2));
        System.out.println(tree.findNode(2));
        System.out.println(tree.height());
        System.out.println(tree.min());
        System.out.println();
        tree.traverseLevelOrder();
        System.out.println();
        tree.traversePreOrder();
        System.out.println();
        tree.traverseInOrder();
        System.out.println();
        tree.traversePostOrder();

    }

    public static class Tree{
        private static class Node{
            private int value;
            private Node leftChild;
            private Node rightChild;
            public Node(int value) {
                this.value = value;
            }
        }
        private Node root;

        public void insert(int value){
            var node = new Node(value);
            if (root == null){
                root = new Node(value);
                return;
            }
            var current = root;
            while (true){
                if (value < current.value){
                    if (current.leftChild == null){
                        current.leftChild = node;
                        break;
                    }
                    current = current.leftChild;
                }
                else{
                    if (current.rightChild == null){
                        current.rightChild = node;
                        break;
                    }
                    current = current.rightChild;
                }
            }
        }

        public boolean findNode(int value){
            var current = root;
            while (current != null){
                if (value < current.value){
                    current = current.leftChild;
                }
                else if (value > current.value){
                    current = current.rightChild;
                }
                else{
                    return true;
                }
            }
            return false;
        }

        public void traversePreOrder(){
            traversePreOrder(root);
        }
        private void traversePreOrder(Node root){
            if (root == null){
                return;
            }
            System.out.println(root.value);
            traversePreOrder(root.leftChild);
            traversePreOrder(root.rightChild);
        }

        public void traverseInOrder(){ traverseInOrder(root); }
        private void traverseInOrder(Node root){
            if (root == null){
                return;
            }
            traverseInOrder(root.leftChild);
            System.out.println(root.value);
            traverseInOrder(root.rightChild);
        }

        public void traversePostOrder(){
            traversePostOrder(root);
        }
        private void traversePostOrder(Node root){
            if (root == null){
                return;
            }
            traversePostOrder(root.leftChild);
            traversePostOrder(root.rightChild);
            System.out.println(root.value);
        }

        private boolean isLeaf(Node node){
            if (node == null){
                return false;
            }
            return node.leftChild == null && node.rightChild == null;
        }

        public int height(){ return height(root); }
        private int height(Node root){
            if (root == null){
                return -1;
            }
            if (isLeaf(root)){
                return 0;
            }
            return 1 + Math.max(height(root.leftChild), height(root.rightChild));
        }

        public int min(){ return min(root); }
        private int min(Node root){
            if (root == null){
                throw new IllegalStateException();
            }
            if (root.leftChild == null){
                return root.value;
            }
            return min(root.leftChild);
        }
        /*
        public int min(){
            return min(root);
        }
        private int min(Node root){
            if (isLeaf(root)){
                return root.value;
            }
            var left = min(root.leftChild);
            var right = min(root.rightChild);
            return Math.min(root.value, Math.min(left,right));
        }*/

        public boolean equals(Tree other){
            if (other == null){
                return false;
            }
            return equals(root, other.root);
        }
        private boolean equals(Node first, Node second){
            if (first == null && second == null){
                return true;
            }
            if (first != null && second != null){
                return first.value == second.value
                        && equals(first.leftChild, second.leftChild)
                        && equals(first.rightChild, second.rightChild);
            }
            return false;
        }

        public boolean isBinarySearchTree(){ return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);}
        private boolean isBinarySearchTree(Node root, int min, int max){
            if (root == null){
                return true;
            }
            if (root.value < min || root.value > max){
                return false;
            }
            return isBinarySearchTree(root.leftChild, min, root.value - 1)
                    && isBinarySearchTree(root.rightChild, root.value + 1, max);
        }

        public ArrayList<Integer> getNodesAtDistance(int distance){
            var list = new ArrayList<Integer>();
            getNodesAtDistance(root,distance, list);
            return list;
        }
        private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list){
            if (root == null){
                return;
            }
            if (distance == 0){
                list.add(root.value);
                return;
            }
            getNodesAtDistance(root.leftChild, distance - 1, list);
            getNodesAtDistance(root.rightChild, distance - 1, list);
        }

        public void traverseLevelOrder(){
            for (int i = 0; i <= height(); i++){
                for (var value: getNodesAtDistance(i)){
                    System.out.println(value);
                }
            }
        }
    }
}
