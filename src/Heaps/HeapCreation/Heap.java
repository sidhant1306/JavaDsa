package Heaps.HeapCreation;

import java.util.ArrayList;
// THE TREE WE ARE WORKING ON :
// bracket holds the index, and we only are working on indexes, values does not matter.
//                              val(0)
//                             /      \
//                        val(1)         val(2)
//                        /    \           /   \
//                  val(3)      val(4)  val(5)  val(6)

// now parent of index 3 = (index - 1) / 2 => (3 - 1)/2 => 2/2 => 0
// left of index 1 = (index * 2) + 1 => (1 * 2) + 1 => 2+1 => 3
// right of index 1 = (index * 2) + 2 => (1 * 2) + 2 => 2 + 1 => 4


public class Heap<T extends Comparable<T>>{
    // a heap will have an arrayList:
    private ArrayList<T> list;

    public Heap() {
        list = new ArrayList<>();
    }

    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }
    private int left(int index) {
        return index * 2 + 1;
    }
    private int right(int index) {
        return index * 2 + 2;
    }

    public void insert(T value) {
        list.add(value);    // add the new ele at the last
        // call upHeap from the last index
        // we will go bottom to top

        upHeap(list.size() - 1);
    }

    private void upHeap(int index) {
        if(index == 0) return;      // if you are already at the 0th index u cannot go any more up, program over.
        int p = parent(index);      // get the parent of this index.
        // if the parent is greater than the current element, swap :
        if(list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p);     // take the smaller current element to upper position.
            upHeap(p);  // now perform the same thing with the new p(which was our current index previously).
        }
    }

    public T remove() throws Exception {
        if(list.isEmpty()) {
            throw new Exception("removing from an empty list");
        }

        T topMost = list.get(0);        // get the topMost element of the tree(root).

        T last = list.remove(list.size() - 1);     // we will now remove the last element and add it at the topMost position, because last element is the easiest to remove
        // now swap the elements :  // take the last element to the topMost position
        if(!list.isEmpty()) {
            list.set(0, last);
            downHeap(0);    // now as we are going for top to bottom checking for smaller elements and swapping them we perform downHeap.
            // downHeap will check all the children of the tree to find a smaller element than our current root element.
        }
        return topMost;
    }

    private void downHeap(int index) {
        int min = index;    // assume the current index is the smallest index(topMost).
        int left = left(index);
        int right = right(index);

        // if left exists, its index will be less than the total size of the tree so check that along with comparing the current minimum value with its left :

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            // if left is greater than current min :
            min = left;     // change them.
        }

        // now check the same thing for right :

        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            // if right is greater than current min:
            min = right;    // change them.
        }
        // if min is not equal to the index, it means we found either left or right greater than the current element, so perform downHeap
        if(min != index) {
            // swap the smaller element to the min :
            swap(min, index);
            downHeap(min);
        }

    }

    // HEAP SORT :

    // heap sort is just remove all the elements of the list one by one while our list is not empty and add it to another list.
    // elements will get removed in order because they are already sorted in the tree.

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();

        while(!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }

}
