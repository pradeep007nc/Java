package practice;

import java.util.HashSet;

public class leetcode_duplicate {
    int length=0;

    public void findSubString(String s){
        int size=s.length();
        HashSet<Character> check=new HashSet<>();
        int count=0;
        int dummy=0;

        for(int i=0;i<size;i++){
            if(check.contains(s.charAt(i))){
                if (dummy<count){
                    dummy=count;
                    count=0;
                }
            }

            check.add(s.charAt(i));
            count++;
        }
        System.out.printf("the largest substring length is %d",dummy);
    }

}
