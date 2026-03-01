package Hashmaps.Questions.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class duplicatesInArray442 {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans =  new ArrayList<>();
        for (Integer num : nums) {
            if(map.containsKey(num)) ans.add(num);
            else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return ans;
    }
}
