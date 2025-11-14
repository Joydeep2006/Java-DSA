// 151.Reverse Words in a String
public class ReverseWordsInString{
    public static String revWords(String str){
        StringBuilder sb = new StringBuilder(str);
        StringBuilder ans = new StringBuilder("");
        // reverse the given string so that the words get the correct position
        sb.reverse();
        int n = sb.length();
        for(int i=0;i<n;i++){//=> O(n)
            StringBuilder words = new StringBuilder("");
            // to get the individual words
            while(i<n && sb.charAt(i)!=' '){
                words.append(sb.charAt(i));
                i++;
            }
            // reverse the individual words
            words.reverse();
            // only add them if words are valid 
            if(words.length()>0){
                // to avoid trailing spaces
                if(ans.length()>0){
                    ans.append(" ");
                }
                // append the words after appending spaces
                ans.append(words);
            }        
        }
        return ans.toString();
    }
    public static void main(String[] args){
        String str ="Joydeep Saha";
        System.out.println(str);
        System.out.println(revWords(str));
        
    }
    
}
