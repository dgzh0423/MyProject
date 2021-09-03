package Data_Structure;
/**
 * @author 15304
 */
public class AVLTreeMain {
    public static void main(String[] args){
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(1);
        tree.insert(6);
    }

    public static class AVLTree{
        private class AVLNode{
            private int height;
            private int value;
            private AVLNode leftChild;
            private AVLNode rightChild;
            public AVLNode(int value){
                this.value = value;
            }
        }
        private AVLNode root;

        public void insert(int value){
            root = insert(root, value);
        }
        private AVLNode insert(AVLNode root, int value){
            if (root == null){
                return new AVLNode(value);
            }
            if (value < root.value){
                root.leftChild = insert(root.leftChild,value);
            }
            else{
                root.rightChild = insert(root.rightChild,value);
            }
            setHeight(root);// Update the height of node

            return balance(root);
        }

        private AVLNode balance(AVLNode root){
            if (isLeftHeavy(root)){
                if (balanceFactor(root.leftChild) < 0){
                    root.leftChild = rotateLeft(root.leftChild);
                }
                rotateRight(root);
            }
            else if (isRightHeavy(root)){
                if (balanceFactor(root.rightChild) > 0){
                    root.rightChild = rotateRight(root.rightChild);
                }
                rotateLeft(root);
            }
            return root;
        }

        private int height(AVLNode node){
            return (node == null) ? -1 : node.height;
        }
        private void setHeight(AVLNode node){
            node.height = Math.max(height(node.leftChild),height(node.rightChild)) + 1;
        }

        private boolean isLeftHeavy(AVLNode node){
            return balanceFactor(node) > 1;
        }
        private boolean isRightHeavy(AVLNode node){
            return balanceFactor(node) < -1;
        }
        private int balanceFactor(AVLNode node){
            return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
        }

        //     5 root
        //       10 newRoot
        //     8    12
        private AVLNode rotateLeft(AVLNode root){
            var newRoot = root.rightChild;
            root.rightChild = newRoot.leftChild;
            newRoot.leftChild = root;
            setHeight(root);
            setHeight(newRoot);

            return newRoot;
        }
        //       10 root
        //    5 newRoot
        //  1    6
        private AVLNode rotateRight(AVLNode root){
            var newRoot = root.leftChild;
            root.leftChild = newRoot.rightChild;
            newRoot.rightChild = root;
            setHeight(root);
            setHeight(newRoot);

            return newRoot;
        }
    }
}
