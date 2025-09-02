package BinaryTrees;

public class HeightOfTree {
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

    // function to calculate the height of a tree 
    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);
        return Math.max(lheight,rheight) + 1;

    } 

    // to count the number of nodes in the tree
    public static int count(Node root){
        if(root == null){
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return (leftCount+rightCount+1);
    }

    // to calculate the sum of nodes
    public static int sum(Node root){
        if(root == null){
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return (leftSum + rightSum + root.data);

    }
    

    public static void main(String[] args) {
        /*
                       1
                      / \
                    2     3
                   / \   / \
                  4   5 6   7    
        
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left= new Node(4);
        root.left.right= new Node(5);
        root.right.right= new Node(7);
        root.right.left = new Node(6);

        System.out.println(height(root));
        System.out.println("Total number of Nodes in the tree is : "+count(root));
        System.out.println("Sum of the Nodes of the Tree is : "+sum(root));
    }
}
