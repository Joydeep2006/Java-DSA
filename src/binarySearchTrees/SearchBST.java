public class SearchBST {
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
    // search in BST using loop & it will return the Node of the key
    public static Node search1(Node root,int key){
        if(root == null){
            return root;
        }
        while(root != null){
            if(root.data == key){
                return root;
            }
            else if(key < root.data){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return null;    
    }
    // function to seach in the BST -- Time Complexity => O(Height of Tree)-- Recurison
    public static boolean search(Node root,int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(key<root.data){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
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
        
        System.out.println(search(root, 2));
        



    }
    
}
