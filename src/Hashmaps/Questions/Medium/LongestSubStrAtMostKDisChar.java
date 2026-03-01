package Hashmaps.Questions.Medium;

import java.util.HashMap;

public class LongestSubStrAtMostKDisChar {
    public int LongestSubStr(String s, int k) {
        if(s.length() == 0 || k == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int maxLength = 0;
        for (int j = 0; j < s.length(); j++) {
            // first add the current character to the hashmap :
            Character currentChar = s.charAt(j);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1); // if already present in the map, increase the count otherwise just add it as a new character in the map

            // now there are chances that we added a new character to the map, and it obstructed the less than or equal to k condition of map size
            // so check it :
            // remove all the occurrences of leftMost(charAt(i)) character from the map :

            while(!(map.size() <= k)) {
                Character leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar)-1);

                // now check if the occurrence of the character becomes 0 in the map :
                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                i++;
            }
            // now just calculate the maxLength :
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}
