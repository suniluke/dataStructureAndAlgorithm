package linkedList;

import java.util.Objects;

public class DoublyLinkedList {

    //What features it should have
    /*
        * inertBefore
        * insertAfter
        * insertAtPosition
        * removeGivenNode
        * RemoveNodesWithGivenValue
        * setHead
        * setTail
        * containsNodeWithValue
     */
    public class Node{
        Integer value;
        Node prev;
        Node next;

        public Node(Integer value){
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, prev, next);
        }
    }

    private Node head;
    private Node tail;

    //Logic number 2
    // o(n) time | o(1) space
    public boolean containsNodeWithValue2 (Integer value){
        Node node = head;
        while(node != null && node.value != value){
            node = node.next;
        }

        return node != null;
    }

    // o(1) time | o(1) space
    public void removeNode(Node node){
        if(node == null)
            return;
        if(node == head){
            head = head.next;
        }
        if (node == tail){
            tail = tail.prev;
        }
        rmeoveBindings(node);
    }

    // o(1) time | o(1) space
    private void rmeoveBindings(Node node) {
        if(node.prev != null){
            node.prev.next = node.next;
        }
        if(node.next != null){
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = null;
    }

    // o(n) time | o(1) space
    public void removeNodesWithValue (Integer value){
        Node node = head;
        while(node != null){
            Node nodeToRemove = node;
            node = node.next;
            if(nodeToRemove.value == value){
                removeNode(nodeToRemove);
            }
        }
    }

    // o(1) time | o(1) space
    public void insertBefore(Node node, Node nodeToInsert){
        //if theres only one node in the list, don't do anything
        if(nodeToInsert == head && nodeToInsert == tail){
            return;
        }
        //removing if node already exists
        removeNode(nodeToInsert);
        //start adding node before
        nodeToInsert.prev = node.prev;
        nodeToInsert.next = node;
        if(node.prev == null) { //if we are inserting before head
            head = nodeToInsert;
        }else{
            node.prev.next = nodeToInsert;
        }
        node.prev = nodeToInsert;

    }

    // o(1) time | o(1) space
    public void insertAfter(Node node, Node nodeToInsert){
        //if theres only one node in the list, don't do anything
        if(nodeToInsert == head && nodeToInsert == tail){
            return;
        }
        //removing if node already exists
        removeNode(nodeToInsert);
        //start adding node before
        nodeToInsert.prev = node;
        nodeToInsert.next = node.next;
        if(node.next == null){
            tail = nodeToInsert;
        }else{
            node.next.prev = nodeToInsert;
        }
        node.next = nodeToInsert;
    }

    // o(1) time | o(1) space
    private void setHead(Node node) {
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        insertBefore(head, node);
    }

    // o(1) time | o(1) space
    private void setTail(Node node) {
        if(tail == null){
            setHead(node);
            return;
        }
        insertAfter(tail, node);
    }

    // o(n) time | o(1) space
    public void insertAtPostion(Integer position, Node nodeToInsert){
        if(position == 1){ //at head position
            setHead(nodeToInsert);
            return;
        }
        Node node = head;
        Integer currentPosition = 1; //Let's keep index as 1
        while(node != null && currentPosition != position){
            node = node.next;
            currentPosition++;
        }
        if(node != null){
            insertBefore(node, nodeToInsert);
        }else{ //we're at tail
            setTail(nodeToInsert);
        }
    }

    public Node insertAtTheEnd(int value) {
        Node newNode = new Node(value);
        if(head == null){
            setHead(newNode);
            setTail(newNode);
            return newNode;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        return newNode; //just to get the node to test remove functionality
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

}
