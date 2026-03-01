package Hashmaps.Questions.Easy;

import java.util.HashMap;

public class SumOfUniqEle1748 {

        public int sumOfUnique(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (Integer i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if(map.get(nums[i]) == 1) sum += nums[i];
            }

            return sum;
        }

}
