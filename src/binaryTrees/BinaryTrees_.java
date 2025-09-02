package BinaryTrees;
import java.util.*;
public class BinaryTrees_ {
    static class Node{
        int data;
        Node left;
        Node right;

        //constructor
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    // to implement Binary tree Structure
    public static class BinaryTree{
        static int idx = -1 ; 
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;

        }

    }
    //display the tree in preorder 
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    //display the tree in-order
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    // display the tree in postorder sequence
    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    // display the tree in level order sequence
    public static void levelorder(Node root){
        if(root == null){
            return;
        }
        
        Queue<Node> qtree = new LinkedList<>();
        qtree.add(root);
        qtree.add(null);

        while(!qtree.isEmpty()){
            Node currNode = qtree.remove();
            if(currNode == null){
                System.out.println();
                if(qtree.isEmpty()){
                    break;
                }
                else{
                    qtree.add(null);
                }
            }
            else{
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    qtree.add(currNode.left);
                }
                if(currNode.right != null){
                    qtree.add(currNode.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        //System.out.println(root.data);
        //preorder(root);
        //inorder(root);
        //postorder(root);
        levelorder(root);

    }  
}
