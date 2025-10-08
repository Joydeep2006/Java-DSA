package BinaryTrees;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopView {
    static class Node{
        int data;
        Node left;
        Node right;

        //constructor
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    static class Info{
        int hd;
        Node node;
        public Info(Node node,int hd){
            this.node = node;
            this.hd = hd;

        }
    }

    public static void topView(Node root){
        // level Order Traversal 
        Queue<Info>q = new LinkedList<>();
        HashMap<Integer,Node>map = new HashMap<>();

        int min=0,max=0;

        q.add(new Info(root,0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(!map.containsKey(curr.hd)){ // checking if its horizontal distance is present
                    map.put(curr.hd,curr.node);
                }
                if(curr.node.left!=null){ // add its left child 
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new Info(curr.node.right,curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }

            }

            
        }

        // print the top view
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        /*
                       1
                      / \
                    2     3
                   / \   / \
                  4   5 6   7    
        
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left= new Node(4);
        root.left.right= new Node(5);
        root.right.right= new Node(7);
        root.right.left = new Node(6);

        topView(root);


        
    }
}
