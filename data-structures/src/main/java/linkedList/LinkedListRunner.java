package linkedList;

public class LinkedListRunner {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtTheEnd(1);
        list.insertAtTheEnd(2);
        list.insertAtTheEnd(3);
        list.insertAtTheEnd(4);
        list.insertAtTheEnd(5);
        list.insertAtTheEnd(6);

        list.print();
        list.printReverse();

    }
}
