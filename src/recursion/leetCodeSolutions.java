import java.util.ArrayList;
import java.util.List;

public class leetCodeSolutions {
    public static void main(String[] args) {
//        List<String> ans = new ArrayList<>();
//        String up = "";
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

    }

    // QUE 17. LETTER COMBINATIONS OF A PHONE NUMBER :
    public static void phone(String p, String up, List<String> result){
        if(up.isEmpty()){
            result.add(p);
            return;
        }

        char digit = up.charAt(0);

        int start = 0;
        int nChars = 3;

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
            start = 'a' + (digit - '2') * 3;
        }

        for (int i = 0 ; i < nChars; i++) {
            char ch = (char)(start + i);

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
