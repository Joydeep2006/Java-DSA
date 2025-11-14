import java.util.*;
public class anargrans {
    public static boolean check(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        else{
        int count=0;
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    count++;
                }

            }
         
        }
        if(count==s1.length()){
            return true;
        }
        else{
            return false;
        }
    }

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter A String");
        String s1=sc.next();
        System.out.println("Enter another String");
        String s2=sc.next();
        if(check(s1,s2)){
            System.out.println(s1+" and "+s2+" are Anargrams");
        }
        else{
            System.out.println(s1+" and "+s2+" are not Anargrams");
        }
        sc.close();
    }
    
}
