package arraysPractice;

import java.util.HashMap;

public class TwoSum01 {
    public static int[] TwoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int rem = target - arr[i];
            if(map.containsKey(rem) && map.get(rem) != i) return new int[]{i, map.get(rem)};
        }

        return new int[]{-1, -1};
    }
}
