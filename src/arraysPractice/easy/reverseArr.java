package arraysPractice.easy;

public class reverseArr {
    public void reverseArray(int arr[]) {
        int i = 0;
        int j = arr.length - 1;

        while(j >= i) {
            int curr = arr[i];
            arr[i] = arr[j];
            arr[j] = curr;
            i++;
            j--;
        }
    }
}
