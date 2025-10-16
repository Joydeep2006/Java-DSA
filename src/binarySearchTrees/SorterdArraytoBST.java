public class SorterdArraytoBST {
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
    // function to create the BST 
    public static Node buildTree(int arr[],int start,int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        Node newNode = new Node(arr[mid]);
        newNode.left = buildTree(arr, start, mid-1);
        newNode.right = buildTree(arr, mid+1, end);
        
        return newNode;
    }

    // function to print the BST in inOrder sequence
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        int arr[] = { 3 , 5 , 6 , 8 , 10 , 11 , 12};
        Node root = buildTree(arr,0,arr.length-1);
        inOrder(root);
    }
}
