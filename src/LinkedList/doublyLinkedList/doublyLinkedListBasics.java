package LinkedList.doublyLinkedList;

public class doublyLinkedListBasics {
    public static void main(String[] args) {
        DLLStructure dll = new DLLStructure();

        dll.insertFirst(78);
        dll.insertFirst(89);
        for (int i = 0; i < 8; i++) {
            dll.insertFirst(i);
        }


        dll.dllDisplay();       // just printing the linked list after inserting nodes at the first position
        dll.dllDisplayReverse();    // printing the linked list in reverse

        dll.dllInsertLast(100);
        dll.dllDisplay();

        dll.insertSpecific(4, 488);
        dll.dllDisplay();
    }
}
