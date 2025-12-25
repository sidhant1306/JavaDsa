package Trees.Questions.Easy;

public class PathSum112 {
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
   /* class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            return helper(root, targetSum, 0);
        }
        public boolean helper(TreeNode root, int targetSum, int currSum) {
            if(root == null) return false;  // leaf node means no children no left nor right.
            currSum += root.val;    // add the current node value to the currSum
            if(root.left == null && root.right == null && currSum == targetSum) return true;    // if there is no left children and right children and the current sum is equal to target sum return true.
            return  helper(root.left, targetSum, currSum) || helper(root.right, targetSum, currSum); // we use or because only one side is required to have the currSum = targetSum.


        }
    }*/
}
