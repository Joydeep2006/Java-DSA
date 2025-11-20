public class LongestWord {
    // creating trie
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
    // root of the trie
    public static Node root = new Node();

    // insert strings in the trie
    public static void insert(String s){
        Node curr = root;
        for(int i=0;i<s.length();i++){
            int idx = s.charAt(i) -'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static String ans = "";
    // find the longest word
    public static void findLongest(Node root,StringBuilder temp){
        if(root == null){
            return;
        }
        for(int i=0;i<26;i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                findLongest(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
            
        }

    }
    public static void main(String[] args) {
        String words[] = {"ap" ,"apple" ,"banana" ,"app" ,"a" ,"apply","appl"};
        // insert strings of words in the trie
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        findLongest(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
