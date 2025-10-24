import java.util.*;
public class Merge2BST {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
    // to print the BST in inOrder sequence 
    public static void printInorder(Node root){
        if(root == null){
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
    // to print the BST in PreOrder sequence
     public static void printPreOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    // to get the inOrder sorted sequence of the BST
    public static void getInorder(Node root,ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }
    // to create a BST from the inOrder Sequence
    public static Node createBST(ArrayList<Integer>arr,int start,int end){
        if(start > end){
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, start, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }

    // function to merge the two BST
    public static Node merge(Node root1, Node root2){

        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);
        
        // now merge two sorted array
        int i = 0, j = 0;
        ArrayList<Integer> mergedOrder = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                mergedOrder.add(arr1.get(i));
                i++;
            }
            else{
                mergedOrder.add(arr2.get(j));
                j++;
            }
        }
        // add the leftover elements
        while(i<arr1.size()){
            mergedOrder.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            mergedOrder.add(arr2.get(j));
            j++;
        }
        
        // merger AL -> Balanced BST 
        return createBST(mergedOrder,0, mergedOrder.size()-1);

    }

    public static void main(String[] args) {
         /*
         *               2
         *             /  \
         *            1    4
         */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        /*
         *             9
         *           /  \
         *          3   12
         */
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);
         /*
          *          Merged BST
                        3
                      /  \
                    1     9   
                     \   / \
                      2 4  12 

          */
        printInorder(root1);
        System.out.println();
        printInorder(root2);
        System.out.println();
        Node newroot = merge(root1, root2);
        printPreOrder(newroot);

    }
}
