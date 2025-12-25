package Trees.Questions.Medium;

public class LevelOrderTraversal102 {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();

            List<List<Integer>> sol = new ArrayList<>();
            if(root == null) return sol;
            queue.add(root);

            while(!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>(); // create a new list everytime we have completed one for loop because this list stores the levels, when all the elements of one level are iterated using the for loop we create a new list and store elements of the next level in that list
                int size = queue.size();     // we need to store the size because size of queue will change each time so we cannot use the same size as the first time to run the for loop.
                for(int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();       // fetch the topmost node of the queue
                    if(curr.left != null) {
                        queue.add(curr.left);
                    }
                    if(curr.right != null) {
                        queue.add(curr.right);
                    }
                    level.add(curr.val);  // add the node for this iteration
                }
                sol.add(level);   // when one level is finished, add the entire level stored in the ans
            }

            return sol;

        }

    }*/
}
