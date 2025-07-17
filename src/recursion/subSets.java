import java.util.ArrayList;
import java.util.List;

public class subSets {

    public static void main(String[] args) {
//        System.out.println(subSeq("", "abc"));
//        System.out.println(subSeqAscii("", "abc"));


//        List<List<Integer>> ans = subSet(new ArrayList<>(), arr, 0);
//        System.out.println(ans);


//        List<List<Integer>> ans = new ArrayList<>();
//        subseqDuplicate(new ArrayList<>(), arr, ans, 0);
//        System.out.println(ans);


//        List<List<Integer>> ans = subSetDup(new ArrayList<>(), arr, 0, new ArrayList<>());
//        System.out.println(ans);

    }


    //PRINT SUBSETS :

    public static List<List<Integer>> subSetDup(List<Integer> p, int[] up, int index, List<List<Integer>> result){
        result.add(new ArrayList<>(p));

        for(int i = index; i < up.length; i++){
            if(i > index && up[i] == up[i - 1]) continue;

            p.add(up[i]);
            subSetDup(p, up, i + 1, result);

            p.remove(p.size() - 1);

        }
        return result;
    }



    public static void subseqDuplicate(List<Integer> p, int[] nums, List<List<Integer>> result,int index){
        result.add(new ArrayList<>(p));

        for(int i = index; i < nums.length; i++){

            if(i > index && nums[i] == nums[i - 1]) continue;

            p.add(nums[i]);

            subseqDuplicate(p, nums, result, i + 1);

            p.remove(p.size() - 1);

        }

    }



    public static List<List<Integer>> subSet(List<Integer> p, int[] nums, int index){
        if(index == nums.length){
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>(p));
            return base;
        }

        int ch = nums[index];
        p.add(ch);
        List<List<Integer>> left = subSet(p, nums, index + 1);

        p.remove(p.size() - 1);
        List<List<Integer>> right = subSet(p, nums, index + 1);

        left.addAll(right);
        return left;
    }



    public static ArrayList<String> subSeq(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subSeq(p + ch, up.substring(1));   //storing the left side of the tree
        ArrayList<String> right = subSeq(p, up.substring(1));         //storing the right side of the tree

        left.addAll(right);     //Adding both the lists
        return left;            //now we can return any list as both of them contains the same list
    }
}
