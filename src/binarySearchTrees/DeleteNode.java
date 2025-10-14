public class DeleteNode {
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

    public static Node findInOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    // function to delete a Node in BST
    public static Node delete(Node root , int val){
        if(root.data < val){
            root.right = delete(root.right,val);
        }
        else if(root.data > val){
            root.left = delete(root.left,val);
        }
        else{// found the node 
            // case 1 : if the node is a leaf node with no children 
            if(root.left == null && root.right == null){
                return null;
            }
            // case 2 : if the node has single child
            if(root.left == null){ // has right child
                return root.right;
            }
            else if(root.right == null){
                return root.left; // has left child
            }

            // case 3 : both children 
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right,IS.data);
        }
        return root;
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
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

        //inOrder(root);
        delete(root, 12);
        System.out.println();
        inOrder(root);
        
        
    }
    
}
