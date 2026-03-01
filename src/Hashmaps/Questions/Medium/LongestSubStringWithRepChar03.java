package Hashmaps.Questions.Medium;

import java.util.HashMap;

public class LongestSubStringWithRepChar03 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int maxLength = 0;
        for (int j = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            // we found a duplicate
            map.put(s.charAt(j), j);
            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }
}
