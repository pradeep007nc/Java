package Practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Marks {

    public static void main(String[] args) throws FileNotFoundException {

        //to scan data from file and assign values to string
        File file=new File("src/Practice/mks");
        Scanner sc= new Scanner(file);
        String str="";
        while (sc.hasNextLine()){
            str+=sc.nextLine();
            str+="\n";
        }

        //convert to string array and substring last 3 variables
        String[] rawData = str.split("\n");
        for (int i=0;i<rawData.length;i++){
            rawData[i]=rawData[i].substring(rawData[i].length()-3).trim();
        }

        //convert to int array
        int[] marks=new int[rawData.length];
        for (int i=0;i<marks.length;i++){
            marks[i]=Integer.parseInt(rawData[i]);
        }
        System.out.println(Arrays.toString(marks));


      //print percentage
        findPercentage(marks);
    }

    static void findPercentage(int[] arr) {
        int totalMarks=0;
        float percentage=0;
        for(int i=0;i<arr.length;i++){
            totalMarks+=arr[i];
        }
        percentage=totalMarks*100/1000;
        System.out.println("Your total marks is "+totalMarks);
        System.out.printf("Your percentage is %5.2f",percentage);
    }

}

