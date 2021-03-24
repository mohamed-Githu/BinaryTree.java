package tree;

public class Node {
    int key;
    Node right, left;
    
    public Node(int item) {
        key = item;
        right = left = null;
    }
}
