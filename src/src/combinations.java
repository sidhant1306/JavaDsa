import java.util.ArrayList;
import java.util.List;

public class combinations {
    public static void main(String[] args) {

//        List<List<Integer>> ans = combinationHelper(4, 2);
//        System.out.println(ans);

//        List<List<Integer>> ans = combinationSum2Helper(candidates, new ArrayList<>(), 0, new ArrayList<>(), 5,0);
//        System.out.println(ans);
    }

    // COMBINATION - 2 PROBLEM LEETCODE :

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


    // COMBINATION PROBLEM LEETCODE :


    public static List<List<Integer>> combinationHelper(int n, int k){
        int[] up = new int[n];

        for(int i = 0; i < n; i++){
            up[i] = i + 1;
        }
        return combination(new ArrayList<>(), up, 0, new ArrayList<>(), k);
    }
    public static List<List<Integer>> combination(List<Integer> p, int[] up, int index, List<List<Integer>> result, int k){
        if(p.size() == k){
            result.add(new ArrayList<>(p));
            return result;
        }

        if(index == up.length) return result;

        p.add(up[index]);

        combination(p, up, index + 1, result, k);

        p.remove(p.size() - 1);
        combination(p, up, index + 1, result, k);

        return result;
    }
}
