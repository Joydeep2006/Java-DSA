public class AllUniqueSubstrings {
    // node of trie 
    public static class Node{
        Node[] children = new Node[26];
        boolean eow;

        public Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
            eow = false;
        }
    }

    public static Node root = new Node();

    // insert strings in the trie
    public static void insert(String s){
        Node curr = root;
        for(int i=0;i<s.length();i++){
            int idx = s.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // count no. of nodes of the trie / unique prefix
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(root.children[i] != null){
                count += countNodes(root.children[i]);
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        String str = "apple";
        // insert all the suffix 
        for(int i=0;i<str.length();i++){
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println(countNodes(root));
        
    }
}
