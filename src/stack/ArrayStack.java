public class ArrayStack {
    int[] arr;
    static int top;
    ArrayStack(int size){
        arr = new int[size];
        top = -1;
    }
    //to print the stack
    public void print(){
        System.out.println("Stack is : ");
        for(int i=0;i<=top;i++){
            System.out.println(arr[i]);
        }
    }
    // push into the stack top
    public void push(int item){
        if(isFull()){
            System.out.println("Stack OverFlow ");
            return;
        }
        else{
            arr[++top] = item;
        }
    }

    //pop from the stack top
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack UnderFlow");
            return Integer.MIN_VALUE;
        }
        else{
            return arr[top--];
        }
    }

    //peek the top of the stack
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack Is Empty");
            return Integer.MIN_VALUE;
        }
        else{
            return arr[top];
        }
    }
    // to check stack is full 
    public boolean isFull(){
        if(top==arr.length-1){
            return true;
        }
        return false;   
    }
    //to check if stack is empty
    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        return false;
    }


    
    public static void main(String[] args) {
        ArrayStack s1 = new ArrayStack(5);
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);
        s1.print();
        s1.pop();
        s1.print();


        
    }
    
}
