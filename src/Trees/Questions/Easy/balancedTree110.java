package Trees.Questions.Easy;

public class balancedTree110 {
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
        public boolean isBalanced(TreeNode root) {
            heightHelper(root);
            return balanced;
        }
        boolean balanced = true;
        public int heightHelper(TreeNode node) {
            if(node == null) return 0;

            int leftHeight = heightHelper(node.left);
            int rightHeight = heightHelper(node.right);

            if((leftHeight - rightHeight) > 1 || (leftHeight - rightHeight) < -1) balanced = false;
            return Math.max(leftHeight , rightHeight) + 1;
        }

    }*/
}
