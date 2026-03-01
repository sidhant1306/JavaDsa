package Hashmaps.Questions.Easy;
import java.util.HashMap;
public class validAnagram242 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        // insert the character as key and count as value :
        if(s.length() != t.length()) return false;

        for (char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);   // put ch and if ch already exists use its count and add 1 otherwise add 1 to 0
        }

        // now the map holds count of each character
        // subtract the count and if at the end 0 is not remaining return false.

        for (char c : t.toCharArray()) {
            if(!map.containsKey(c)) return false;   // if the map does not contain the current character of t

            map.put(c, map.get(c) - 1); // put the current character as key, and decrease its value by 1

            if(map.get(c) < 0) return false;   // if t contains the same character more than s, it becomes -1.

        }
        return true;    // otherwise return true at the end.
    }
}
