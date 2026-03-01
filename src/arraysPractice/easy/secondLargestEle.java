package arraysPractice.easy;

public class secondLargestEle {
    public int getSecondLargest(int[] arr) {
        int largest = -1;
        int secondLargest = -1;


        for(int i : arr) {
            if(i > largest) {
                secondLargest = largest;
                largest = i;
            }
            else if(i < largest && i > secondLargest) secondLargest = i;
        }

        return secondLargest;
    }
}
