package Trees.Questions.Medium;

public class DiameterOfABinaryTree543 {
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
  /*  class Solution {
        int maximum;
        public int diameterOfBinaryTree(TreeNode root) {
            heightHelper(root);     // this is to implement the helper function as leetcode only calls this function.
            return maximum; // the maximum value is updated now, due to the implementation of the code line above(due to the implementation of the helper function).
        }

        public int heightHelper(TreeNode node) {
            if(node == null) return 0;

            int leftHeight = heightHelper(node.left);       // this is not calculating the left height, via this we are reaching the leaf node of the left side
            int rightHeight = heightHelper(node.right);     // reaching the leaf node of the right side

            maximum = Math.max(maximum , leftHeight + rightHeight); // check if the total distance between its right side and left side is greater than the current maximum.
            // we calculate the diameter after the recursion has ended, while backtracking.


            return Math.max(leftHeight , rightHeight) + 1;      // imagine people are standing on top of one another, in those two lines where we reach the leaf nodes, the recursion has ended, now while returning we are at the last node, so last node tells the node(person) above it that i have a height of 0, so the above person uses that height and calculates the diameter, so it is done after the end of recursion cycle while backtracking, while coming back to the root node, so that is why we need to return the height of each node, its like telling the node above it that its my height and you calculate the diameter and then tell your height to the node above you.
        }


    }*/
}
