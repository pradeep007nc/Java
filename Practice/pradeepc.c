#include<stdio.h>
#include<stdbool.h>

typedef struct{
    int top;
    char arr[10];
}stack;

bool isFull(stack *ptr){
    if(ptr->top==sizeof(ptr->arr)-1){
        return true;
    }
    return false;
}

bool isEmpty(stack *ptr){
    if(ptr->top==-1){
        return true;
    }
    return false;
}

void push(stack *ptr,char val){
    if(!isFull(ptr)){
        ptr->top++;
        ptr->arr[ptr->top]=val;
        printf("\nPushed to Stack");
    }else{
        printf("\nnahi ho payega bhai, jagah nahi hai");
    }  
}

int pop(stack *ptr){
    int val=0;
    if(!isEmpty(ptr)){
        val=ptr->arr[ptr->top];
        ptr->top--;
        printf("\npopped sucessfully");
    }
    return val;
}

void displayStack(stack *ptr,int size){
    for(int i=0;i<=size;i++){
      printf("\nelement %d: %d",i,ptr->arr[i]);
    }
}

bool checkExpression(stack *ptr, char str[],int size){
    int count=0;
    for(int i=0;i<size;i++){
        if(count<0){
            return false;
        }
        if(str[i]=='}' || str[i]==']' || str[i]==')'){
            pop(ptr);
            count--;
        }else if(str[i]=='{' || str[i]=='[' || str[i]=='('){
            push(ptr,str[i]);
            count++;
        }
    }
    if(count==0){
        return true;
    }
    return false;
}


int main(){
    stack s1;
    s1.top=-1;
    char str[]="{[()]}";
    int size=sizeof(str);
  
    if(checkExpression(&s1,str,size)){
        printf("\nIts a valid expression");
    }else{
        printf("\nit is not a valid expression");
    }
    return 0;
}