package Trees.Questions.Easy;

public class sumRootToLeaf129 {
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
 /*   class Solution {
        public int sumNumbers(TreeNode root) {
            return helper(root, 0);
        }

        public int helper(TreeNode root, int sum) {
            if(root == null) return 0;

            sum = sum * 10 + root.val;

            if(root.left == null && root.right == null) return sum;     // it means we reached the leaf node

            return helper(root.left, sum) + helper(root.right, sum);    // combine the sum of left side of root and right side of root
        }
    }*/
}
