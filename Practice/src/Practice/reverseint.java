package practice;

public class reverseint {
    int reverseInt(int x){
        int rev=0;
        int temp=0;
        while(x!=0){
            temp=x%10;
            x=x/10;
            rev=rev*10+temp;
        }
        if(rev >= Math.pow(2,31)-1 || rev <= Math.pow(-2,31)){
            return 0;
        }
        return rev;
    }
}
