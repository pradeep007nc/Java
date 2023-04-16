package practice;

public class quickSort {

    public void swap(int[] arr,int a, int b){
        int temp= arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public void sort(int[] arr,int lowindex, int highindex){

        if (lowindex>=highindex){
            return;
        }
        int pivot = arr[highindex];
        int start=lowindex;
        int end=highindex;
        while (start < end){
            while(arr[start] <= pivot && start < end ){
                start++;
            }
            while(arr[end] >= pivot && start < end ){
                end--;
            }
            swap(arr, start, end);
        }
        swap(arr, start, highindex);
        sort(arr, lowindex, start-1);
        sort(arr, start+1, highindex);
    }

    public void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

}
