package recursion.sorting;

import java.util.Arrays;

public class mergeSortRecursion {
    public static void main(String[] args) {
        int[] arr = {23,438,2378,123,39,29};
        System.out.println(Arrays.toString(mergeSort(arr)));     // Performing merge sort where we return the sorted copy of the given array
        System.out.println(Arrays.toString(arr));       // This shows that when we return a sorted copy of the given array the original array still remains unsorted

        // In place merge Sorting (Sorting the original array):
        inPlaceMergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    // IN PLACE MERGE SORT :

    public static void inPlaceMergeSort(int[] arr, int start, int end){
        if(start >= end) return;

        int mid = start + (end - start) / 2;
        inPlaceMergeSort(arr, 0, mid);
        inPlaceMergeSort(arr, mid + 1, end);

        inPlaceMerge(arr, start, mid, end);
    }

    public static void inPlaceMerge(int[] arr, int start, int mid, int end){
        int i = start;  //variable to iterate over indices of left unsorted part of the array
        int j = mid + 1;//variable to iterate over indices of right unsorted part of the array

        if(i <= mid && j < arr.length){
            if(arr[i] <= arr[j]){       //if the element in the left position is smaller no need to shift
                i++;
            }
            else{
                int index = j;      //Creating an index like a prop index to shift the element from right to left and it will be reassigned to the element at right whenever we need to shift it as it is assigned to j in the case when the right element which is at j is smaller
                int valueToShift = arr[j];      // It is the element in the right which we need to shift

                while(i < index){
                    arr[index] = arr[index - 1];       //IMPORTANT: we are moving the elements to the right by assigning the previous element(left element) to the current element one by one
                    index--;
                }

                arr[i] = arr[index];
            }
            i++;
            j++;
            mid++;      //so the thing is that we are changing i and j not start and end so the mid won't automatically changed and calculated correctly via the start and end
        }

    }


    // MERGE SORT BY CREATING A NEW ARR:
    public static int[] mergeSort(int[] arr){
        if(arr.length == 1) return arr;

        int mid = arr.length / 2;

        //Taking copy of the array not the original array
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));        //Left part of the array(till mid)
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));   // right part of the array(till end from mid)

        return merge(left, right);
    }

    public static int[] merge(int[] first, int[] second){
        //Function to perform sorting checks and merging the answers
        int[] answer = new int[first.length + second.length];       // new array to hold the values of both the sorted answers

        int i = 0;  // variable to iterate over the indices of first arr
        int j = 0;  // variable to iterate over the indices of second arr
        int k = 0;  // variable to iterate over the indices of the new arr to store the smaller elements at position k

        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                answer[k] = first[i];
                i++;
            }
            else{
                answer[k] = second[j];
                j++;
            }
            k++;
        }
        // Case when one of the array is finished but the other still has elements left :
        while(i < first.length){        // if the first arr has elements remaining add them at the end of the new arr
            answer[k] = first[i];
            i++;
            k++;
        }
        while(j < second.length){
            answer[k] = second[j];
            j++;
            k++;
        }
        return answer;
    }
}


