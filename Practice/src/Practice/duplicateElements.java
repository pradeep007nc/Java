package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Handler;

public class duplicateElements {
    public static void main(String[] args) {
        int[] question={67,45,23,56,56,45,67,90,78,82,37,80,82};
        int arrSize=question.length;
        HashSet<Integer> repeated=new HashSet<>();
        for(int i=0;i<arrSize;i++){
            repeated.add(question[i]);
        }

        System.out.print(Arrays.toString(repeated.toArray()));
        for(int i=0;i<arrSize;i++){
            if(!(repeated.contains(question[i]))) {
                repeated.remove(question[i]);
            }
        }

        System.out.println(Arrays.toString(repeated.toArray()));
    }

    private static boolean checkEle(int j, ArrayList<Integer> repeatedArray) {
        int size=repeatedArray.size();
        for(int i=0;i<size;i++){
            if (j==repeatedArray.get(i)){
                return false;
            }
        }
        return true;
    }

}
