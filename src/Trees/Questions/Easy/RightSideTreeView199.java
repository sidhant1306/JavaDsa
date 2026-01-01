package Trees.Questions.Easy;

public class RightSideTreeView199 {
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
        public List<Integer> rightSideView(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> ans = new ArrayList<>();
            if(root == null) return ans;

            queue.add(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.peek();
                    if(curr.left != null) queue.add(curr.left);
                    if(curr.right != null) queue.add(curr.right);
                    if(i == size - 1) ans.add(queue.poll().val);
                    else queue.poll();
                }
            }
            return ans;
        }
    }*/
}
