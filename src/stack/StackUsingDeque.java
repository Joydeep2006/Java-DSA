import java.util.*;
import java.util.LinkedList;

public class StackUsingDeque{
    Deque<Integer> dq = new LinkedList<>();

    public boolean isEmpty(){
        return dq.isEmpty();
    }

    public void push(int item){
        dq.addLast(item);
    }

    public int pop(){
        if(dq.isEmpty()){
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        }
        return dq.removeLast();
    }

    public int peek(){
        if(dq.isEmpty()){
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        }
        return dq.peekLast();
    }

    public static void main(String[] args){
        StackUsingDeque stk = new StackUsingDeque();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        while(!stk.isEmpty()){
            System.out.print(stk.pop()+" ");
        }  
    }
}