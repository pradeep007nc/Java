package Stack;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=Integer.parseInt(sc.nextLine());
       int[] arr=new int[n];
       int right=n-1;
       int left=0;
       boolean toggle=true;
       for(int i=0;i<n;i++){
           if(toggle){
               arr[left++]=i+1;
               toggle=false;
           }else {
               arr[right--]=i+1;
               toggle=true;
           }
       }
       System.out.print(Arrays.toString(arr));
    }
}
