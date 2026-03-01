package Hashmaps.Questions.Medium;

import java.util.HashMap;

public class TwoSum01 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];      // Note that we have not stored anything in the hashmap yet.
            if(map.containsKey(complement)) {   // check if now the hashtable contains the remaining part of the target.
                return new int[]{map.get(complement), i};   // if yes, return a new array with the index of the complement added to it
            }

            map.put(nums[i], i);        // else put the number and its index in each iteration.
        }

        throw new IllegalArgumentException("No two sum present");       // it is mentioned that there will be a solution present so if we reach here, it means there was no two sum so throw an exception.
    }
}
