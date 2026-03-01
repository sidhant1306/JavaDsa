package arraysPractice.medium;

import java.util.ArrayList;

public class unionOfSortedArr {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        // as soon as one array is traversed fully, this loop stops:
        while(i != a.length && j != b.length) {
            if(a[i] <= b[j]) {
                if(ans.isEmpty() || ans.get(ans.size() - 1) != a[i]){
                    ans.add(a[i]);
                }
                i++;      // we placed this i++ outside if block because if we get the same element, this i++ won't run
            }
            else {
                if (ans.isEmpty() || ans.get(ans.size() - 1) != b[j]) {
                    ans.add(b[j]);
                }
                j++;
            }
        }

        while(i != a.length) {
            if(ans.get(ans.size() - 1) != a[i]) {
                ans.add(a[i]);
            }
            i++;      // we place this outside to eliminate the risk of infinite loop
        }

        while(j != b.length){
            if(ans.get(ans.size() - 1) != b[j]) {
                ans.add(b[j]);
            }
            j++;
        }
        return ans;
    }
}
