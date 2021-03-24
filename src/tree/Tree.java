package tree;

import java.util.Scanner;

public class Tree {

    public static void main(String[] args) {
        boolean run = true;
        int value;
        Scanner in = new Scanner(System.in);
        BinaryTree tree = new BinaryTree(0);
        
        tree.root.right = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left = new Node(6);
        tree.root.left.left.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right.right = new Node(9);
        
        
        printTree(tree.root);
        
        while(run) {
            switch(getOption()) {
                case '1':
                    print("Value: ");
                    value = in.nextInt();
                    print("\n(1) Right\n(2) Left\n\nChild: ");
                    char option = in.next().charAt(0);
                    Child child = option == '1' ? Child.RIGHT : Child.LEFT;
                    print("Leave: ");
                    int leave = in.nextInt();
                    addElement(tree.root, leave, child, value);
                    printTree(tree.root);
                    break;
                case '2':
                    print("Value: ");
                    value = in.nextInt();
                    removeElement(tree.root, value);
                    printTree(tree.root);
                    break;
                case '3':
                    printTree(tree.root);
                    break;
                default:
                    run = false;
                    break;
            }
        }
        
    }
    
    public static void printTree(Node node) {
        
        print("  " + node.key + "\n");
        if (node.left != null)
            print(" / ");
        else
            print("   ");
        if (node.right != null)
            print("\\\n");
        else
            print("\n");
        if (node.left != null)
            print(node.left.key + "   ");
        else
            print("    ");
        if (node.right != null)
            print(node.right.key + "\n");
        else
            print("\n");
        
        if (node.left != null)
            printTree(node.left);
        if (node.right != null)
            printTree(node.right);
    }
    
    public static void print(String str) {
        System.out.print(str);
    }
    
    public static void print(int num) {
        System.out.print(num);
    }
    
    public static void println(String str) {
        System.out.println(str);
    }
    
    public static char getOption() {
        Scanner in = new Scanner(System.in);
        char option = '0';
        
        println("(1) Add Element");
        println("(2) Remove Element");
        println("(3) Print Tree");
        println("( ) Exit\n");
        
        print("Option: ");
        option = in.next().charAt(0);
        
        return option;
    }
    
    enum Child {
        RIGHT,
        LEFT
    }
    
    public static void addElement(Node root, int leave, Child child, int value) {
        if (root.key == leave) {
            if (root.left == null && child == Child.LEFT) {
                root.left = new Node(value);
            } else if (root.right == null && child == Child.RIGHT) {
                root.right = new Node(value);
            }       
        } else {
            if (root.right != null)
                addElement(root.right, leave, child, value);
            if (root.left != null)
                addElement(root.left, leave, child, value);
        }
        
    }
    
    public static void removeElement(Node root, int nodeKey) {
        boolean removed = false;
        
        if (root.right != null) {
            if (root.right.key == nodeKey) {
                root.right = null;
                removed = true;
            }
        }
        if (root.left != null) {
            if (root.left.key == nodeKey) {
                root.left = null;
                removed = true;
            }
        }
        if (removed)
            return;
        if (root.left != null)
            removeElement(root.left, nodeKey);
        if (root.right != null)
            removeElement(root.right, nodeKey);
    }
    
}