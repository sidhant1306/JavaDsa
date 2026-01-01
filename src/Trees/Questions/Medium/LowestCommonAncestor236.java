package Trees.Questions.Medium;

public class LowestCommonAncestor236 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
   /* class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == p || root == q) return root;
            if(root == null) return root;
            TreeNode l = lowestCommonAncestor(root.left, p, q);
            TreeNode r = lowestCommonAncestor(root.right, p, q);

            if(l != null && r != null) return root;

            if(l != null && r == null) return l;
            if(r != null && l == null) return r;

            return null;
        }
    }*/
}
