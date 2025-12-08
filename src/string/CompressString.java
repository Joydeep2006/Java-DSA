public class CompressString {
    public static String compress(String str1){
        StringBuilder sb=new StringBuilder("");
        Integer count=1;
        str1=str1.toLowerCase();
        for(int i=0;i<str1.length();i++){
            count=1;  
            while(i<str1.length()-1 && str1.charAt(i)==str1.charAt(i+1)){
              count++;
              i++;
           }
           sb.append(str1.charAt(i));
           if(count>1){
            sb.append(count);
           }
        
        }
        
        return sb.toString();
    }

    //Leetcode Problem 443
    public int compress(char[] chars){
        int idx=0;
        for(int i=0;i<chars.length;i++){
            char ch = chars[i];
            int count =0;
            while(i<chars.length && chars[i]==ch){
                count++;
                i++;
            }
            if(count == 1){
                chars[idx++] = ch;
            }
            else{
                chars[idx++] = ch;
                String str = Integer.toString(count);
                for(int j=0;j<str.length();j++){
                    chars[idx] = str.charAt(j);
                    idx++;
                }
            }
            i--;
        }
        return idx;

    }

    public static void main(String args[]){
        String str1="aaabbcddd";
        System.out.println(compress(str1));

    }
    
}
