public class FindMid {
    // public class LinkedList{
        public static class Node{
            int data;
            Node next;
            Node(int data){
                this.data=data;
                this.next = null;
            }
        }
        public static Node head;
        public static Node tail;

        public void addLast(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;    //}
        }
        // to traverse the Linked List 
        public void display(){
            Node temp = head;
            while(temp!= null){
                System.out.print(temp.data+" ->");
                temp = temp.next;
            }
            System.out.println("null");
        }
        // to find the middle of the Linked List 
        public Node findMid(){
            Node slow = head;
            Node fast = head;
            while((fast !=null)&&(fast.next != null)){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    // In the in=built LinkedList we don't have the reference of the Head node directly 
    public static void main(String[] args) {
        FindMid ll = new FindMid();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.display();
        Node mid = ll.findMid();
        System.out.println(mid.data);            
    }
    
}
