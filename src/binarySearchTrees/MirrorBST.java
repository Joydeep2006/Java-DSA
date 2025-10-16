public class MirrorBST{

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
    // funtcion to mirror the BST
    public static Node mirror(Node root){
        if(root == null){
            return null;
        }

        Node leftSub = mirror(root.left);
        Node rightSub = mirror(root.right);

        root.left = rightSub;
        root.right = leftSub;

        return root;
    }

    // function to print the BST in inOrder sequence
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+ " ");
        inOrder(root.right);
    }
    
    public static void main(String[] args) {
        Node root = new Node(10);
        /*
         *             10                    
         *           /   \                  
         *          6    15
         *        /  \  /  \
         *       3   8 12   18
         */
        // creating a BST
        root.left = new Node(6);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(8);
        root.right.left = new Node(12);
        root.right.right = new Node(18);
        inOrder(root);
        mirror(root);
         /*
         *             10                    
         *           /    \                  
         *         15      6
         *        /  \   /  \
         *      18   12 8    3
         */
        System.out.println();
        inOrder(root);
        
    }
}