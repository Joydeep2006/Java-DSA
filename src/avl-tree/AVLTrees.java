
public class AVLTrees {
    // here node has height as its property too
    public static class Node{
        int data,height;
        Node left,right;

        Node(int data){
            this.data = data;
            left = right = null;
            this.height=1;
        }
    }

    public static Node root;
    // function to return the height of a node
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return root.height;
    }
    // to calculate the balance factor 
    public static int getBalance(Node root){
        if(root == null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }
    // to leftRotate
    public static Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;

        // perform rotation 
        y.left = x;
        x.right = T2;

        // update heights
        x.height = Math.max(height(x.left),height(x.right)) + 1;
        y.height = Math.max(height(y.left),height(y.right)) + 1;

        return y;// new root 
    }


    public static Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;

        // perform rotation
        x.right = y;
        y.left = T2;

        // update heights
        x.height = Math.max(height(x.left),height(x.right)) + 1;
        y.height = Math.max(height(y.left),height(y.right)) + 1;

        return x; // new root 

    }
    // function to insert Node in a AVL tree
    public static Node insert(Node root,int key){
        if(root == null){
            return new Node(key);
        }
        if(key<root.data){ // insert in the left subtree
            root.left = insert(root.left, key);
        }
        else if(key > root.data){ // insert in the right subtree
            root.right = insert(root.right, key);
        }
        else{ // duplicate elements are not allowed so return the root
            return root;
        }
        // update the root height
        root.height = 1 + Math.max(height(root.left),height(root.right));

        // get the balance factor
        int bf = getBalance(root);

        // left - left case 
        if(bf > 1 && key < root.left.data){
            return leftRotate(root);
        }
        // right - right case
        if(bf < -1 && key > root.right.data){
            return leftRotate(root);
        }
        // left - right case
        if(bf > 1 && key > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // right - left case
        if(bf < -1 && key < root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;

    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /*
                 AVL Tree Created 
                      30
                    /   \
                  20    40
                /   \     \
              10    25    50
         */

        preOrder(root);
    }
}   
