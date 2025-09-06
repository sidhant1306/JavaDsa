import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
//        permutation("", "abc");
//
//        System.out.println(permutationCount("", "abc"));
//
//        List<List<Integer>> ans = numberPermutation(new ArrayList<>(),  nums, new ArrayList<>());
//        System.out.println(ans);


//        int[] arr = {1,2,2};
//        Arrays.sort(arr);
//        List<List<Integer>> ans = new ArrayList<>();
//        boolean[] visited = new boolean[arr.length];
//        permutationForDuplicates(new ArrayList<>(), arr, ans, visited);
//        System.out.println(ans);
    }


    // PERMUTATION 2 LEETCODE :


    public static void permutationForDuplicates(List<Integer> p, int[] up, List<List<Integer>> result, boolean[] visited){
        // if we have created a new list p of the same size as up.length then it means that we have iterated over the whole arr
        if(p.size() == up.length){
            result.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < up.length; i++) {

            if(visited[i]) continue;        //if the current element is already visited move to the next element

            if(i > 0 && up[i] == up[i - 1] && !visited[i - 1]) continue;        // i > 0 because we are checking every previous element than the current element so to avoid indexOutOfBounds exception
            // if !visited[i - 1] is done because we always add the previous element(element in the left first)
            // explanation :
            //122           // now if we are at index 2 and we see that the previous element is not visited so we are going to add the previous element first(golden rule : if two elements are duplicate the both are not visited in current recursion call,We choose the left element so ..continue
            p.add(up[i]);       // if it passes the upper condition it means it can be added to the p list
            visited[i] = true;      // mark the current element as visited for the current recursion call

            permutationForDuplicates(p, up, result, visited);

            p.remove(p.size() - 1);     // backtrack by removing the last element of the p list
            visited[i] = false;     // now as the element is removed from the list mark it as false in the visited array

        }
    }


    public static List<List<Integer>> numberPermutation(List<Integer> p, int[] up, List<List<Integer>> result){
        if(up.length == 0){
            result.add(new ArrayList<>(p));
            return result;
        }

        int ch = up[0];
        int[] remaining = Arrays.copyOfRange(up, 1, up.length);
        for (int i = 0; i < p.size() + 1; i++) {
            List<Integer> first = new ArrayList<>(p);
            first.add(i, ch);

            numberPermutation(first, remaining, result);
        }
        return result;
    }


    public static int permutationCount(String p, String up){
        if(up.isEmpty()){
            return 1;           //Whenever the whole string is processed increase the count by 1(count + 1) is this.
        }

        int count = 0;

        char ch = up.charAt(0);

        for (int i = 0; i < p.length() + 1; i++) {

            String first = p.substring(0, i);
            String second = p.substring(i);
            count += permutationCount(first + ch + second, up.substring(1));        //Whenever a function call is called increase the current cound to the count it return 1 + 1..3 + 1..
        }
        return count;
    }


    public static void permutation(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for (int i = 0; i < p.length() + 1; i++) {
            String first = p.substring(0, i);
            String second = p.substring(i);

            permutation(first + ch + second, up.substring(1));
        }
    }
}
