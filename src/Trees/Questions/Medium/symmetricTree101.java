package Trees.Questions.Medium;

public class symmetricTree101 {
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
        public boolean isSymmetric(TreeNode root) {
            if(root == null) return true;
            return Helper(root.left, root.right);
        }
        public boolean Helper(TreeNode leftNode, TreeNode rightNode) {
            if(leftNode == null && rightNode == null) return true;  // if both are null, nothing to check
            if(leftNode == null || rightNode == null || leftNode.val != rightNode.val) return false;    // if only one of them is null it means the structure does not match, and check if the values are equal

            return Helper(leftNode.left, rightNode.right) && Helper(leftNode.right, rightNode.left);
            // we peform the function by comparing :
            // left to right
            // left.right to right.left
            // as they should be equal to form a mirror image.
        }
    }*/
}
