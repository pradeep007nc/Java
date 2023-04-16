package Practice;

public class doublyLL {
    Node head;
    Node tail;
    int size;

    public Node createLinkedList(int nodeValue){
        head=new Node();
        Node newNode=new Node();
        newNode.value=nodeValue;
        newNode.next=null;
        newNode.previous=null;
        head=newNode;
        tail=newNode;
        size=1;
        System.out.println("Node has been created "+newNode.value+" is the value");
        return head;
    }

    public void insertLinkedList(int nodeValue, int location){
        Node newNode=new Node();
        newNode.value=nodeValue;
        if(head==null){
            System.out.println("Linked List doesnt exist");
            createLinkedList(nodeValue);
            return;
        } else if (location==0) {
            newNode.next=head;
            newNode.previous=null;
            head.previous=newNode;
            head=newNode;
        } else if (location>=size) {
            newNode.next=null;
            tail.next=newNode;
            newNode.previous=tail;
            tail=newNode;
        } else {
            Node tempNode=head;
            int index=0;
            while (index<location-1){
                tempNode=tempNode.next;
                index++;
            }
            newNode.previous=tempNode;
            newNode.next=tempNode.next;
            tempNode.next=newNode;
            newNode.next.previous=newNode;
            System.out.println("Node "+newNode.value+" has been inserted in in "+location+" location");
        }
       size++;
    }

    public void traverseNode(){
        if(head!=null){
            Node tempNode=head;
            for (int i=0;i<size;i++){
                System.out.print(tempNode.value);
                if(i!=size-1){
                    System.out.print("->");
                }
                tempNode=tempNode.next;
            }
        }else {
            System.out.println("doubly linked list doesnt exist");
        }
        System.out.println("\n");
    }

    public void reverseTraverse(){
        if(head!=null){
            Node temp=tail;
            for (int i=0;i<size;i++){
                System.out.print(temp.value);
                if(i!=size-1){
                    System.out.print("<-");
                }
                temp=temp.previous;
            }
        }else {
            System.out.print("doubly linked list doesnt exist");
        }
        System.out.print("\n");
    }

    public boolean searchNode(int nodeValue){
        if(head!=null){
            Node temp=head;
            for(int i=0;i<size;i++) {
                if (temp.value == nodeValue) {
                    System.out.println("node found at location" + i);
                    return true;
                }
                temp = temp.next;
            }
        }
        System.out.println("node not found");
        return false;
    }

    public void deleteLinkedList(int location){
        if(head==null){
            System.out.println("Linked List doesnt Exist");
            return;
        } else if (location==0) {
            if(size==1){
                head=null;
                tail=null;
                size--;
                return;
            } else {
                head=head.next;
                head.previous=null;
                size--;
            }
        }else if(location >= size){
           Node temp=tail.previous;
            if(size==1){
                head=null;
                tail=null;
                size--;
                return;
            }else {
                temp.next=null;
                tail=temp;
                size--;
            }
        }else {
            Node temp=head;
            for(int i=0;i<location-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
            temp.next.previous=temp;
            size--;
        }
    }

    public void deleteCompleteLL(){
        head=null;
        tail=null;
        System.out.println("LinkedList is deleted");
        return;
    }

}
