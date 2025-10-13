public class SumTree {
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

    // function to replace Tree with Sum tree
    public static int sumTree(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);

        int temp = root.data;
        root.data = leftSum+rightSum;

        return temp+leftSum+rightSum;

    }

    //preorder traversal
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
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

        preOrder(root);
        sumTree(root);
        System.out.println();
        preOrder(root);
    }
    
}
