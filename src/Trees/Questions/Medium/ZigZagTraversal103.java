package Trees.Questions.Medium;

public class ZigZagTraversal103 {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> sol = new ArrayList<>();
            if(root == null) return sol;
            queue.add(root);
            boolean leftToRight = true;
            while(!queue.isEmpty()) {

                List<Integer> ans = new ArrayList<>();
                int size = queue.size();

                for(int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();
                    if(curr.left != null) queue.add(curr.left);
                    if(curr.right != null) queue.add(curr.right);

                    if(leftToRight) ans.add(curr.val);
                    else ans.add(0, curr.val);
                }
                sol.add(ans);
                leftToRight = !leftToRight;
            }
            return sol;
        }
    }*/
}
