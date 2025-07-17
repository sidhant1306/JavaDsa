import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        permutation("", "abc");

        System.out.println(permutationCount("", "abc"));

        List<List<Integer>> ans = numberPermutation(new ArrayList<>(),  nums, new ArrayList<>());
        System.out.println(ans);


//        int[] arr = {3,3,0,3};
//        Arrays.sort(arr);
//        List<List<Integer>> ans = new ArrayList<>();
//        boolean[] visited = new boolean[arr.length];
//        permutationForDuplicates(new ArrayList<>(), arr, ans, visited);
//        System.out.println(ans);
    }


    // PERMUTATION 2 LEETCODE :


    public static void permutationForDuplicates(List<Integer> p, int[] up, List<List<Integer>> result, boolean[] visited){
        if(p.size() == up.length){
            result.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < up.length; i++) {

            if(visited[i]) continue;

            if(i > 0 && up[i] == up[i - 1] && !visited[i - 1]) continue;

            p.add(up[i]);
            visited[i] = true;

            permutationForDuplicates(p, up, result, visited);

            p.remove(p.size() - 1);
            visited[i] = false;

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
}
