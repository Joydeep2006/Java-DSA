public class  BuildBST{

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

    // function to insert Nodes in the BST
    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val>root.data){
            root.right = insert(root.right, val);
        }
        else{
            root.left = insert(root.left,val);
        }
        return root;
    }

    //inorder traversal => always sorted in BST
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int values[] = { 5 , 1 , 3 , 4 , 2 , 7 };
        /*
         *              5
         *            /  \
         *           1    7
         *            \
         *             3
         *              \
         *               4
         */
        Node root = null;
        for(int i=0;i<values.length;i++){
            root = insert(root, values[i]);
        }
        inorder(root); 
    }
}
