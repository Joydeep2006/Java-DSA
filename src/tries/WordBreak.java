public class WordBreak {
    // node of the prefix-tree
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

    // insert a string in the trie
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

    // search a string in the trie
    public static boolean search(String s){
        Node curr = root;
        for(int i=0;i<s.length();i++){
            int idx = s.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow == true;
    }

    // to check if a string is presernt in form of words 
    public static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            if(search(key.substring(0,i)) && wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String words[] = {"i" , "like" , "samsung" , "mobile" , "sam" , "ice"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        String key = "ilikesamsung";
        System.out.println(wordBreak(key));
    }
}
