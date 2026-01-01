package Trees.Questions.Hard;

public class FlattenBinaryTree114 {

    // ************************************* BRUTE - FORCE APPROACH *********************************************

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    /*class Solution {
        public void flatten(TreeNode root) {
            helper(root,queue);
            // Use the queue in last to decide the order after full recursion has taken place.
            while(!queue.isEmpty()){
                root = queue.poll();
                root.left = null;
                root.right = queue.peek();
            }
        }
        Queue<TreeNode> queue = new LinkedList<>();
        public void helper(TreeNode root, Queue<TreeNode> queue) {
            if(root == null) return;
            queue.add(root);    // add the root node first, pre order traversal.
            if(root.left != null) {
                helper(root.left, queue);   // if left is avail do the same for the left node.
            }
            if(root.right != null) {
                helper(root.right, queue);  // if right is avail do the same for right node.
            }
            else return;
        }*/

    }


    // ************************************* OPTIMAL APPROACH ***************************************************
    // EASIER :

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    /*class Solution {
        public void flatten(TreeNode root) {
            TreeNode curr = root;   // take the root node(1 in this case for the first iteration).
            while(curr != null) {
                if(curr.left != null) {     // go to the 2nd last node in the left.
                    TreeNode temp = curr.left;  // assign the 2nd last node to a variable.
                    while(temp.right != null) {     // go to the rightMost position of this 2nd last node.
                        temp = temp.right;      // this is to move to the next right position until we reach the rightmost position.
                    }   // till here we have found the rightmost available space in the left side of root
                    temp.right = curr.right;    // move all the nodes in the right side of 1 to the right side of this temp node.
                    curr.right = curr.left;     // now move all the nodes in the left of the root to the right side.
                    curr.left = null;   // make all the left side null.
                }
                curr = curr.right;  // the while loop will run again if we have some elements still remaining in the left side so we will perform the same thing on the next node.
            }
        }
    }*/
}
