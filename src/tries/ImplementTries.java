public class ImplementTries {
    // create Node of trie
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        // constructor to initialise every children idx with null
        public Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }

    }

    // root of the trie
    public static Node root = new Node();

    // Insert in Trie -> O(l)
    public static void insert(String str){
        Node curr = root;
        for(int i=0;i<str.length();i++){
            int idx = str.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();    
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // search words in Trie
    public static boolean search(String str){
        Node curr = root;
        for(int i=0;i<str.length();i++){
            int idx = str.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;

    }
     
    public static void main(String[] args){
        String words[] = {"the" , "a" , "there" , "their" , "any" , "thee"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(search("they"));

        
    }
}
