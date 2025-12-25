package Trees.BinarySearchTrees;


public class BinarySearchTree {
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

    public BinarySearchTree() {
        // constructor to call this binarySearchTree class
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
        return node;        // it means if the node we are checking(the position we are checking for insertion) is not null, we need to return the same node.

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
        BinarySearchTree bst = new BinarySearchTree();
        int[] nums = {10,20,7,8,19,4,25};
        int[] sortedNums = {1,2,3,4,5};
//        bst.insertMultiple(nums);
//        bst.insertMultiple(sortedNums);     // this just creates a tree which goes right
//        bst.insertSorted(sortedNums);

        // this shows why avl trees are important cause as we inserted numbers in increasing order the elements are just added in the right and right side of each element
        // so the height becomes 999.
        for (int i = 0; i < 1000; i++) {
            bst.insert(i);
        }
        bst.display();
        System.out.println(bst.height());
    }


}
