package arraysPractice;

public class CheckArrSortedAndRotated1752 {
    public boolean check(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > nums[(i + 1) % nums.length]) count++;  // we are counting how many times the condition break(condition is mentioned in last)
        }

        return count <= 1;
    }
}
