package linkedList;

public class LinkedList {

    private Node head;

    class  Node{
        private int data;
        private Node next;

        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.printData();
        System.out.println("Reversing the linkedlist");
        list.reverse();
        list.printData();

    }

    private void reverse() {
        if(head == null || head.next == null){
            return;
        }

        Node nodeBehind = null;
        Node currentNode = head;
        Node nodeAhead = null;

        while(currentNode != null){
            nodeAhead = currentNode.next;
            currentNode.next = nodeBehind;
            nodeBehind = currentNode;
            currentNode = nodeAhead;
            //nodeAhead = nodeAhead!= null?nodeAhead.next:nodeAhead; we dont need this if we init nodeAhead inside while
        }
        head = nodeBehind;
    }

    private void printData() {
        Node temp = head;

        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private void add(int data) {
        if(head == null){
            head = new Node(data);
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(data);
    }
}
