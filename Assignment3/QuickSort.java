

import java.util.Arrays;

public class QuickSort {

    public static void quickSortHelper(int[] arr, int left, int right) {
        if(left < right){
            int pivotIndex = pivot(arr, left, right);
            quickSortHelper(arr, left, pivotIndex-1);
            quickSortHelper(arr, pivotIndex+1, right);
        }
        
    }
    public static void quickSort(int[] arr){
        quickSortHelper(arr, 0, arr.length-1);
    }
    public static void swap(int[] arr, int fIndex, int sIndex){
    int tmp = arr[fIndex];
    arr[fIndex] = arr[sIndex];
    arr[sIndex] = tmp;
    }
    public static int pivot(int[] arr, int pivotIndex, int endIndex){
    
        int swapIndex = pivotIndex;
        for (int i = pivotIndex; i <= endIndex; i++) {
            if(arr[pivotIndex] > arr[i]){
                swapIndex++;
                swap(arr, swapIndex, i);
            }
    }
        
        swap(arr, pivotIndex,swapIndex );
        return swapIndex;
    }
   public static void main(String[] args) {
    int [] arr = {4,5,8,3,1,9,23,5,77,11,6};
    quickSort(arr);
    System.out.println(Arrays.toString(arr));
   } 
}
