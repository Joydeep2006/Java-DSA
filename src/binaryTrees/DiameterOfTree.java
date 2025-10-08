package BinaryTrees;
public class DiameterOfTree {
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
    // to implement Binary tree Structure
    public static class BinaryTree{
        static int idx = -1 ; 
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;

        }
    }
    // to return height and diameter at same time
    static class Info{
        int diam;
        int ht;
        Info(int diam,int ht){
            this.diam = diam;
            this.ht = ht;
        }

    }

    public static Info diameter(Node root){ // O(n) -> Time Complexity
        if(root == null){
            return new Info(0,0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(leftInfo.ht + rightInfo.ht +1,Math.max(leftInfo.diam,rightInfo.diam));
        int height = Math.max(leftInfo.ht, rightInfo.ht)+1;

        return new Info(diam,height);

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

        System.out.println("Diameter of the Tree : "+diameter(root).diam);
    }
    
}
