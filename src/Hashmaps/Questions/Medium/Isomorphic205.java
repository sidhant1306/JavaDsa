package Hashmaps.Questions.Medium;

import java.util.HashMap;

public class Isomorphic205 {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if(s.length() != t.length()) return false;

            HashMap<Character, Character> st = new HashMap<>();     // mapping s to t
            HashMap<Character, Character> ts = new HashMap<>();     // mapping t to s

            for (int i = 0; i < s.length(); i++) {
                // length of s and t are same
                Character c1 = s.charAt(i);
                Character c2 = t.charAt(i);

                // now check if st map already contains the c1 character :

                if(st.containsKey(c1)) {
                    // check if the character that is already mapped to the previous occurance is same as the character we are going to map it with now :
                    if(st.get(c1) != c2) return false;
                }   // st has current key condition ends here.
                else {
                    // if st does not contain the current character we are going to put, check ts :
                    // check if ts already has the character c2 we are going to map, mapped to some other char

                    if(ts.containsKey(c2)) {
                        if (ts.get(c2) != c1) return false;
                    }   // if ends here
                }   // else ends here

                // if we reach here it means, both the character are fully new so put them in both the maps.
                st.put(c1, c2);
                ts.put(c2, c1);
            }// for loop ends here
            return true;
        }


    }
}
