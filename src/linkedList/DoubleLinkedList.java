public class DoubleLinkedList {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }   
    }

    public static Node head;
    public static Node tail;
    public static int size;
    // add node at First
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode; 
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // add Node last
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head = tail = newNode;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;

    } 

    // to print the LinkedList
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // to remove first node 
    public void remFirst(){
        if(head == null){
            System.out.println("Linked List is Empty");
            return ;
        }

        if(size == 1){
            head = tail = null;
        }

        head = head.next;
        head.prev = null;
        size--;
    }

    // to remove last node 
    public void remLast(){
        if(head == null){
            System.out.println("Linked List is Empty");
            return ;
        }

        if(size == 1){
            head = tail = null;
        }
        
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    // to reverse a Linked List 
    public static void main(String[] args){
        DoubleLinkedList dlll = new DoubleLinkedList();
        dlll.addFirst(1);
        dlll.addLast(2);
        dlll.addLast(3);
        dlll.addLast(4);
        dlll.addLast(5);
        dlll.print();
        //dlll.remLast();
        //dlll.revList();

        dlll.print();     
    }
}
