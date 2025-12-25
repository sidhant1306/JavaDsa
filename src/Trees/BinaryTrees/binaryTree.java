package Trees.BinaryTrees;

import java.util.Scanner;

public class binaryTree {
    public binaryTree() {
        // constructor for binaryTree function
    }

    // class to create a node :

    private static class Node {
        private int value;
        private Node left;
        private Node right;

        // constructor to create a node when a binary tree is created
        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;  // the root node


    public void populate(Scanner scanner) {
        System.out.println("Enter the value of root node : ");
        int value = scanner.nextInt();
        root = new Node(value); // root is the Node we assigned in the binary tree the global variable
        populate(scanner, root);
    }

    public void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter the left node for:" + node.value);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value for the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        // if the user does not want to insert in the left :

        System.out.println("Do you want to insert in the right for : " + node.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value for the right of : " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    // to display(main function) :

    public void display() {
        display(this.root, "");
    }

    // the function which displays the tree :
    public void display(Node node, String indent) {
        if (node == null) return;
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void preetyDisplay() {
        preetyDisplay(root, 0);     // start from level 0, from the root node
    }

    private void preetyDisplay(Node node, int level) {
        if(node == null) return;

        preetyDisplay(node.right, level + 1);       // start from printing the left nodes, and then continue printing for each level(level + 1).

        if(level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");        // before each level keep the elements at the same gap, Note we use print here instead of println
            }
            System.out.println("|------>" +node.value);
        }
        else {
            System.out.println(node.value);     // if level == 0, we only have a root node so just print the value of root node
        }
        preetyDisplay(node.left, level + 1);
    }

    // TRAVERSALS :

    // Pre- order : Node -> Left -> Right
    // in - order : Left -> Node -> Right
    // Post - order : Left -> Right -> Node

    // Pre - order (Node -> Left -> Right) :

    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if(node == null) return;

        System.out.println(node.value + " ");       // at first printing the node
        preOrder(node.left);                        // secondly, printing the left side
        preOrder(node.right);                       // At last printing the right side
    }

    // in - order (Left -> Node -> Right) :

    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if(node == null) return;

        inOrder(node.left);     // firstly print left
        System.out.println(node.value + " ");   // secondly print the node
        inOrder(node.right);    // at last, the right side
    }

    // Post - order (Left -> Right -> Node) :

    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");
    }

    public static void main(String[] args) {
        binaryTree tree = new binaryTree();
        Scanner scanner = new Scanner(System.in);
        tree.populate(scanner);
        tree.preetyDisplay();


    }

    }

