package arraysPractice.easy;

import java.util.Arrays;
import java.util.HashSet;

public class intersection349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        int length = 0;
        if(nums1.length >= nums2.length) length = nums2.length;
        else length = nums1.length;

        int[] ans = new int[length];

        if(nums1.length >= nums2.length) {
            for(int num : nums1) {
                set.add(num);
            }
            for(int num2 : nums2) {
                if(set.contains(num2)) {
                    ans[i] = num2;
                    set.remove(num2);
                    i++;
                }
            }
        }
        else{
            for(int num : nums2) {
                set.add(num);
            }
            for(int num1 : nums1) {
                if(set.contains(num1)) {
                    ans[i] = num1;
                    set.remove(num1);
                    i++;
                }
            }
        }
        return Arrays.copyOf(ans, i);
    }
}
