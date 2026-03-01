package Hashmaps.Questions.Easy;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArrays2 {

        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> map1 = new HashMap<>(); // to count all the appearances of nums1
            HashMap<Integer, Integer> map2 = new HashMap<>(); // to count all the appearances of nums2

            for(Integer i : nums1) {
                map1.put(i, map1.getOrDefault(i, 0) + 1);
            }
            for(Integer j : nums2) {
                map2.put(j, map2.getOrDefault(j, 0) + 1);
            }
            ArrayList<Integer> ans = new ArrayList<>();  // arrayList to store the ans.
            for(int i = 0; i < nums1.length; i++) {
                if(map1.containsKey(nums1[i]) && map2.containsKey(nums1[i]) && map2.get(nums1[i]) >= 1) {
                    ans.add(nums1[i]);
                    map2.put(nums1[i], map2.get(nums1[i]) - 1);  // decrease the appearance count each time you add it to the ans
                }
            }

            int[] arr = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                arr[i] = ans.get(i);
            }


            return arr;
        }

}
