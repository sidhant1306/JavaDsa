package Trees.Questions.Easy;

public class PostOrderTraversal145 {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            return Helper(root, new ArrayList());
        }
        public List<Integer> Helper(TreeNode node, List<Integer> result) {
            if(node == null) return result;

            Helper(node.left, result);
            Helper(node.right, result);
            result.add(node.val);
            return result;
        }
    }*/
}
