import java.util.ArrayList;
import java.util.List;

public class leetCodeSolutions {
    public static void main(String[] args) {
//        List<String> ans = new ArrayList<>();
//        String up = "23";
//        if(up.isEmpty()){
//            System.out.println(ans);
//        }else{
//            phone("", up, ans);
//            System.out.println(ans);
//        }

//        int target = 4;
//        int n = 2;
//        int k = 6;
//        int ans = dice("", target, n, k);
//        System.out.println(ans);


//        int target = 8;
//        List<List<Integer>> ans = combinationSum(nums, target);
//        System.out.println(ans);


//        int[] nums = {5, 2, 1};
//        List<Integer> ans = subSetSum(nums);
//        System.out.println(ans);

//        List<List<Integer>> ans = combinationSum3(3, 7);
//        System.out.println(ans);



//        int n = 3;
//        List<String> ans = generatePara(n);
//        System.out.println(ans);

//        int n = 3;
//        List<String> ans = generateBinaryStrings(n);
//        System.out.println(ans);
    }

//QUE (STRIVER) GENERATE BINARY STRINGS :



    public static List<String> generateBinaryStrings(int n){
        return generateBinaryStringsHelper(n, "", new ArrayList<>());
    }
    public static List<String> generateBinaryStringsHelper(int n, String p, List<String> result){
        // base case :

        if(p.length() == n){
            result.add(p);
            return result;
        }
        // we can just directly add 0 because there is no condition of adding 0's
        generateBinaryStringsHelper(n, p + "0", result);        // just adding 0 to the output string
        // we have to make two checks we have to check if the last element in the added string output is 1 but to check this we can't directy use length - 1 due to array index out of bounds
        // so we also add 1 in the case when the output string is empty
        // else just return the result
        if(p.isEmpty() || p.charAt( p.length() - 1) != '1'){
            generateBinaryStringsHelper(n, p + "1", result);    // adding 1 to the output string
        }


        return result;
    }





    // QUE (22) (LEETCODE) GENERATE PARENTHESES :



    public static List<String> generatePara(int n){
        return generateParaHelper(n, n, n, "", new ArrayList<>());
    }

    public static List<String> generateParaHelper(int n, int open, int close, String p, List<String> result){
        if(open == 0 && close == 0){
            result.add(p);
            return result;
        }

        if(open > 0){
            generateParaHelper(n, open - 1, close, p + "(", result);
        }
        if(close > open){
            generateParaHelper(n, open, close - 1, p + ")", result);
        }
        return result;
    }




    //QUE(STRIVER) SUBSETS-I :

    public static List<Integer> subSetSum(int[] nums){
        return subSetSumsHelper(nums, new ArrayList<>(), 0, 0, new ArrayList<>());
    }
    public static List<Integer> subSetSumsHelper(int[] nums, List<Integer> p, int index, int sum, List<Integer> result){
        // base case :
        if(index == nums.length){
            result.add(sum);
            return result;
        }

        int ch = nums[index];
        subSetSumsHelper(nums, p, index + 1, sum + ch, result);     //adding the element to the sum 0 + first element + second element
        subSetSumsHelper(nums, p, index + 1, sum, result);

        return result;
    }






    // QUE(216)(LEETCODE) COMBINATION SUM 3 :

    public static List<List<Integer>> combinationSum3(int k, int n){
        return combinationSum3Helper(k, n, 0, 0, new ArrayList<>(), new ArrayList<>());
    }
    public static List<List<Integer>> combinationSum3Helper(int k, int n, int start, int sum, List<Integer> p, List<List<Integer>> result){
        // base case :
        if(sum == n && p.size() == k){
            result.add(new ArrayList<>(p));
            return result;
        }

        for (int i = start + 1; i <= 9; i++) {

            if((sum + i) > n) break;
            if(p.size() + 1 > k) continue;
            p.add(i);
            combinationSum3Helper(k, n, i, sum + i, p, result);

            p.remove(p.size() - 1);
        }
        return result;
    }






    //QUE   COMBINATION SUM 2 :


    public static List<List<Integer>> combinationSum2Helper(int[] up, List<Integer> p, int index, List<List<Integer>> result, int target, int currentSum){
        return combinationSum2(p, up, index, result, target, currentSum);
    }
    public static List<List<Integer>> combinationSum2(List<Integer> p, int[] up, int index, List<List<Integer>> result,int target, int correctSum){

        if(correctSum== target){
            result.add(new ArrayList<>(p));
            return result;
        }


        for(int i = index; i < up.length; i++){
            if(correctSum + up[i] > target) break;
            if(i > index && up[i] == up[i - 1]) continue;

            p.add(up[i]);
            combinationSum2(p, up, i + 1, result,target,correctSum + up[i]);

            p.remove(p.size() - 1);

        }
        return result;
    }






    // QUE 39. COMBINATION SUM :

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        return combinationSumHelper(candidates, target, 0, new ArrayList<>(), new ArrayList<>());
    }

    public static List<List<Integer>> combinationSumHelper(int[] nums, int target, int index, List<Integer> p, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(p));
            return result;
        }

        if(target < 0 || index >= nums.length) return result;
        p.add(nums[index]);
        combinationSumHelper(nums, target - nums[index], index, p, result);

        p.remove(p.size() - 1);
        combinationSumHelper(nums, target, index + 1, p, result);

        return result;

    }





    // QUE 17. LETTER COMBINATIONS OF A PHONE NUMBER :
    public static void phone(String p, String up, List<String> result){
        if(up.isEmpty()){
            result.add(p);
            return;
        }

        char digit = up.charAt(0);      // The first character of the up string

        int start = 0;
        int nChars = 3;     //characters present at each number

        if(digit == '7'){
            start = 'p';
            nChars = 4;
        }

        else if(digit == '8'){
            start = 't';
            nChars = 3;
        }
        else if(digit == '9'){
            start = 'w';
            nChars = 4;
        }

        else{
            start = 'a' + (digit - '2') * 3;        //digit - 2 converts it to number '3' - '2' = 1
                                                    // * 3 because there are 3 characters
        }

        for (int i = 0 ; i < nChars; i++) {
            char ch = (char)(start + i);        // the character we are picking from the position of that number

            phone(p + ch, up.substring(1), result);
        }
    }


    //QUE 1155 (LEETCODE) : NUMBER OF DICE ROLLS WITH TARGET SUM:

    // THE FUNCTION BELOW IS NOT FULLY OPTIMISED FOR LEETCODE INPUTS, AND IT STILL NEEDS THE USE OF DYNAMIC PROGRAMMING,
    // BUT I CREATED THE FUNCTION TO AT LEAST WORK FOR SMALLER INPUTS FOR THE QUESTION USING ONLY RECURSION

    public static  int dice(String p, int target, int n, int k){
        if(target == 0 && n == 0){
            return 1;
        }

        if(n == 0 && target != 0) return 0;

        int count = 0;

        for (int i = 1; i <= k && i <= target; i++) {
            count = count + (dice(p + i, target - i, n - 1, k));
        }

        return count;
    }
}
