public class PrintInRange {
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

    public static void printInRange(Node root,int k1,int k2 ){
        if(root == null){
            return;
        }
        if(root.data >=k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+ " ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printInRange(root.right, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
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

        printInRange(root, 2, 14);
    }
    
}
