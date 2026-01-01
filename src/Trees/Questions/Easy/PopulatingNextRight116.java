package Trees.Questions.Easy;

public class PopulatingNextRight116 {
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    /*class Solution {
        public Node connect(Node root) {
            Queue<Node> queue = new LinkedList<>();
            if(root == null) return null;
            queue.add(root);

            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    Node curr = queue.poll();
                    if(curr.left != null) queue.add(curr.left);
                    if(curr.right != null) queue.add(curr.right);
                    if(i < size - 1) curr.next = queue.peek();
                    else curr.next = null;
                }
            }
            return root;
        }
    }*/

    //******************************  BETTER APPROACH : *****************************************


    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

   /* class Solution {
        public Node connect(Node root) {
            if(root == null) return null;
            Node leftMost = root;
            while(leftMost.left != null) {    // reach till second leftMost node, starts from 1 as leftMost till here is 1 and it has a left node 2.
                Node curr = leftMost;
                while(curr != null) {
                    curr.left.next = curr.right;    // connects 2 to 3 and 4 to 5 in the first test case.
                    if(curr.next != null) {
                        curr.right.next = curr.next.left;   // connect 5 to 6 in the first test case.
                    }
                    curr = curr.next;   // move to 2 from 1 and move to 3 from 2.
                }   // a level ends here because curr is now null.
                leftMost = leftMost.left;   // now move to the next level.
            }
            return root;
        }
    }
    */


}
