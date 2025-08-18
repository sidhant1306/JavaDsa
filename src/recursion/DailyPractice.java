import java.util.ArrayList;
import java.util.List;

public class DailyPractice {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
//      List<List<Integer>> sol = powerSet(nums);
//      System.out.println(sol);

        boolean ans = checkSubsequenceSum(nums, 8);
        System.out.println(ans);
    }

    public static boolean checkSubsequenceSum(int[] nums, int k) {
        return checkSubSequenceSumHelper(nums, new ArrayList<>(), 0, k, 0);
    }

    public static boolean checkSubSequenceSumHelper(int[] nums, List<Integer> p, int index, int target, int sum){
        if(index == nums.length){
            return sum == target;
        }
        int ch = nums[index];
        p.add(ch);
        if(checkSubSequenceSumHelper(nums, p, index + 1, target, sum + ch)) return true;



        p.remove(p.size() - 1);
        if(checkSubSequenceSumHelper(nums, p, index + 1, target, sum)) return true;

        return false;
    }
}
