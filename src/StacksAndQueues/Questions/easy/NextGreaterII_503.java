package StacksAndQueues.Questions.easy;

import java.util.Stack;

public class NextGreaterII_503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        int n = nums.length;
        // we are considering a copy of this array place in front of this array, and we start checking from the end of that array.
        // i % n is used because we are running the for loop for 2 * n, so it will give array index out of bounds, but,
        // if we use i % n, it means consider we have an array nums[1,5,3,4,3],
        // we make it double by using 2 * n, nums[1,5,3,4,3][1,5,3,4,3],
        // now when we start from index 9 which is the last 3, but as the array size is only 5, 9 will give arrayindexoutofbounds,
        // so we use mod, Assume we have to check the 8th index, so we do 8 % size of array(5) -> 8 % 5 = 3, so we are checking the index 3, which is 4, Correct.
        // when i < n we are in the original array nums, only then we push the answers in the ans array, we still use i % n because it means the same anyway.
        for (int i = 2 * n - 1; i >= 0; i--) {
            while(!(stack.isEmpty()) &&  stack.peek() <= nums[i % n]) {
                stack.pop();
            }

            if(i < n) {

                if(stack.isEmpty()) ans[i] = -1;
                else ans[i] = stack.peek();
            }
            stack.push(nums[i % n]);
        }
        return ans;
    }
}
