package Trees.Questions.Medium;

// ************************** solve LevelOrderTraversal question before solving this. *************************

public class AvgOfLevels637 {
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

    // ************************** solve LevelOrderTraversal question before solving this. *************************

    /*class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<Double> sol = new ArrayList<>();
            if(root == null) return sol;
            queue.add(root);

            while(!queue.isEmpty()) {
                int size = queue.size();
                long currSum = 0;   // use long to avoid overflow when you add the currSum with the curr.val
                for(int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();

                    if(curr.left != null) {
                        queue.add(curr.left);
                    }
                    if(curr.right != null) {
                        queue.add(curr.right);
                    }
                    currSum += curr.val;
                }
                double avg = (double)currSum/size;
                sol.add(avg);
            }
            return sol;
        }


    }*/
}
