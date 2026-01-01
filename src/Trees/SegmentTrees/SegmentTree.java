package Trees.SegmentTrees;

public class SegmentTree {
    private static class Node {
        // all the things that a node will have in a segment tree :
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

        Node root;
        public SegmentTree(int[] arr){
            this.root = constructTree(arr, 0, arr.length - 1);
        }

        private static Node constructTree(int[] arr, int start, int end) {
            // check if we are at the leaf node :

            if (start == end) {
                Node leaf = new Node(start, end);
                leaf.data = arr[start];
                return leaf;
            }

            // if the node is not the leaf node, extend the tree by creating a new tree :
            Node node = new Node(start, end);
            int mid = (start + end) / 2;

            node.left = constructTree(arr, start, mid);     // create the left side till mid.
            node.right = constructTree(arr, mid + 1, end);  // create the right side after mid.

            node.data = node.left.data + node.right.data;
            return node;
        }


        public void display() {
            display(this.root);
        }
        private void display(Node root) {
            String str = "";
            //for left side :
            if(root.left != null) {
                str = str + "Interval = [ " + root.left.startInterval + "-" + root.left.endInterval + " ] " + "and data : " + root.left.data + " => ";
            } else str = str + "No left child";

            // for current node :
            str = str + "Interval = [ " + root.startInterval + "-" + root.endInterval + " ] " + "and data : " + root.data + " <= ";

            // for right side :
            if(root.right != null) {
                str = str + "Interval = [ " + root.right.startInterval + "-" + root.right.endInterval + " ] " + "and data : " + root.right.data;
            } else str = str + "No right child";

            System.out.println(str + "\n");

            if(root.left != null) {
                display(root.left);
            }
            if(root.right != null) {
                display(root.right);
            }
            }       // display end

    public int query(int qsi, int qei) {
            return this.query(this.root, qsi, qei);
    }
    private int query(Node root, int qsi, int qei) {
        // cases :
        // 1st case : the whole range(query) lies between the current index that the node hold :
        // node is lying completely inside the query interval, we need the entire thing :
        if(root.startInterval >= qsi && root.endInterval <= qei) {
            return root.data;   // we need the entire data.
        }else if(root.startInterval > qei || root.endInterval < qsi) {
            // completely outside.
            return 0;       // this case means the range lies completely outside the intervals of the node.
        }
        else {
            // Case 3 : overLapping case :
            return this.query(root.left, qsi, qei) + this.query(root.right, qsi, qei);
        }
    }   // query end

    public void update(int index, int value) {
            // parameters take index and value as take the index and updates its value with the new value passed.
        this.root.data = updateHelper(root, index, value);
    }
    private int updateHelper(Node root, int index, int value) {
        // check if the index lies in the range :

        if(index >= root.startInterval && index <= root.endInterval) {
            // the index lies in the range.
            if(index == root.startInterval || index == root.endInterval) {
                // we need to either just update the root or the leaf node.
                root.data = value;
                return root.data;
            }
            else {
                // overlapping case :
                int leftAns = updateHelper(root.left, index, value);
                int rightAns = updateHelper(root.right, index, value);

                root.data = leftAns + rightAns;
                return root.data;
            }
        }// the main if ends here.

        // when the index is completely outside, not in the range :

        return root.data;       // just return the current value.
    }

    public static void main(String[] args) {
        int[] arr = {3,8,7,6,-2,-8,4,9};
        SegmentTree tree = new SegmentTree(arr);
        tree.display();
        System.out.println(tree.query(1, 6));
    }   // main end
    }   // Tree end


