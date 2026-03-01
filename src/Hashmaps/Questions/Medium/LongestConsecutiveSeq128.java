package Hashmaps.Questions.Medium;

import java.util.HashSet;

public class LongestConsecutiveSeq128 {

        public int longestConsecutive(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for(Integer num : nums) {
                set.add(num);   // insert all the elements of the array in a hashSet, bc we do not want duplicates
            }
            int maxCount = 0;
            for(Integer num : set) {
                if(set.contains(num - 1)) continue;     // we need to always start checking from the least number in that sequence, if 4,3,2,1 are randomly placed in the set we can not start from 4, we need to start from 1
                int currCount = 1;
                int current = num;
                // this while loop is the loop where we count the entire consecutive sequence :
                while(set.contains(current + 1)){       // check the entire sequence for that number, check for 1, if there is 1 + 1, increase current to 2, now if there is 2 + 1, do the same and so on.
                    current++;
                    currCount++;
                }

                maxCount = Math.max(maxCount, currCount);
                currCount = 0;
            }

            return maxCount;
        }

}
