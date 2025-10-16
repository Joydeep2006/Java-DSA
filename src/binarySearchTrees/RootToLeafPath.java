import java.util.*;
public class RootToLeafPath {
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

    // function to print the ArrayList
    public static void printPath(ArrayList<Integer>path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+" -> ");
        }
        System.out.println("null");

    }

    // function to print all the paths from root to ledf
    public static void getPath(Node root,ArrayList<Integer>path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }

        getPath(root.left, path);
        getPath(root.right, path);
        path.remove(path.size()-1);
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

        getPath(root, new ArrayList<>());
        
    }
}
