package Practice;

import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
    doublyLL ll=new doublyLL();
    ll.createLinkedList(5);
    ll.insertLinkedList(12,1);
        ll.insertLinkedList(12,2);
        ll.insertLinkedList(12,3);
        ll.insertLinkedList(12,4);
        ll.insertLinkedList(12,5);
        ll.traverseNode();
        ll.deleteLinkedList(3);
        ll.traverseNode();
        ll.deleteCompleteLL();
        ll.traverseNode();
    }
}


