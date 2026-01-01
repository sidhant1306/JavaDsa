package Trees.Questions.Easy;

public class KthSmallestEle230 {
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
        public int kthSmallest(TreeNode root, int k) {
            Queue<Integer> q = Helper(root, k, new LinkedList<>());
            for(int i = 0; i < k - 1; i++) {
                q.poll();
            }
            return q.peek();
        }

        // just perform inOrder traversal, left -> node -> right
        // because it's a BST, so left side will contain the smallest element
        // so create a queue with all the elements in ascending order and then iterate over it till k - 1 times.
        public Queue<Integer> Helper(TreeNode root, int k, Queue queue) {
            if(root == null) return queue;

            Helper(root.left, k, queue);
            queue.add(root.val);
            Helper(root.right, k, queue);
            return queue;
        }
    }*/
}
