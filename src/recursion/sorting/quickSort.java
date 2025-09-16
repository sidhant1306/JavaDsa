package recursion.sorting;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {23,345,238,438,212,34};
        quickSortAlgo(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // function to sort the array using quickSort :
    public static void quickSortAlgo(int[] arr, int start, int end){
        if(start < end){
            int pivotIndex = pivotFinder(arr, start, end);          // This is the correct index of the pivot

            quickSortAlgo(arr, start, pivotIndex - 1);            // Sorting the left side of the pivot of range starting from the start index and ending just one index before the pivot index
            quickSortAlgo(arr, pivotIndex + 1, end);             // Sorting the right side fo the pivot of range starting from the just next element of the pivot and going till the last index high
        }
    }
    //Function to find the correct index of the pivot element :
    public static int pivotFinder(int[] arr, int low, int high){
        int i = low - 1;    // i = -1 because we need to compare each element at j with the pivot element and then swap the i with j

        int pivot = arr[high];     //Choosing the last element of the array as the pivot index

        for(int j = low; j < high; j++){    // Iterating over each element till the pivot index to compare current j with the value of pivot
            if(arr[j] < pivot){
                i++;                // if the value at j is smaller(which is in left in this case of pivot being at the last index) then just move the i forward and j will automatically be moved an element ahead due to the j++ in the for loop
                swap(arr, i , j);   // now swap i and j because we need to have the element with the smaller value in the left
            }
        }
        swap(arr, i + 1, high); // Now when we have compared each element till high with the pivot element,
        // the i will point to the one position before where j was last smaller than pivot in the left and after that all the elements were found greater than the pivot element
        // so as i = j - 1 so in order to swap pivot value with j we swap it with i + 1;
        return i + 1;       // and we return the correct pivot index
    }
    //Swap function to swap the values by passing their indices
    public static void swap(int[] arr, int i , int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
