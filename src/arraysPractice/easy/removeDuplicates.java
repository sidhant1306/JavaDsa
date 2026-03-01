package arraysPractice.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class removeDuplicates {
    ArrayList<Integer> removeDuplicates(int[] arr) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] < arr[i + 1]) list.add(arr[i + 1]);
        }

        return list;
    }
}
