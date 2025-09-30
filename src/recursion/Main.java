package recursion;

import com.sun.tools.attach.AgentInitializationException;

import java.lang.reflect.Array;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {
//        int[] candidates = {10,1,2,7,6,1,5};
//        Arrays.sort(candidates);
//        int target = 8;
//        List<List<Integer>> sol = combinationSum(candidates, target, 0,0, new ArrayList<>(), new ArrayList<>());
//        System.out.println(sol);
//
      /*  int[] nums = {5, 2, 1};
        Arrays.sort(nums);
        List<Integer> sol = subsetOne(nums, new ArrayList<>(), 0, 0);
        System.out.println(sol);*/

        int[] nums = {1,2,2};
        Arrays.sort(nums);
        List<String> result = new ArrayList<>();
        letterCombinations("", "23", result);
        System.out.println(result);
    }

    public static void letterCombinations(String p, String up, List<String> result){
        // base case ;

        if(up.isEmpty()){
            
            result.add(p);
            return;

        }

        char digit = up.charAt(0);
        int nChars = 3;
        int start = 0;

        if(digit == '7'){
            nChars = 4;
            start = 'p';
        }
        else if(digit == '8'){
            start = 't';
        }
        else if(digit == '9'){
            nChars = 4;
            start = 'w';
        }
        else{
            start = 'a' + (digit - '2') * 3;
        }
        for (int i = 0; i < nChars; i++) {
            char ch = (char)(start + i);
            letterCombinations(p + ch, up.substring(1), result);
        }


    }
}
