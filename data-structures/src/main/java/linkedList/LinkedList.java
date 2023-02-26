package linkedList;

public class LinkedList {

    public void insertAtTheEnd(int value) {
        Node newNode = new Node(value);
        if(head == null){
            setHead(newNode);
            setTail(newNode);
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    private void setTail(Node node) {
        tail = node;
    }

    private void setHead(Node node) {
        head = node;
    }

    public void print() {
        Node node = head;

        while(node != null){
            System.out.print(node.value + " --> ");
            node = node.next;
        }
        System.out.println();
    }

    public void printReverse() {
        Node node = tail;

        while(node != null){
            System.out.print(node.value + " --> ");
            node = node.prev;
        }
        System.out.println();
    }

    private class Node{
        Integer value;
        Node prev;
        Node next;

        public Node(Integer value){
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

}
