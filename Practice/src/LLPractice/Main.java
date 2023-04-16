package LLPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    //4 {4} {3,1} {2,2} {2,1,1} {1111}
    public static ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    {
        ArrayList<ArrayList<Integer>> container=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ArrayList<Integer> add=new ArrayList<>();
                add.add(j);
                int temp=0;
                temp+=j;
                if(temp==n){
                    container.add(add);
                    add.removeAll(add);
                    temp=0;
                }
            }
        }
        return container;
    }

    public static void main(String args[]) {
        int n=4;
        System.out.print(UniquePartitions(n));
    }
}
