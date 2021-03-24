package tree;

public class BinaryTree {
    Node root;
    
    BinaryTree() {
        root = null;
    }
    
    BinaryTree(int key) {
        root = new Node(key);
    }
}
