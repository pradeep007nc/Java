package Stack;

public class stack {
    int[] stackArray;
    int topOfStack;
    int arrlen;
    public stack(int size){
        this.stackArray=new int[size];
        this.arrlen=stackArray.length;
        this.topOfStack=-1;
        System.out.println("the stack is created with size "+size);
    }

    public boolean isEmpty(){
        if(topOfStack==-1){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull(){
        if(topOfStack==arrlen-1){
            return true;
        }else{
            return false;
        }
    }

    public void pushValue(int value){
        if(isFull()){
            System.out.print("Stack is Full");
        } else {
            stackArray[topOfStack+1]=value;
            topOfStack++;
            System.out.println("the value is successfully inserted");
        }
    }

    public int popValue(){
        if(isEmpty()){
            System.out.print("Stack is empty");
            return -1;
        }else{
            int topStack=stackArray[topOfStack];
            topStack--;
            return topStack;
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.print("Stack is empty");
            return -1;
        }else{
            return stackArray[topOfStack];
        }
    }

}
