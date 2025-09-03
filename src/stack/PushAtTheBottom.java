import java.util.*;
public class PushAtTheBottom {
    public static void pushAtBottom(Stack<Integer> s,int item){
        if(s.isEmpty()){
            s.push(item);
            return;
        }
        int top = s.pop();
        pushAtBottom(s,item);
        s.push(top);
    }
    
    public static void main(String[] args) {
        Stack<Integer>s1 = new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        pushAtBottom(s1,4);
        System.out.println(s1);

    }


    
}
