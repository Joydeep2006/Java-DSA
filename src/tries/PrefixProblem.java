public class PrefixProblem {

    // modified node for the Trie structure freq added
    static class Node{
        Node[] children = new Node[26];
        boolean eow;
        int freq;

        public Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
            eow = false;
            freq = 1;
        }
    }

    public static Node root = new Node();

    // insert words in the trie
    public static void insert(String s){
        Node curr = root;
        for(int i=0;i<s.length();i++){
            int idx = s.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
    }

    // print the shortest unique prefix of the words
    public static void findPrefix(Node root,String ans){
        if(root == null){
            return;
        }

        if(root.freq == 1){
            System.out.print(ans+" ");
            return;
        }
        
        for(int i=0;i<root.children.length;i++){
            if(root.children[i] != null){
                findPrefix(root.children[i], ans+(char)('a'+i));
            }
        }
    }

    public static void main(String[] args) {
        String words[] = {"facebook","amazon","meta","microsoft","netflix","google"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        root.freq = -1;
        findPrefix(root, "");
    }


}
