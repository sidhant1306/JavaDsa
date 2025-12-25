package Trees.AvlTrees;


import Trees.BinaryTrees.binaryTree;

public class AVLtree {
    public class Node {
        private int height;
        private int value;
        private Node right;
        private Node left;


        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public AVLtree() {
        // constructor to call this AVL class
    }

    public int height(Node node)  {
        if(node == null) return -1;
        return node.height;
    }

    public int height() {
        return height(root);
    }


    public boolean isEmpty() {
        return root == null;
    }
    public void insert(int value) {
        root = insert(value, root);     // we are assigning it to root because we do not want nodes to change there positions and we want to insert the new value at root node and of course we will continue our search after it but as we are starting it from the root node, so we say that we are inserting at the root node.In the end the root is returned.
    }
    private Node insert(int value, Node node) {
        if(node == null) {
            node = new Node(value);     // if there is no node in the left or right, create the new node with the value we want to insert
            return node;
        }

        if(value < node.value) {
            node.left = insert(value, node.left);       // if the value that we want to insert is smaller than the current node value, then call this function for the left side node
        }
        else if(value > node.value) {
            node.right = insert(value, node.right);     // similarly as left
        }
        // now as we have added one more node, so the height changes :
        // so while traversing :
        node.height = Math.max(height(node.left) , height(node.right)) + 1;     // previous height + 1 because we just added a new element.
        return rotate(node);        // it means if the node we are checking(the position we are checking for insertion) is not null, we need to return the same node.

    }

    private Node rotate(Node node) {
        if(height(node.left) - height(node.right) > 0) {
            // left heavy

            if(height(node.left.left) - height(node.left.right) > 0) {
                // LEFT LEFT case
                return rightRotate(node);      // perform right rotation on the node.
            }

            if(height(node.left.left) - height(node.left.right) < 0) {
                // LEFT RIGHT CASE : value in negative
                leftRotate(node.left);      // perform left rotation on the child
                return rightRotate(node);   // perform right rotation on the node.
            }
        }

        // right heavy case :

        if(height(node.left) - height(node.right) < -1) {
            // right heavy : negative value

            if(height(node.right.left) - height(node.right.right) < -1 ) {
                // RIGHT-RIGHT CASE
                return leftRotate(node);       // perform left rotate on the node
            }

            if(height(node.right.left) - height(node.right.right) > 0) {
                // Right left case

                rightRotate(node.right);        // perform right rotate on the child.
                return leftRotate(node);        // perform left rotate on the node.
            }
        }
        return node;
    }


    private Node rightRotate(Node p) {
        // the tree :
       //                p
        //              /
        //             c
        //            / \
        //           cL  cR

        Node c = p.left;
        Node cR = c.right;

        c.right = p;        // move the p to the right side of the c, c gets on the top now and p stays on the right side as it was already bigger than c
        p.left = cR;        // we were working on p, c, and cR for rotation, now as cR was greater than c it goes to the right but p is there now and as it was smaller than p we just put it in the left side of p.

        // calculating the new heights :
        p.height = Math.max(height(p.left) , height(p.right) + 1);  // the maximum height from the left side or the right side
        c.height = Math.max(height(c.left) , height(c.right) + 1);

        return c;   // return the new node as c is the top node now.
    }

    private Node leftRotate(Node c) {
        // The tree used :
        //          c
        //           \
        //            p
        //           /
        //          t
        // we passed node c as it was the topmost node in this case.

        Node p = c.right;       // creating a node p (creating the tree).
        Node t = p.left;        // this is the node which we inserted that made the tree unbalanced.

        // performing rotation :
        p.left = c;     // c is smaller than p as p is on the right side
        c.right = t;    // put t in the right of c as it is smaller than p and greater than c.

        // calculate new heights :

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return p;           // p is the topmost node.
    }

    // to insert multiple values :

    public void insertMultiple(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }


    // if the array is sorted, it will just create a single line, so we need to fix it :

    public void insertSorted(int[] nums) {
        insertSorted(nums, 0, nums.length - 1);
    }

    private void insertSorted(int[] nums, int start, int end) {
        // just like binary search we will take the middle element and then keep on inserting the middle elements and perform this function for each of them.

        if(start > end) return;

        int mid = (start + end) / 2;    // calculate the mid.

        // insert the middle element :
        this.insert(nums[mid]);
        // call for left side :
        insertSorted(nums, start, mid - 1); // start till mid part(the left part).
        insertSorted(nums, mid + 1, end);       // the right part
    }

    // to check if the tree is balanced or not :

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if(node == null) return true;

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);

        // abs means we are taking the absolute values, it means, the difference of height for the left node and right node from the root should be less than 1
        // && do the same for the subtree of left side and subtree of the right side.
    }

    public void display() {
        display(root, "Root Node : ");
    }

    private void display(Node node, String details) {
        if(node == null) return;

        System.out.println(details + node.getValue());

        display(node.left, "left child of  : " + node.getValue() + "  : ");     // details and left node
        display(node.right, "Right child of : " + node.getValue() + " : ");
    }


    public static void main(String[] args) {
        AVLtree avl = new AVLtree();
        for (int i = 0; i < 1000; i++) {
            avl.insert(i);
        }

        System.out.println(avl.height());
    }
}
