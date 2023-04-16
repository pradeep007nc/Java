package LLPractice;

import java.util.HashSet;

public class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    public void createLinkedList(int nodeValue){
        Node newNode=new Node();
        newNode.value=nodeValue;
        newNode.next=null;
        head=newNode;
        tail=newNode;
        size=1;
    }

    public void insertNode(int nodeValue){
        Node newNode=new Node();
        newNode.value=nodeValue;
        newNode.next=null;
        tail.next=newNode;
        tail=newNode;
        size++;
    }

    public void traverseLL(){
        Node temp=head;
        for(int i=0;i<size;i++){
            System.out.print(temp.value);
            if(i != size-1){
                System.out.print("->");
            }
            temp=temp.next;
        }
        System.out.print("\n");
    }

    public void deleteDups(LinkedList linkedList){
        Node temp= head;
        Node prev=null;
        for(int i=0;i<size;i++){
            HashSet<Integer> ans=new HashSet<>();
            if(ans.contains(temp.value)){
               int tempval=temp.value;
               temp.previous=temp.next;
               size--;
            }else {
                ans.add(temp.value);
                prev=temp;
            }
            temp=temp.next;
        }
    }
}
