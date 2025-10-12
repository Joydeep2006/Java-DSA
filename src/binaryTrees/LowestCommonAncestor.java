import java.util.*;
public class LowestCommonAncestor {
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


    // another approach to get lowest common ancestor 
    public static Node lca1(Node root, int n1,int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftLca = lca1(root.left,n1,n2);
        Node rightLca = lca1(root.right,n1,n2);

        if(leftLca == null){
            return rightLca;
        }
        if(rightLca == null){
            return leftLca;
        }

        return root;

    }
    // function to get the path to that node from the root node
    public static boolean getPath(Node root,int key,ArrayList<Node>path){
        if(root == null){
            return false;
        }

        path.add(root);
        if(root.data == key){
            return true;
        }
        
        if((getPath(root.left,key,path))||(getPath(root.right,key,path))){
            return true;
        }
        path.remove(path.size()-1);
        return false;

    }
    // function to find the lowest common ancestor 
    public static Node lca(Node root,int n1,int n2){
        ArrayList<Node>path1 = new ArrayList<>();
        ArrayList<Node>path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i;
        for(i=0;i<path1.size()&&i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        
        return path1.get(i-1);

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

        System.out.println(lca1(root,6,7).data);

    }
    
}
