import java.util.*;
import java.util.LinkedList;
public class StackUsing2Queue {
    Queue<Integer>q1 = new LinkedList<>(); 
    Queue<Integer>q2 = new LinkedList<>(); 

    // to check empty or not 
    public boolean isEmpty(){
        return q1.isEmpty();
    }

    //to add element into the stack 
    public void push(int item){
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        q1.add(item);
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
    }

    //to remove element from the stack
    public int pop(){
        return q1.remove();
    }

    public static void main(String[] args){
        StackUsing2Queue stk = new StackUsing2Queue();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        while (!stk.isEmpty()){
            System.out.println(stk.pop());          
        }
    }
    
}
