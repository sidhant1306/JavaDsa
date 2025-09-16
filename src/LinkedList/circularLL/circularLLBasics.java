package LinkedList.circularLL;

public class circularLLBasics {
    public static void main(String[] args) {
        circularLLStr CLL = new circularLLStr();


        CLL.insertFirst(20);
        CLL.insertFirst(4);
        CLL.insertFirst(5);
        CLL.insertFirst(7);
//        CLL.displayCLL();
//        CLL.deleteFirst();
//        CLL.displayCLL();

//        CLL.deletePos(3);
        CLL.displayCLL();
        CLL.deleteValue(5);
        CLL.displayCLL();
    }
}
