public class KthAncerstor {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int kAncerstor(Node root,int node,int k){
        if(root == null){
            return -1;
        }
        if(root.data == node){
            
            return 0;
        }
        int leftDist = kAncerstor(root.left, node, k);
        int rightDist = kAncerstor(root.right, node, k);
        if(leftDist == -1 && rightDist == -1){
            return -1;
        }
        int maxDist = Math.max(leftDist,rightDist);
        if(maxDist+1 == k){
            System.out.println(root.data);
        }
        return maxDist+1;
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

        kAncerstor(root, 7, 1);

        

    }
    
}
