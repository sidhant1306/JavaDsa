package Hashmaps.Questions.Easy;

import java.util.HashMap;

// ************************************** SOLVE TWO SUM BEFORE THIS *****************************************
public class ContainsDuplicateII219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {  // if the current number is already present in the hashmap
                int prev =  map.get(nums[i]);    // the index of the number that was already present.

                if(i - prev <= k) return true;   // subtract the previous index from current
            }
            map.put(nums[i], i);    // if the duplicate of current index value is not present in the hashmap already, just put it into the hashmap and move on
        }
        return false;
    }
}
