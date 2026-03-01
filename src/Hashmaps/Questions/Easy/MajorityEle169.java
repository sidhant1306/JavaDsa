package Hashmaps.Questions.Easy;

import java.util.HashMap;

public class MajorityEle169 {
    public int majorityEle(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Integer num : nums) {
            if(map.get(num) > nums.length / 2) return num;
        }
        return -1;
    }
}
