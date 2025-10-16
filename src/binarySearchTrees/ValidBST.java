public class ValidBST {
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

    public static boolean isValid(Node root , Node min , Node max){
        if(root == null){
            return true;
        }

        if(min!= null && root.data <= min.data){
            return false;
        }
        else if(max != null && root.data >= max.data){
            return false;
        }

        return isValid(root.left, min,root) && isValid(root.right, root, max);
            
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

        System.out.println(isValid(root,null, null));
    }
}
