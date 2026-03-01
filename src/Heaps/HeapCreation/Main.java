package Heaps.HeapCreation;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();

        heap.insert(38);
        heap.insert(43);
        heap.insert(64);
        heap.insert(4);
        heap.insert(88);

        System.out.println(heap.remove());
        System.out.println(heap.remove());

        // Heap Sort :

        ArrayList<Integer> ans = heap.heapSort();

        System.out.println(ans);
    }
}
