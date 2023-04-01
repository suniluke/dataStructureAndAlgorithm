package linkedList;

public class LinkedListRunner {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtTheEnd(1);
        list.insertAtTheEnd(2);
        list.insertAtTheEnd(3);
        DoublyLinkedList.Node nodeToInsert = list.insertAtTheEnd(4);
        list.insertAtTheEnd(5);
        DoublyLinkedList.Node node = list.insertAtTheEnd(6);

        list.print();
        list.printReverse();

        boolean isPresent = list.containsNodeWithValue2(1);
        System.out.println(isPresent);

        //System.out.println("Removing node: " + node.value);
        //list.removeNode(node);
        //list.removeNodesWithValue(4);
        //list.print();

        //list.insertBefore(node, nodeToInsert);
        //list.print();

        //list.insertAfter(node, nodeToInsert);
        //list.print();
        //list.printReverse();

        nodeToInsert.value = 10;
        list.insertAtPostion(3, nodeToInsert);
        list.print();
    }
}
