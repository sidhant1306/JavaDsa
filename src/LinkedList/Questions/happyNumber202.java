package LinkedList.Questions;

import LinkedList.LLquestions;

import java.util.ArrayList;
import java.util.List;

public class happyNumber202 extends LLquestions {

    // HAPPY NUMBER QUESTION, APPROACH:- NON CYCLIC METHOD

    public static boolean happyNumber(int n){
        return happyNumberHelper(n, new ArrayList<>());
    }

    public static boolean happyNumberHelper(int n, List<Integer> list){
        int sum = 0;
        // traversing through the number to retrieve the digit we are working on:
        while(n > 0){
            int digit = n % 10;
            sum += digit * digit;       // add the square of the current digit
            n = n / 10;
        }
        if(list.contains(sum)) return false;        // if the list contained the current sum in its previous calls, we return false because it causes an infinite loop
        list.add(sum);      // otherwise just add the current sum to the list
        if(sum == 1) return true;
        else{
            return happyNumberHelper(sum, list);
        }
    }

    // HAPPY NUMBER QUESTION APPROACH: - CYCLIC METHOD

    public static boolean happy(int n){
        int slow = n;
        int fast = n;

        do{
            fast = findSquare(findSquare(fast));    // taking two steps at a time
            slow = findSquare(slow);        // taking one step at one time
        }while(fast != slow);

        return (slow == 1);
    }
    public static int findSquare(int number){
        int ans = 0;
        while(number != 0){
            int rem = number % 10;

            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        boolean ans = happy(19);
        boolean sol = happyNumber(2);
        System.out.println(ans);
        System.out.println(sol);
    }
}
