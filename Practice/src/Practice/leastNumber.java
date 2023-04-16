package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leastNumber {

    int size;
    int[] arr;
    leastNumber(int[] array){
        this.arr=array;
        this.size=arr.length;
    }
    public void printArray(){
        System.out.println(Arrays.toString(arr));
    }

    public List<Integer> convertToList(int[] arr){
        List<Integer> list=new ArrayList<>();
        int count=0;
        for(int items:arr){
            list.add(items);
        }
        return list;
    }

}
